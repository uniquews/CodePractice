import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SparseMatrixFB {
    /**
     * sparse matrix representation:
     * <p>
     * <p>
     * https://www.cs.cmu.edu/~scandal/cacm/node9.html
     * <p>
     * {0, {{2, 3}, {4, 4}}},
     * {1, {{2, 5}, {3, 7}}},
     * {3, {{1, 2}, {2, 6}}}
     * <p>
     * <p>
     * {1, {{3, 2}}},
     * {2, {{0, 3}, {1, 5}, {3, 6}}},
     * {3, {{1, 7}}},
     * {4, {{0, 4}}}
     */
    public Map<Integer, List<int[]>> sparseMatrixMultiplication(int[][] a, int[][] b) {
        Map<Integer, List<int[]>> matrixA = new HashMap<>();
        Map<Integer, List<int[]>> matrixB = new HashMap<>();
        Map<Integer, List<int[]>> matrixC = new HashMap<>();


        for (int i = 0; i < a.length; i++) {
            List<int[]> row = new ArrayList<>();
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] != 0) {
                    int[] element = {j, a[i][j]};
                    row.add(element);
                }
            }
            if (!row.isEmpty()) {
                matrixA.put(i, row);
            }
        }

        for (int i = 0; i < b[0].length; i++) {
            List<int[]> col = new ArrayList<>();
            for (int j = 0; j < b.length; j++) {
                if (b[j][i] != 0) {
                    col.add(new int[]{j, b[j][i]});
                }
            }
            if (!col.isEmpty()) {
                matrixB.put(i, col);
            }
        }

        for (Integer row : matrixA.keySet()) {
            for (Integer col : matrixB.keySet()) {
                List<int[]> ma = matrixA.get(row);
                List<int[]> mb = matrixB.get(col);
                List<int[]> mc = matrixC.getOrDefault(row, new ArrayList<>());
                mc.add(new int[]{col, helper(ma, mb)});
                matrixC.put(row, mc);
            }
        }
        return matrixC;
    }

    private int helper(List<int[]> ma, List<int[]> mb) {
        int i = 0;
        int j = 0;
        int result = 0;
        while (i < ma.size() && j < mb.size()) {
            int c1 = ma.get(i)[0];
            int r2 = mb.get(j)[0];

            if (c1 == r2) {
                result += ma.get(i)[1] * mb.get(j)[1];
                i++;
                j++;
            } else if (c1 < r2) {
                i++;
            } else {
                j++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] a = {{0, 2, 3}, {0, 4, 4}, {1, 2, 5}};
        int[][] b = {{1, 3, 7}, {3, 1, 2}, {3, 2, 6}};
        SparseMatrixFB test = new SparseMatrixFB();
        test.sparseMatrixMultiplication(a, b);
    }
}
