/**
 * Created by shuaiwang on 1/29/17.
 */
public class CountNumbersWithUniqueDigits {
//    public int countNumbersWithUniqueDigits(int n) {
//        int[] result = new int[n + 1]; // number of unique digit numbers 0 <= x < 10^n
//        int[] f = new int[n + 1]; // number of unique digit numbers only in all nth digits numbers
//        if (n == 0)
//            return 1;
//        if (n == 1)
//            return 10;
//        result[0] = 1; // n = 0, 0 <= x < 1, then result[0] = 1
//        result[1] = 10;  // n = 1, 0 <= x < 10, then result[0] = 9
//        // When n == 2, _ _ first digit has 9 choices [1, ..., 9],
//        // second one has 9 choices excluding the already chosen one.
//        // So totally 9 * 9 = 81. answer should be 10 + 81 = 91
//        f[1] = 9;
//        for (int i = 2; i <= n; i++) {
//            f[i] = f[i - 1] * (11 - i); // i == 3, _ _ _ will be
//            // 9 choice[1-9] * 9 choice[0-9] but no previous digit * 8 choice[0-9]
//            // but no previous two digits
//            result[i] = result[i - 1] + f[i];
//        }
//        return result[n];
//    }


    // With O(1) space
    // Since f(n) only depends ont f(n - 1), so we can use one variables to keep its value
//    public int countNumbersWithUniqueDigits(int n) {
//        if (n == 0)
//            return 1;
//        int result = 10;
//        int choice = 9;
//
//        for (int i = 2; i <= n; i++) {
//            choice = choice * (11 - i);
//            result += choice;
//        }
//        return result;
//    }

    private int result = 1;
    public int countNumbersWithUniqueDigits(int n) {
        helper(n);
        return result;
    }

    private void helper(int n) {
        for (int i = 1; i <= n; i++) {
            boolean[] visited = new boolean[10];
            for (int j = 1; j <= 9; j++) { //第一层要特殊处理  因为我们不想dealing with leading zero， 比如00123 应该是valid result
                visited[i] = true;
                dfs(i - 1, j, visited);                           // 但是如果我们不特殊处理leading zero 00123会因为有两个0而不能进结果集
                visited[i] = false;
            }
        }
    }

    private void dfs(int numOfDigit, int sum, boolean[] visited) {
        if (numOfDigit == 0) {
            result++;
            return;
        }
        for (int i = 0; i <= 9; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                int nextSum = sum * 10 + i;
                dfs(numOfDigit - 1, nextSum, visited);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        CountNumbersWithUniqueDigits test = new CountNumbersWithUniqueDigits();
        test.countNumbersWithUniqueDigits(2);
    }
}
