/**
 * Created by shuaiwang on 10/12/16.
 */

// prices[ ] =  1,2,4,2,5,7,2,4,9
public class BestTimetoBuyandSellStockIII {
    public int maxProfit(int[] prices) {
        // write your code here
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int result = 0;
        int[] left = new int[prices.length];
        int[] right = new int[prices.length];

        left[0] = 0;
        int minVal = prices[0];
        for (int i = 1; i < prices.length; i++) {
            left[i] = Math.max(left[i - 1], prices[i] - minVal);
            minVal = Math.min(minVal, prices[i]);
        }

        right[prices.length - 1] = 0;
        int maxVal = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], maxVal - prices[i]);
            maxVal = Math.max(maxVal, prices[i]);
            result = Math.max(result, right[i] + left[i]);
        }
        return result;
    }
}
