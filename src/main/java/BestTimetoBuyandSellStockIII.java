/**
 * Created by shuaiwang on 10/12/16.
 */

// prices[ ] =  1,2,4,2,5,7,2,4,9
public class BestTimetoBuyandSellStockIII {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int[] left = new int[prices.length];
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            left[i] = Math.max(left[i - 1], prices[i] - min);
            min = Math.min(min, prices[i]);
        }

        int[] right = new int[prices.length];
        int maxVal = prices[prices.length - 1];
        int result = 0;
        for (int i = prices.length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], maxVal - prices[i]);
            maxVal = Math.max(maxVal, prices[i]);
            result = Math.max(result, left[i] + right[i]);
        }
        return result;
    }


    public static void main(String[] args) {
        BestTimetoBuyandSellStockIII test = new BestTimetoBuyandSellStockIII();
        // [2,1,4,5,2,9,7]
        int[] a = {2,1,4,5,2,9,7};
        test.maxProfit(a);
    }
}
