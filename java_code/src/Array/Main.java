package Array;

public class Main {

    public static void main(String[] args) {

//        int maxArea = Container_with_maximum_water.maxArea(new int[]{1,8,6,2,5,4,8,3,7});
//        System.out.println("Max Area : "+ maxArea);

//        int profit = Best_time_to_buy_and_sell_stock.maxProfit(new int[]{2,4,1});
//        System.out.println("Profit : "+profit);

        int[] productArr = Product_of_array_except_self.productExceptSelf(new int[]{1,2,3,4});
        for(int i : productArr){
            System.out.print(i + ",");
        }

    }

}
