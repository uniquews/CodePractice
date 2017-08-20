/**
 * Created by shuaiwang on 4/10/17.
 */
public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        if (num == null || num.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(num);
        int left = 0, right = left + 1;
        while (k > 0) {
            while (right < sb.length()
                    && Character.getNumericValue(sb.charAt(left)) <= Character.getNumericValue(sb.charAt(right))) {
                left++;
                right++;
            }
            sb.deleteCharAt(left);
            if (left != 0) {
                left--;
                right--;
            }
            k--;
        }
        int start = 0;
        while (sb.length() > 0 && sb.charAt(start) == '0') {
            sb.deleteCharAt(start);
        }
        if (sb.length() == 0) {
            return "0";
        } else {
            return sb.toString();
        }
    }
    public static void main(String[] args) {
        String m = "10200";
        RemoveKDigits test = new RemoveKDigits();
        test.removeKdigits(m, 1);
    }

}
