/**
 * Created by shuaiwang on 8/30/17.
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int tmp1 = i < 0 ? 0 : a.charAt(i--) - '0';
            int tmp2 = j < 0 ? 0 : b.charAt(j--) - '0';
            int nextCarry = (tmp1 + tmp2 + carry) / 2;
            sb.insert(0, (tmp1 + tmp2 + carry) % 2);
            carry = nextCarry;
        }
        if (carry != 0) {
            sb.insert(0, carry);
        }
        return sb.toString();
    }
}
