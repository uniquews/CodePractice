/**
 * Created by shuaiwang on 4/4/17.
 */
public class AddStrings {
    public String addStrings(String num1, String num2) {
        int ins = 0;
        int i = num1.length() - 1, j = num2.length() - 1;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int tmp1 = 0;
            if (i >= 0 && num1.charAt(i) != '0') {
                tmp1 = num1.charAt(i) - '1' + 1;
            }

            int tmp2 = 0;
            if (j >= 0 && num2.charAt(j) != '0') {
                tmp2 = num2.charAt(j) - '1' + 1;
            }
            int current = tmp1 + tmp2 + ins;
            sb.insert(0, current % 10);
            ins = current / 10;
            i--;
            j--;
        }

        if (ins != 0) {
            sb.insert(0, ins);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int x = '2';
        System.out.print(x -  '1');
    }
}
