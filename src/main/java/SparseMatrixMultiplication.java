/**
 * Created by shuaiwang on 1/16/17.
 */
public class SparseMatrixMultiplication {

    /**
     * A[0][0] * B[0][0] + A[0][1] * B[1][0] + A[0][2] * B[2][0] = C[0][0] (will be updated later with values from A[0][1] * B[1][0])
     */
    public int[][] multiply(int[][] A, int[][] B) {
        int[][] C = new int[A.length][B[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 0) {
                    continue;
                }
                for (int k = 0; k < B[0].length; k++) {
                    C[i][k] += A[i][j] * B[j][k];
                }
            }
        }
        return C;
    }


    public static void main(String[] args) {
        int[][] A = {{1, -5}};
        int[][] B = {{12}, {-1}};

        SparseMatrixMultiplication test = new SparseMatrixMultiplication();
        test.multiply(A, B);
    }
}
