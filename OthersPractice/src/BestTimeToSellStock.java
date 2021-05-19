/**
 * LeetCode 121
 */
public class BestTimeToSellStock {
    public static void main(String[] args){
        int[] prices = {1,2,3,4,5,2,7,8,10};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices){
        int maxProfit = 0;
        for(int i = 0; i<prices.length-1; i++){
            for(int j = i+1; j<prices.length; j++){
                int profit = prices[j] - prices[i];
                if(profit > maxProfit){
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }
}
