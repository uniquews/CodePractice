/**
 * Created by shuaiwang on 5/23/17.
 */
public class DropEggs {

    /**
     * dp solution:
     *
     * 状态转移方程：f[n] = min{ 1+max(i-1,f[n-i]) | i=1..n }
        初始条件: f[0]=0（或f[1]=1）

     枚举从1到k的每一层楼作为当前扔鸡蛋的楼层，对于每一层楼有两种情况会发生，鸡蛋破或者不破，我们要取其中的最坏情况
     然后再从枚举的1到k层的最坏情况中取最小值

     lintcode会TLE
     * */
    public int dropEggs(int n) {
        // Write your code here
        int[] f = new int[n + 1];
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            int tmp = Integer.MAX_VALUE;
            for (int j = 1; j <= i; j++) {
                tmp = Math.min(tmp, 1 + Math.max(j - 1, f[i - j]));
                f[i] = tmp;
            }
        }
        return f[n];
    }

    public int dropEggs1(int n) {
        // Write your code here
        long ans = 0;
        for (int i = 1; ; ++i) {
            ans += (long)i;
            if (ans >= (long)n)
                return i;
        }
    }

    public static void main(String[] args) {
        int n = 100;
        DropEggs test = new DropEggs();

        System.out.println(test.dropEggs(n));
        System.out.println(test.dropEggs1(n));
    }
}
