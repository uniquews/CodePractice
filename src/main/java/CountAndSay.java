/**
 * Created by shuaiwang on 9/5/17.
 */
public class CountAndSay {
    public String countAndSay(int n) {
        String s = "1";

        while (n > 1) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                int j = i;
                while (j < s.length() && s.charAt(i) == s.charAt(j)) {
                    j++;
                }
                int size = j - i;
                sb.append(size).append(s.charAt(i));
                i = j - 1;
            }
            s = sb.toString();
            n--;
        }
        return s;
    }
}
