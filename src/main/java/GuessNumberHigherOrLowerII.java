import java.util.Arrays;

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
        int[][] cache = new int[n][n];

        for (int i = 0; i < cache.length; i++) {
            Arrays.fill(cache[i], Integer.MAX_VALUE);
        }
        return dfs(1, n, cache);
    }

    private int dfs(int start, int end, int[][] cache) {
        if (start >= end) {
            return 0;
        }

        if (cache[start - 1][end - 1] != Integer.MAX_VALUE) {
            return cache[start - 1][end - 1];
        }

        int tmp = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            tmp = Math.min(Math.max(dfs(start, i - 1, cache), dfs(i + 1, end, cache)) + i, tmp);
        }
        cache[start - 1][end - 1] = tmp;
        return tmp;
    }
}
