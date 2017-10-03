import java.util.Arrays;

/**
 * Created by shuaiwang on 8/30/17.
 */
public class AddBinary {
//    public String addBinary(String a, String b) {
//        int i = a.length() - 1;
//        int j = b.length() - 1;
//        int carry = 0;
//        StringBuilder sb = new StringBuilder();
//        while (i >= 0 || j >= 0) {
//            int tmp1 = i < 0 ? 0 : a.charAt(i--) - '0';
//            int tmp2 = j < 0 ? 0 : b.charAt(j--) - '0';
//            int nextCarry = (tmp1 + tmp2 + carry) / 2;
//            sb.insert(0, (tmp1 + tmp2 + carry) % 2);
//            carry = nextCarry;
//        }
//        if (carry != 0) {
//            sb.insert(0, carry);
//        }
//        return sb.toString();
//    }

    public String addBinary(String a, String b) {
        int len = Math.max(a.length(), b.length()) + 1;
        char[] s = new char[len];
        Arrays.fill(s, '0');

        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        int index = len - 1;
        while (i >= 0 || j >= 0) {
            int tmp1 = i < 0 ? 0 : a.charAt(i) - '0';
            int tmp2 = j < 0 ? 0 : b.charAt(j) - '0';

            int n = tmp1 + tmp2 + carry;
            s[index--] = (char)(n % 2 + '0');
            carry = n / 2;
            i--;
            j--;
        }

        if (carry != 0) {
            s[index] = (char)(carry + '0');
        }

        String result = new String(s);
        index = 0;
        while (index < result.length() - 1 && result.charAt(index) == '0') {
            index++;
        }
        return result.substring(index);
    }

    public static void main(String[] args) {
        String a = "1";
        String b = "1";
        AddBinary test = new AddBinary();
        System.out.print(test.addBinary(a, b));
    }
}
