/**
 * Created by shuaiwang on 6/18/17.
 */
public class DecimalTo26 {
    /**
     *
     * 10进制转换成26进制
     * A = 0
     * B = 1 ... Z = 25
     *
    */
    public String decimalTo26(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            int cur = n % 26; // [0,25]
            sb.insert(0, (char)(cur + 'A'));
            n = n / 26;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        int n = 26;
        DecimalTo26 test = new DecimalTo26();
        System.out.println(test.decimalTo26(n));
    }
}
