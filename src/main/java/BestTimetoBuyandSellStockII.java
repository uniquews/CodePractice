/**
 * Created by shuaiwang on 10/12/16.
 */
public class BestTimetoBuyandSellStockII {
    public int maxProfit(int[] prices) {
        // write your code here
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int result = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i - 1] > 0) {
                result += prices[i] - prices[i - 1];
            }
        }
        return result;
    }
}
