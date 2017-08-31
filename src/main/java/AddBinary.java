/**
 * Created by shuaiwang on 8/30/17.
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        int i = a.length() - 1, j = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int n1 = i >= 0 ? a.charAt(i--) - '0' : 0;
            int n2 = j >= 0 ? b.charAt(j--) - '0' : 0;
            int nextCarry = (n1 + n2 + carry) / 2;
            sb.insert(0, (n1 + n2 + carry) % 2);
            carry = nextCarry;
        }

        if (carry == 1) {
            sb.insert(0, carry);
        }
        return sb.toString();
    }
}
