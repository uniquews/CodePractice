/**
 * Created by shuaiwang on 8/29/17.
 */
public class MultiplyStrings {
    // tle
//    public String multiply(String num1, String num2) {
//        if (num1.equals("0") || num2.equals("0"))
//            return "0";
//        String result = "0";
//        int tail = 0;
//        for (int i = num1.length() - 1; i >= 0; i--) {
//            int n1 = Character.getNumericValue(num1.charAt(i));
//            String current = helper(num2, n1);
//            String transfer = appendZero(current, tail++);
//            result = addTwoString(transfer, result);
//        }
//        return result;
//    }
//
//    private String helper(String num, int n) {
//        int carry = 0, tail = 0;
//        String result = "0";
//        for (int i = num.length() - 1; i >= 0; i--) {
//            int n2 = Character.getNumericValue(num.charAt(i));
//            int nextCarry = (n * n2 + carry) / 10;
//            int current = (n * n2 + carry) % 10;
//            String s = appendZero(String.valueOf(current), tail++);
//            result = addTwoString(result, s);
//            carry = nextCarry;
//        }
//        if (carry != 0) {
//            return String.valueOf(carry) + result;
//        }
//        return result;
//    }
//
//    private String appendZero(String current, int tail) {
//        StringBuilder sb = new StringBuilder(current);
//        for (int i = 0; i < tail; i++) {
//            sb.append("0");
//        }
//        return sb.toString();
//    }
//
//    private String addTwoString(String a, String b) {
//        int i = a.length() - 1, j = b.length() - 1, carry = 0;
//        StringBuilder sb = new StringBuilder();
//
//        while (i >= 0 || j >= 0) {
//            int n1 = i < 0 ? 0 : Character.getNumericValue(a.charAt(i));
//            int n2 = j < 0 ? 0 : Character.getNumericValue(b.charAt(j));
//            sb.insert(0, (n1 + n2 + carry) % 10);
//            carry = (n1 + n2 + carry) / 10;
//            i--;
//            j--;
//        }
//
//        if (carry != 0) {
//            sb.insert(0, "1");
//        }
//        return sb.toString();
//    }

    /**
     * 借鉴思路 https://discuss.leetcode.com/topic/30508/easiest-java-solution-with-graph-explanation
     * 最后统一进位。
     */

    public String multiply(String num1, String num2) {
        int[] pos = new int[num1.length() + num2.length()];

        for (int i = 0; i < num1.length(); i++) {
            for (int j = 0; j < num2.length(); j++) {
                int n1 = num1.charAt(i) - '0';
                int n2 = num2.charAt(j) - '0';
                int p1 = i + j, p2 = i + j + 1; // please remember
                pos[p1] += n1 * n2 / 10;
                pos[p2] += (n1 * n2) % 10;
            }
        }

        int carry = 0;
        for (int i = pos.length - 1; i >= 0; i--) {
            int nextCarry = (pos[i] + carry) / 10;
            pos[i] = (pos[i] + carry) % 10;
            carry = nextCarry;
        }
        StringBuilder sb = new StringBuilder();
        for (int po : pos) {
            sb.append(po);
        }

        int index = 0;
        // index < pos.length - 1的原因是 0000 这种情况所以的0都会被删除。
        while (index < pos.length - 1 && sb.charAt(index) == '0') {
            index++;
        }
        return sb.delete(0, index).toString();
    }

    public static void main(String[] args) {
        String s = "99";
        MultiplyStrings test = new MultiplyStrings();
        System.out.print(test.multiply(s, "999"));
    }
}
