/**
 * Created by shuaiwang on 2/2/17.
 */

/**
 *  | 1 | 2 | 3 |
    | 4 | 5 | 6 |
    | 7 | 8 | 9 |
 *
 * */


/**
 * In the beginning I want to use f[i][j] to represent how mamy patters does number i with step j will have?
 * Then I thought it would be solved by using dfs backtracking with updating f[i][j], which being said if
 * f[i][j] is already calculated, then we just return its value
 *
 * Finally it turns out that this method is wrong. The reason is, f[2][2] will be different give different parent
 * For example, if we want to get value of f[1][3], we will have to get f[2][2] first. At this moment, f[2][2] = 6
 * Then if we want to get value of f[5][3], f[2][2] will be 7. The reason is when 5 is visisted, we can go from 2
 * tp 5, which is in valid when we start with 1. So the backtracking with f[i][j] is not doable. We can only backtracking
 * every single case without using previous result.
 *
 *
 * */
public class AndroidUnlockPatterns {
//    public int numberOfPatterns(int m, int n) {
//        int[][] skip = new int[10][10];
//        skip[1][3] = skip[3][1] = 2;
//        skip[7][9] = skip[9][7] = 8;
//        skip[1][7] = skip[7][1] = 4;
//        skip[3][9] = skip[9][3] = 6;
//        skip[2][8] = skip[8][2] = skip[4][6] = skip[6][4] = skip[1][9] = skip[9][1]
//                = skip[3][7] = skip[7][3] = 5;
//
//        boolean[] visited = new boolean[10];
//        int result = 0;
//        for (int i = m; i <= n; i++) {
//            for (int j = 1; j <= 9; j++) {
//                visited[j] = true;
//                result += dfs(visited, skip, i, j);
//                visited[j] = false;
//            }
//        }
//
//        return result;
//    }
//
//    private int dfs(boolean[] visited, int[][] skip, int step, int current) {
//        if (step == 1) {
//            return 1;
//        }
//
//        int rst = 0;
//        for (int i = 1; i <= 9; i++) {
//            // visited[skip[current][i]] is very tricky, let's say you start with 5, then go to 2,
//            // because 5 is already visited, you can connect 2 with 8, which is valid
//            // Suppose 5 is not visited, then you can't connect 2 with 8
//            if (i != current && !visited[i] && (skip[current][i] == 0 || visited[skip[current][i]])) {
//                visited[i] = true;
//                rst += dfs(visited, skip, step - 1, i);
//                visited[i] = false;
//            }
//        }
//        return rst;
//    }

    private int result = 0;
    public int numberOfPatterns(int m, int n) {
        int[][] map = new int[10][10];
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                map[i][j] = -1;
            }
        }
        map[1][3] = map[3][1] = 2;
        map[1][7] = map[7][1] = 4;
        map[1][9] = map[9][1] = 5;
        map[2][8] = map[8][2] = 5;
        map[3][7] = map[7][3] = 5;
        map[3][9] = map[9][3] = 6;
        map[4][6] = map[6][4] = 5;
        map[7][9] = map[9][7] = 8;

        for (int i = m; i <= n; i++) {
            boolean[] visited = new boolean[10];
            dfs(i, 0, visited, map);
        }
        return result;
    }

    private void dfs(int len, int prev, boolean[] visited, int[][] map) {
        if (len == 0) {
            result++;
            return;
        }

        for (int i = 1; i <= 9; i++) {
            int current = i;
            if (!visited[current] && ((map[prev][current] == -1) || visited[map[prev][current]])) {
                visited[current] = true;
                dfs(len - 1, current, visited, map);
                visited[current] = false;
            }
        }
    }

    public static void main(String[] args) {
        AndroidUnlockPatterns test = new AndroidUnlockPatterns();
        System.out.print(test.numberOfPatterns(2, 2));
    }
}
