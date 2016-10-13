package main;

/**
 * Created by shuaiwang on 10/12/16.
 */
public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        // write your code here
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int result = 0;
        int minVal = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            result = Math.max(result, prices[i] - minVal);
            minVal = Math.min(minVal, prices[i]);
        }
        return result;
    }
}
