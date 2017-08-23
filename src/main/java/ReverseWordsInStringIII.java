/**
 * Created by shuaiwang on 8/22/17.
 */
public class ReverseWordsInStringIII {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0)
            return s;
        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            String current = new StringBuilder(strs[i]).reverse().toString();
            sb.append(current).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
