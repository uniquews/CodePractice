/**
 * Created by shuaiwang on 3/18/17.
 */
public class PaintFence {
    public int numWays(int n, int k) {
        if (n == 0 || k == 0) {
            return 0;
        }
        if (n == 1) {
            return k;
        }
        if (n == 2) {
            return k * k;
        }
        return n * (dfs(3, k, k - 1, n) + dfs(3, k, 1, n));
    }

    private int dfs(int level, int k, int parent, int n) {
        if (level == n && parent == k - 1) {
            return (k - 1) + 1;
        } else if (level == n && parent == 1) {
            return k - 1;
        }

        if (parent == k - 1) {
            int current1 = k - 1;
            int current2 = 1;
            int tmp1 = current1 * dfs(level + 1, k, k - 1, n);
            int tmp2 = current2 * dfs(level + 1, k, 1, n);
            return tmp1 + tmp2;
        } else { // parent == 1
            int current = k - 1;
            return current * dfs(level + 1, k , k - 1, n);
        }
    }

    public static void main(String[] args) {
        PaintFence test = new PaintFence();
        test.numWays(3, 2);
    }
}
