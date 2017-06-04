/**
 * Created by shuaiwang on 6/3/17.
 */
public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        int[] f = new int[n + 1];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            int sum = 0;
            int nonRootNode = i - 1;
            for (int j = 0; j < i; j++) {
                sum += f[j] * f[nonRootNode - j];
            }
            f[i] = sum;
        }
        return f[n];
    }

    public static void main(String[] args) {
        int n = 3;
        UniqueBinarySearchTrees test = new UniqueBinarySearchTrees();
        test.numTrees(n);
    }
}
