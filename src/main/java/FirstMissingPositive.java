public class FirstMissingPositive {
    public int firstMissingPositive(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return 1;
        }

        for (int i = 0; i < A.length; i++) {
            while (A[i] != i + 1) {
                if (A[i] - 1 < 0 || A[i] - 1 >= A.length || A[i] == A[A[i] - 1]) {
                    break;
                }
                int index = A[i] - 1;
                swap(A, i, index);
            }
        }

        for (int i = 0; i < A.length; i++) {
            if (A[i] != i + 1) {
                return i + 1;
            }
        }
        return A.length + 1;
    }

    private void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
