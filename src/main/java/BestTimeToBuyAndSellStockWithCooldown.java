/**
 * Created by shuaiwang on 4/12/17.
 */


/**
 *
 * buy[i] = max(sell[i-2]-price, buy[i-1])
 * sell[i] = max(buy[i-1]+price, sell[i-1])
 *
 *
 * buy[i]表示以 index=i 天结尾的，最后一个操作是buy的最大profit。buy[i]可以被表示成两种情况：1. 第i天不买，即buy[i - 1] 2. 第i天买
 * 那么i - 1天必须是cooldown， 且i - 2 天不能是以buy操作为结尾（因为买下一支股票前必须要卖光之前的股票），所以是sell[i - 2] - price[i]
 * （忽略cooldown day的profile， 因为cooldown 是不会影响profit）
 *
 * 同理sell[i]表示以 Index=i 天结尾的，最后一个操作是selle的最大profie。sell[i]可以被表示成两种情况1. 第i天不卖，即sell[i - 1]。 第i天卖
 * 那么i - 1天必须是买操作，所以是buy[i - 1] + price （同理忽略cooldown day profil）
 *
 * 这个cooldown 1 day 操作基本上只有在说明在buy[i]有可能从 sell[i-2]-price 得到而不是 sell[i-1]-price。。假设这道题变成了cool down 2天，
 * 只需要把这个sell[i - 2]变成sell[i - 3]即可。
 *
 * 初始化有buy[0] sell[0]，当然sell[0] = 0因为第0天卖啥也是 0 收益 （实力不理解为什么各种答案拐弯抹角的初始化一个Integer.min）
 * 由于cooldown 导致sell[i - 2]的存在，我们还要初始化一个sell[1]，这样让buy数组从i = 2开始算
 *
 * buy[1] 初始化也是遵循这个递归式。第一天买股票要么就是第0天买了 -price[0] 要么就是第一天买了，取个最大值
 *
 * */
public class BestTimeToBuyAndSellStockWithCooldown {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0 || prices.length == 1) {
            return 0;
        }
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];

        buy[0] = -prices[0]; // 第0天买股票所以profit相当于是负的
        sell[0] = 0;
        buy[1] = Math.max(-prices[1], buy[0]);

        for (int i = 1; i < prices.length; i++) {
            sell[i] = Math.max(buy[i - 1] + prices[i], sell[i - 1]);
            if (i != 1) {
                buy[i] = Math.max(sell[i - 2] - prices[i], buy[i - 1]);
            }
        }
        return sell[prices.length - 1];
    }
}
