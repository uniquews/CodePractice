package fb;

import java.util.ArrayList;
import java.util.List;

public class PrintMatrix {
    int[] dx = {0, 1};
    int[] dy = {1, 0};

    public List<String> getAllPaths(char[][] matrix) {
        List<String> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return result;
        }

        int r = matrix.length;
        int c = matrix[0].length;

        char[] eachResult = new char[r + c - 1 + (r + c - 2) * 2];
        dfs(matrix, 0, 0, eachResult, 0, result);
        return result;
    }

    private void dfs(char[][] matrix, int row, int col, char[] eachResult, int index, List<String> result) {
        if (row < 0 || row == matrix.length || col < 0 || col == matrix[0].length) {
            return;
        }

        eachResult[index++] = matrix[row][col];
        if (row == matrix.length - 1 && col == matrix[0].length - 1) {
            result.add(new String(eachResult));
            return;
        }

        eachResult[index++] = '-';
        eachResult[index++] = '>';

        for (int i = 0; i < dx.length; i++) {
            dfs(matrix, row + dx[i], col + dy[i], eachResult, index, result);
        }
    }

    public static void main(String[] args) {
        char[][] matrix = {{'a', 'b', 'c'}, {'d', 'e', 'f'}};
        PrintMatrix test = new PrintMatrix();
        List<String> result  =test.getAllPaths(matrix);
        for (String s : result) {
            System.out.println(s);
        }
    }
}
