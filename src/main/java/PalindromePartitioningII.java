/**
 * Created by shuaiwang on 8/30/16.
 */
public class PalindromePartitioningII {
    public int minCut(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return 0;
        }

        int[] f = new int[s.length() + 1];

        f[0] = -1;

        for (int i = 1; i <= s.length(); i++) {
            f[i] = i - 1;
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (isPalindrome(s.substring(j, i))) {
                    f[i] = Math.min(f[i], f[j] + 1);
                }
            }
        }
        return f[s.length()];
    }

    private boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }
        return true;
    }
}
