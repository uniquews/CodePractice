/**
 * Created by shuaiwang on 5/6/17.
 */
public class ReverseStringII {
    public String reverseStr(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index < s.length()) {
            int i = 0;
            StringBuilder tmp;
            int start = index;
            while (i + index < s.length() && i < k) {
                i++;
            }
            tmp = new StringBuilder(s.substring(start, i + index));
            sb.append(tmp.reverse());
            int j = 0;
            int secondStart = i + index;
            while (j + i + index < s.length() && j < k) {
                j++;
            }
            tmp = new StringBuilder(s.substring(secondStart, i + j + index));
            sb.append(tmp);
            index = j + i + index;
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
