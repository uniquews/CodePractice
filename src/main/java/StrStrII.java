/**
 * Created by shuaiwang on 2/18/17.
 */
public class StrStrII {
    public int strStr2(String source, String target) {
        // Write your code here
        if (source == null || target == null) {
            return -1;
        }
        int[] next = constructNext(target);

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

    private int[] constructNext(String target) {
        if (target == null || target.length() == 0) {
            return null;
        }

        int[] next = new int[target.length()];
        int k = -1;
        int j = 0;
        next[0] = -1;
        while (j < target.length() - 1) {
            if (k == -1 || target.charAt(k) == target.charAt(j)) {
                k++;
                j++;
                next[j] = k;
            } else {
                k = next[k];
            }
        }
        return next;
    }

}
