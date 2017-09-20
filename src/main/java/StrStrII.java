/**
 * Created by shuaiwang on 2/18/17.
 */
public class StrStrII {
    public int strStr2(String source, String target) {
        // Write your code here
        if (source == null || target == null) {
            return -1;
        }
        int[] next = buildNext(target);

        int i = 0;
        int j = 0;
        while (i < source.length() && j < target.length()) {
            if (j == - 1 || source.charAt(i) == target.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }

        if (j == target.length()) {
            return i - j;
        }
        return -1;
    }

    private int[] buildNext(String s) {
        if (s == null || s.length() == 0)
            return null;
        int[] next = new int[s.length()];

        int j = 0, k = -1;
        next[0] = -1;

        while (j + 1 < s.length()) {
            if (k == -1 || s.charAt(k) == s.charAt(j)) {
                k++;
                j++;
                next[j] = k;
            } else {
                k = next[k];
            }
        }
        return next;
    }

    public static void main(String[] args) {
        StrStrII test = new StrStrII();
        String a = "abcdef";
        String b = "bcd";
        test.strStr2(a, b);
    }

}
