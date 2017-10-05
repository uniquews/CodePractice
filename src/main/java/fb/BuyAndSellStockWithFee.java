package fb;

public class BuyAndSellStockWithFee {
    /**
     * f[i]: 第i天手里有股票的最大收益
     * g[i]: 第i天手里没有股票的最大收益
     *
     * f[i] = max(g[i - 1] - a[i] - fee, f[i - 1])
     * g[i] = max(f[i - 1] + a[i] - fee, g[i - 1])
     *
     * f[0] = - a[0] - fee
     * g[0] = 0
     * */
    public int maxProfit(int[] a, int fee) {
        int[] f = new int[a.length];
        int[] g = new int[a.length];

        f[0] = -a[0] - fee;
        g[0] = 0;

        for (int i = 1; i < a.length; i++) {
            f[i] = Math.max(g[i - 1] - a[i] - fee, f[i - 1]);
            g[i] = Math.max(f[i - 1] + a[i] - fee, g[i - 1]);
        }
        return g[a.length - 1];
    }

    public static void main(String[] args) {
//        int[] a = {1,100}; // 买和卖都有fee。。。
//        int fee = 20;
//        int[] a = {100, 1};
//        int fee = 20;
        int[] a = {1,20,50,30,60};
        int fee = 1;
        BuyAndSellStockWithFee test = new BuyAndSellStockWithFee();
        System.out.print(test.maxProfit(a, fee));
    }
}
