/**
 * Created by shuaiwang on 9/4/17.
 */
public class BestTimeBuyAnsSellStockV {
    /**
     * 还是股票，可以随便交易很多次，可以同时买很多股票，但是一旦卖就要把手里的股票全部卖了，
     * 问怎样最大化收益。比如[1, 2,3], 前2天都买，第三天全部卖，收益就是(3-1)+(3-2). （
     * 基本思路是不停的找最大值，找到最大值就卖，然后再从最大值后面开始处理，最后能优化成O(N)）
     *
     *
     * 这道题是要找每一个数右边的最大值
     * 相比较Histogram那道题是找左边和右边第一个比自己小的值
     * */
    public int maxProfit(int[] prices) {
        // write your code here
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int profit = 0, max = 0;
        for (int i = prices.length; i >= 0; i--) {
            if (prices[i] < max) {
                profit += max - prices[i];
            } else {
                max = prices[i];
            }
        }
        return profit;
    }
}
