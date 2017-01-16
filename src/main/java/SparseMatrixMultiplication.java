/**
 * Created by shuaiwang on 1/16/17.
 */
public class SparseMatrixMultiplication {
    public int[][] multiply(int[][] A, int[][] B) {
        int aRow = A.length;
        int aCol = A[0].length;
        int bCol = B[0].length;

        int[][] C = new int[aRow][bCol];

        // Advanced Way:
        /**
         * A[0][0] * B[0][0] = C[0][0] (will be updated later with values from A[0][1] * B[1][0])
         *
         * A[0][0] * B[0][1] = C[0][1] (will be updated later with values from A[0][1] * B[0][1])
         *
         * A[0][0] * B[0][2] = C[0][2] (same as above)
         * */
        for (int i = 0; i < aRow; i++) {
            for (int k = 0; k < aCol; k++) {
                if (A[i][k] != 0) // if A[i][k] is 0, then it will not change the value of C[i][j]. So we car ignore it
                    for (int j = 0; j < bCol; j++) {
                        C[i][j] += A[i][k] * B[k][j];
                    }
            }
        }

        // Naive Way, but will be TLE
//        for (int i = 0; i < aRow; i++) {
//            for (int j = 0; j < bCol; j++) {
//                for (int k = 0; k < aCol; k++) {
//                    C[i][j] += A[i][k] + B[k][j];
//                }
//
//            }
//        }
        return C;
    }

    public static void main(String[] args) {
        int[][] A = {{1, -5}};
        int[][] B = {{12}, {-1}};

        SparseMatrixMultiplication test = new SparseMatrixMultiplication();
        test.multiply(A, B);
    }
}
