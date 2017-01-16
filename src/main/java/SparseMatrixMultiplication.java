/**
 * Created by shuaiwang on 1/16/17.
 */
public class SparseMatrixMultiplication {
    public int[][] multiply(int[][] A, int[][] B) {
        int aRow = A.length;
        int aCol = A[0].length;
        int bCol = B[0].length;

        int[][] C = new int[aRow][bCol];

        for (int i = 0; i < aRow; i++) {
            for (int k = 0; k < aCol; k++) {
                if (A[i][k] != 0)
                    for (int j = 0; j < bCol; j++) {
                        C[i][j] += A[i][k] * B[k][j];
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
