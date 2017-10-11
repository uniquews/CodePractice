import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by shuaiwang on 11/14/16.
 */
public class NQueens {
//    ArrayList<ArrayList<String>> solveNQueens(int n) {
//        // write your code here
//        ArrayList<ArrayList<String>> result = new ArrayList<>();
//        int[] map = new int[n];
//
//        dfs(map, n, 0, result);
//        return result;
//    }
//
//    private void dfs(int[] map, int row, int level, ArrayList<ArrayList<String>> result) {
//        if (level == row) {
//            buildResult(map, result);
//            return;
//        }
//
//        for (int i = 0; i < row; i++) {
//            map[level] = i;
//            if (isValid(map, level, i)) {
//                dfs(map, row, level + 1, result);
//            }
//        }
//    }
//
//    private boolean isValid(int[] map, int row, int col) {
//        for (int i = 0; i < row; i++) {
//            if (map[i] == col) {
//                return false;
//            }
//            if (Math.abs(i - row) == Math.abs(map[i] - col)) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    private void buildResult(int[] map, ArrayList<ArrayList<String>> result) {
//        ArrayList<String> eachResult = new ArrayList<>();
//        for (int i = 0; i < map.length; i++) {
//            StringBuilder sb = new StringBuilder();
//            for (int j = 0; j < map.length; j++) {
//                if (j == map[i]) {
//                    sb.append("Q");
//                } else {
//                    sb.append(".");
//                }
//            }
//            eachResult.add(sb.toString());
//        }
//        result.add(eachResult);
//    }
    public List<List<String>> solveNQueens(int n) {
        int[] row = new int[n];
        int[] col = new int[n];

        List<List<String>> result = new ArrayList<>();
        dfs(row, col, n, 0, result);
        return result;
    }

    private void dfs(int[] row, int[] col, int n, int index, List<List<String>> result) {
        if (index == n) {
            List<String> eachResult = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                char[] tmp = new char[n];
                Arrays.fill(tmp, '.');
                tmp[row[i]] = 'Q';
                eachResult.add(new String(tmp));
            }
            result.add(eachResult);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (col[i] != 1 && isValid(row, index, i)) {
                row[index] = i;
                col[i] = 1;
                dfs(row, col, n, index + 1, result);
                col[i] = 0;
            }
        }
    }

    private boolean isValid(int[] row, int r, int c) {
        for (int i = 0; i < r; i++) {
            if (Math.abs(i - r) == Math.abs(row[i] - c)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        int n = 4;
        NQueens test = new NQueens();
        test.solveNQueens(n);
    }
}
