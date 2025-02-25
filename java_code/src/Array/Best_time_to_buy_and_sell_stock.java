package Array;

public class Best_time_to_buy_and_sell_stock { //leetcode problem no:121

    public static int maxProfit(int[] prices){
        int buy = 0;
        int max_profit = 0;
        for(int i=0; i<prices.length; i++){
            if(i==0){
                buy = prices[i];
            }else{
                buy = Math.min(buy, prices[i]);
            }

            if(buy < prices[i]){
                int current_profit = prices[i]-buy;
                max_profit = Math.max(max_profit, current_profit);
            }
        }

        return max_profit;
    }

}
