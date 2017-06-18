/**
 * Created by shuaiwang on 5/21/17.
 */
public class ExcelSheetColumnTitle {

    /**
     * 比如52 在正常的26进制中(A=0, B=1, Z=25) 为A = 2 * 16^1 + 0 * 26^0
     * 正常的26在26进制中为BA = 1 * 26^1 + 0 * 26^0
     *
     * 这道题要把BA变成Z 所以遇到26要insert Z并且在当前位就把26减掉，这样算下一个高位的时候就会少一个26
     *
     * */
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        int num = n;
        while (num > 0) {
            int current = num % 26;
            if (current == 0) {
                sb.insert(0, "Z");
                num -= 26; // 减去当前的26 后面以为的高位会减1
            }
            else
                sb.insert(0, (char)(current - 1 + 'A')); // 后面的高位减1
            num = num / 26;
        }
        return sb.toString();
    }
}
