/**
 * Created by shuaiwang on 4/18/17.
 */
public class KMP2 {
    public void kmp2(String s) {
        int k = -1, j = 0;
        int[] next = new int[s.length()];

        while (j < s.length()) {
            if (k == -1 || s.charAt(k) == s.charAt(j)) {
                k++;
                next[j] = k;
                j++;
            } else {
                if (k == 0)
                    k = -1;
                else
                    k = next[k - 1]; // 当s[k]！= s[j] 需要去看s[k - 1]相同的prefix 而不是s[k]，因为s[k]已经和s[j]不匹配了
            }
        }
        return;
    }

    public static void main(String[] args) {
        String a = "aaa";
        new KMP2().kmp2(a);
    }
}
