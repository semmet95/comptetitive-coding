// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

public class BuySellStock {
    public int maxProfit(int[] prices) {
        int maximumProfit = 0, buyDay = 0;
        
        for(int day = 1; day < prices.length; day++) {
            if(prices[day] - prices[buyDay] > maximumProfit) {
                maximumProfit = prices[day] - prices[buyDay];
            } else if(prices[day] < prices[buyDay]) {
                buyDay = day;
            }
        }

        return maximumProfit;
    }
}