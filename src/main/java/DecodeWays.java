/**
 * Created by shuaiwang on 9/1/16.
 */
public class DecodeWays {
    public int numDecodings(String s) {
        // Write your code here
        if (s == null || s.length() == 0) {
            return 0;
        }

        int[] f = new int[s.length() + 1];

        f[0] = 1;
        f[1] = 1;

        for (int i = 2; i <= s.length(); i++) {
            if ((s.charAt(i - 1) - '0') != 0) {
                f[i] += f[i - 1];
            }

            int tmp = (s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0');
            if (tmp <= 26 && tmp >= 10) {
                f[i] += f[i - 2];
            }
        }

        return f[s.length()];
    }
}
