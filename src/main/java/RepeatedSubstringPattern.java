/**
 * Created by shuaiwang on 3/7/17.
 */
public class RepeatedSubstringPattern {

//    public boolean repeatedSubstringPattern(String s) {
//        if (s == null || s.length() == 0)
//            return false;
//
//        int[] next = new int[s.length()];
//
//        int k = 0, j = 1;
//        while (j < s.length()) {
//            if (k == 0 || s.charAt(k) == s.charAt(j)) {
//                if (s.charAt(k) == s.charAt(j))
//                    next[j] = k + 1;
//                else
//                    next[j] = k ;
//                k++;
//                j++;
//            } else {
//                k = next[k - 1];
//            }
//        }
//
//        int repeatLen = s.length() - next[s.length() - 1];
//        return s.length() % repeatLen == 0 && next[s.length() - 1] != 0 ? true : false;
//    }


//    public boolean repeatedSubstringPattern(String s) {
//        if (s.length() == 1)
//            return false;
//        int[] next = new int[s.length()];
//        int k = -1, j = 0;
//        while (j < s.length()) {
//            if (k == -1 || s.charAt(j) == s.charAt(k)) {
//                k++;
//                next[j] = k;
//                j++;
//            } else {
//                if (k == 0)
//                    k = -1;
//                else
//                    k = next[k - 1];
//            }
//        }
//        if (next[s.length() - 1] < s.length() / 2) {
//            return false;
//        }
//        int patternLen = s.length() - next[s.length() - 1];
//        return next[s.length() - 1] % patternLen == 0;
//    }

    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() == 0)
            return false;
        for (int len = s.length() / 2; len >= 1; len--) {
            if (s.length() % len == 0) {
                int size = s.length() / len;
                String pattern = s.substring(0, len);
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < size; i++) {
                    sb.append(pattern);
                }
                if (sb.toString().equals(s))
                    return true;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        String s = "abaababaab";
        RepeatedSubstringPattern test = new RepeatedSubstringPattern();
        System.out.print(test.repeatedSubstringPattern(s));
    }
}
