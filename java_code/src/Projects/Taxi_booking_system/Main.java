package Projects.Taxi_booking_system;

import java.sql.SQLOutput;
import java.util.*;

public class Main {

    static List<Taxi> taxis = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static int customerCount = 1;

    public static void main(String[] args) {
        System.out.print("Enter number of taxis you want : ");
        int numberOfTaxis = sc.nextInt();

        initializeTaxis(numberOfTaxis);

        while(true){
            System.out.println("\n1. Book taxi\n2. Display taxi details\n3. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> bookTaxi();
                case 2 -> displayTaxiDetails();
                case 3 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice...Try again");
            }
        }
    }

    private static void displayTaxiDetails() {
        for(Taxi taxi : taxis){
            System.out.println("Taxi-" + taxi.id + " Total earnings: Rs." + taxi.totalEarnings);
            // - left alignment, 10-width of space for string, if no text-padding
            System.out.printf("%-10s %-10s %-5s %-5s %-12s %-9s %-6s %n",
                    "BookingID", "CustomerID", "From", "To", "PickupTime", "DropTime", "Amount");
            // d-for integer, c-character
            for(Booking booking : taxi.bookings){
                System.out.printf("%-10d %-10d %-5c %-5c %-12d %-9d %-6d %n",
                        booking.bookingID, booking.customerID, booking.from, booking.to, booking.pickupTime, booking.dropTime, booking.amount);
            }
        }
    }

    private static void bookTaxi() {
        int customerId = customerCount++;
        System.out.println("Enter pickup point (A-F): ");
        char pickup = sc.next().toUpperCase().charAt(0);
        System.out.println("Enter drop point (A-F): ");
        char drop = sc.next().toUpperCase().charAt(0);
        System.out.println("Enter pickup time (in hours): ");
        int pickupTime = sc.nextInt();

        Taxi selectedTaxi = null;
        int minDistance = Integer.MAX_VALUE;
        for(Taxi taxi : taxis){
            //check taxi is available at required pickup time
            if(taxi.isAvailable(pickupTime)){
                //distance b/w current location to pickup point
                int distance = Math.abs(taxi.currentPoint - pickup);
                //select taxi with min distance or low earnings if distance are equal
                if(distance < minDistance || (distance == minDistance && taxi.totalEarnings < selectedTaxi.totalEarnings)){
                    selectedTaxi = taxi;
                    minDistance = distance;
                }
            }
        }

        if(selectedTaxi == null){
            System.out.println("Booking rejected. No taxis available");
            return;
        }

        int dropTime = pickupTime + Math.abs(drop-pickup);
        int amount = selectedTaxi.calculateEarnings(pickup, drop);
        int bookingId = selectedTaxi.bookings.size()+1;

        Booking booking = new Booking(bookingId, customerId, pickupTime, dropTime, amount, pickup, drop);
        //Add the new booking to the selected taxi
        selectedTaxi.addBooking(booking);
        System.out.println("Taxi-" + selectedTaxi.id + " is allocated.");
    }

    public static void initializeTaxis(int n){
        for(int i=1; i<=n; i++){
            taxis.add(new Taxi(i));
        }
    }

    

}
