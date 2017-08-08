/**
 * Created by shuaiwang on 5/6/17.
 */
public class ReverseStringII {
    public String reverseStr(String s, int k) {
        if (s == null || s.length() == 0) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            int end = i;
            while (end < s.length() && end - i + 1 <= k) {
                end++;
            }
            String tmp = s.substring(i, end);
            sb.append(new StringBuilder(tmp).reverse());
            i = end;
            if (end < s.length()) {
                while (end < s.length() && end - i + 1 <= k) {
                    end++;
                }
                tmp = s.substring(i, end);
                sb.append(new StringBuilder(tmp));
                i = end;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ReverseStringII test = new ReverseStringII();
        String s = "abcdefg";
        int k = 2;
        System.out.print(test.reverseStr(s, k));
    }

}
