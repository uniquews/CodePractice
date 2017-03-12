/**
 * Created by shuaiwang on 3/7/17.
 */
public class RepeatedSubstringPattern {

    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() == 0)
            return false;

        int[] next = new int[s.length()];

        int k = 0, j = 1;
        while (j < s.length()) {
            if (k == 0 || s.charAt(k) == s.charAt(j)) {
                if (s.charAt(k) == s.charAt(j))
                    next[j] = k + 1;
                else
                    next[j] = k ;
                k++;
                j++;
            } else {
                k = next[k - 1];
            }
        }

        int repeatLen = s.length() - next[s.length() - 1];
        return s.length() % repeatLen == 0 && next[s.length() - 1] != 0 ? true : false;
    }

    public static void main(String[] args) {
        String s = "abaababaab";
        RepeatedSubstringPattern test = new RepeatedSubstringPattern();
        System.out.print(test.repeatedSubstringPattern(s));
    }
}
