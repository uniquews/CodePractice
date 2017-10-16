/**
 * Created by shuaiwang on 9/1/16.
 */
public class DecodeWays {
//    public int numDecodings(String s) {
//        if (s == null || s.length() == 0) {
//            return 0;
//        }
//
//        int[] f = new int[s.length() + 1];
//        f[0] = 1;
//        for (int i = 1; i <= s.length(); i++) {
//            if (s.charAt(i - 1) != '0') {
//                f[i] = f[i - 1];
//            }
//
//            if (i < 2)
//                continue;
//
//            int lastTwoDigits = Integer.valueOf(s.substring(i - 2, i));
//            if (lastTwoDigits >= 10 && lastTwoDigits <= 26) {
//                f[i] += f[i - 2];
//            }
//        }
//        return f[s.length()];
//    }
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int tmp1 = 0;
        int tmp2 = 1;

        for (int i = 0; i < s.length(); i++) {
            int cur = 0;
            if (i == 0) {
                if (s.charAt(i) != '0') {
                    cur = tmp2;
                }
                tmp1 = tmp2;
                tmp2 = cur;
            } else {
                if (s.charAt(i) != '0') {
                    cur = tmp2;
                }
                String str = s.substring(i - 1, i + 1);
                if (Integer.valueOf(str) >= 10 && Integer.valueOf(str) <= 26) {
                    cur += tmp1;
                }
                tmp1 = tmp2;
                tmp2 = cur;
            }
        }
        return tmp2;
    }
}
