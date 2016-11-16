package main;

import java.util.ArrayList;

/**
 * Created by shuaiwang on 11/14/16.
 */
public class NQueens {
    ArrayList<ArrayList<String>> solveNQueens(int n) {
        // write your code here
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        int[] map = new int[n];

        dfs(map, n, 0, result);
        return result;
    }

    private void dfs(int[] map, int row, int level, ArrayList<ArrayList<String>> result) {
        if (level == row) {
            buildResult(map, result);
            return;
        }

        for (int i = 0; i < row; i++) {
            map[level] = i;
            if (isValid(map, level, i)) {
                dfs(map, row , level + 1, result);
            }
        }
    }

    private boolean isValid(int[] map, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (map[i] == col) {
                return false;
            }
            if (Math.abs(i - row) == Math.abs(map[i] - col)) {
                return false;
            }
        }
        return true;
    }

    private void buildResult(int[] map, ArrayList<ArrayList<String>> result) {
        ArrayList<String> eachResult = new ArrayList<>();
        for (int i = 0; i < map.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < map.length; j++) {
                if (j == map[i]) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            eachResult.add(sb.toString());
        }
        result.add(eachResult);
    }
}
