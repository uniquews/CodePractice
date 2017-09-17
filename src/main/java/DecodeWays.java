/**
 * Created by shuaiwang on 9/1/16.
 */
public class DecodeWays {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int[] f = new int[s.length() + 1];
        f[0] = 1;
        for (int i = 1; i <= s.length(); i++) {
            if (s.charAt(i - 1) != '0') {
                f[i] = f[i - 1];
            }

            if (i < 2)
                continue;

            int lastTwoDigits = Integer.valueOf(s.substring(i - 2, i));
            if (lastTwoDigits >= 10 && lastTwoDigits <= 26) {
                f[i] += f[i - 2];
            }
        }
        return f[s.length()];
    }
}
