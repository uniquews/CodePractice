/**
 * Created by shuaiwang on 4/4/17.
 */
public class AddStrings {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;

        StringBuilder sb = new StringBuilder();
        int next = 0;
        while (i >= 0 || j >= 0) {
            int tmp1 = i >= 0 ? num1.charAt(i) - '0' : 0 ;
            int tmp2 = j >= 0 ? num2.charAt(j) - '0' : 0;

            int sum = tmp1 + tmp2 + next;
            sb.insert(0, sum % 10);
            next = sum / 10;
            i--;
            j--;
        }

        if (next > 0) {
            sb.insert(0, next);
        }
        return sb.toString();
    }
}
