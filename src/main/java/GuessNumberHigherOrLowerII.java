/**
 * Created by shuaiwang on 4/14/17.
 */

/*
*
* minmax 算法在这里的意思是说：
* 每次在考虑猜哪个数字的时候，遍历所有可能被猜到的数字，每一个数字都会对应一个总cost，Min的意思是保证我迭代完所有能取到的数字之后，用最小cost的猜法
*
* max的意思是：我现在已经猜了一个数字k，那么target可在小于k或者大于k。我总是要扔掉那个cost比较小的情况，然后再进行下一次guess。比如
* 我这次猜的是3，假设3的右边有100个数，3的左边只有2个数，我一定要假设我的target是在3的右边，因为这样算出来的最小值才是能保证我无论这个target在
* 哪里，都可以找到target。
*
* **/

public class GuessNumberHigherOrLowerII {
    public int getMoneyAmount(int n) {
        int[][] f = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                f[i][j] = Integer.MAX_VALUE;
            }
            f[i][i] = 0; //只有一个数字肯定不需要pay
        }

        for (int len = 2; len <= n; len++) {
            for (int start = 1; start <= n - len + 1; start++) {
                int end = start + len - 1;
                for (int k = start; k <= end; k++) {
                    if (k == start) {
                        f[start][end] = Math.min(f[start][end], f[k + 1][end] + k);
                    } else if (k == end) {
                        f[start][end] = Math.min(f[start][end], f[start][k - 1] + k);
                    } else {
                        f[start][end] = Math.min(f[start][end], Math.max(f[start][k - 1], f[k + 1][end]) + k);
                    }
                }
            }
        }
        return f[1][n];
    }
}
