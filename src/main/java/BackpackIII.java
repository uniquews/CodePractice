public class BackpackIII {
    public int backPackIII(int[] A, int[] V, int m) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }

        int[] f = new int[m + 1];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j <= m; j++) {
                for (int k = 0; A[i] * k <= j; k++) {
                    f[j] = Math.max(f[j], f[j - A[i] * k] + V[i] * k);
                }
            }
        }
        return f[m];
    }
}
