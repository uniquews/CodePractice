/**
 * Created by shuaiwang on 8/26/17.
 */
public class DecodeWaysII {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        long[] f = new long[s.length() + 1];
        f[0] = 1;
        for (int i = 1; i <= s.length(); i++) {
            char c = s.charAt(i - 1);
            if (c != '*') {
                if (c != '0') {
                    f[i] = f[i - 1] % 1000000007;
                }
                if (i < 2) {
                    continue;
                }
                char p = s.charAt(i - 2);
                if (p != '*') { // "12"
                    int lastTwo = Integer.valueOf(s.substring(i - 2, i));
                    if (lastTwo >= 10 && lastTwo <= 26) {
                        f[i] += f[i - 2] % 1000000007;
                    }
                } else { // "*2"
                    if (c >= '0' && c <= '6') { // 10-16 20-26
                        f[i] += (f[i - 2] * 2) % 1000000007;
                    } else if (c > '6') { // 17 18 19
                        f[i] += f[i - 2] % 1000000007;
                    }
                }
            } else {
                f[i] = (f[i - 1] * 9) % 1000000007;
                if (i < 2)
                    continue;
                char p = s.charAt(i - 2);
                if (p != '*') {
                    if (p == '1') {
                        f[i] += (f[i - 2] * 9) % 1000000007;
                    } else if (p == '2') {
                        f[i] += (f[i - 2] * 6) % 1000000007;
                    }
                } else {
                    f[i] += (f[i - 2] * 15) % 1000000007; // 21-26 11-19
                }
            }
        }
        return (int)(f[s.length()] % 1000000007);
    }

    public static void main(String[] args) {
        String s = "*1*1*0";
        DecodeWaysII test = new DecodeWaysII();
        System.out.print(test.numDecodings(s));
    }

}
