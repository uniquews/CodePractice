/**
 * Created by shuaiwang on 4/18/17.
 */

/**
 *
 *
 * 这道题其实包含了另一道隐藏问题：
 * 隐藏问题： Given s, find the length of longest palindrome starting from index 0
 *
 * 思路：
 * 1. 把string s改装成 s + "#" + reverse(s), tmp
 * 2. 用kmp算法求得tmp的next数组，不过这里的next[i]表示的是以结尾的，最长前缀后缀的长度，和kmp里的next略有不同，kmp的next是这个next向
 * 右平移一位的结果
 * 3. 现在我们有next数组 比如如果s = aabaaa, tmp = aabaaa#aaabaa
 *   next数组是 0,1,0,1,2,2,0,1,2,2,0,1,2
 *   这里发现了#的作用，就是为了让所有的next数组里的前缀都来源于原数组
 * 4. next数组里的最后一个值2就是原string s中  从index = 0位置的最长回文长度 （隐藏问题得解）
 * 5. 把s中除了开头最长的回文部分剩余部分先reverse在insert到s的开头，就是本题答案
 * */

public class ShortestPalindrome {
//    public String shortestPalindrome(String s) {
//        if (s == null || s.length() == 0) return "";
//        String tmp = s + "#" + new StringBuffer(s).reverse().toString();
//        int[] next = kmp2(tmp);
//        StringBuilder result = new StringBuilder(s);
//        String nonPalindormePart = new StringBuilder(s.substring(next[tmp.length() - 1])).reverse().toString();
//        return result.insert(0, nonPalindormePart).toString();
//    }
//
//    private int[] kmp2(String s) {
//        int k = -1, j = 0;
//        int[] next = new int[s.length()];
//
//        while (j < s.length()) {
//            if (k == -1 || s.charAt(k) == s.charAt(j)) {
//                k++;
//                next[j] = k;
//                j++;
//            } else {
//                if (k == 0)
//                    k = -1;
//                else
//                    k = next[k - 1]; // 当s[k]！= s[j] 需要去看s[k - 1]相同的prefix 而不是s[k]，因为s[k]已经和s[j]不匹配了
//            }
//        }
//        return next;
//    }

//    public String shortestPalindrome(String s) {
//        String tmp = s + "#" + new StringBuilder(s).reverse().toString();
//        int[] next = kmp2(tmp);
//        StringBuilder result = new StringBuilder(s);
//        String nonPalindormePart = new StringBuilder(s.substring(next[tmp.length() - 1])).reverse().toString();
//        return result.insert(0, nonPalindormePart).toString();
//    }
//
//    private int[] kmp2(String s) {
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
//        return next;
//    }

    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        StringBuilder sb = new StringBuilder(s);
        sb.append("#").append(new StringBuilder(s).reverse().toString());
        String tmp = sb.toString();
        int[] next = new int[tmp.length()];
        kmp(next, tmp);
        return new StringBuilder(s.substring(next[tmp.length() - 1])).reverse().toString() + s;
    }

    private void kmp(int[] next, String s) {
        int k = -1, j = 0;
        while (j < s.length()) {
            if (k == -1 || s.charAt(k) == s.charAt(j)) {
                k++;
                next[j] = k;
                j++;
            } else {
                if (k == 0) {
                    k = -1;
                } else {
                    k = next[k - 1];
                }
            }
        }
    }

    public static void main(String[] args) {
//        String a = "aabaaa";
//        String a = "abcd";
//        String a = "abcb";
        String a = "aacecaaa";
        ShortestPalindrome test = new ShortestPalindrome();
        test.shortestPalindrome(a);
    }
}
