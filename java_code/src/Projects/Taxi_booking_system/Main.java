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
    }

    private static void bookTaxi() {
    }

    public static void initializeTaxis(int n){
        for(int i=1; i<=n; i++){
            taxis.add(new Taxi(i));
        }
    }

    

}
