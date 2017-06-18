/**
 * Created by shuaiwang on 6/18/17.
 */
public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int result = 0;
        int digit = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == 'Z') {
                result += 26 * digit;
            } else {
                result += ((s.charAt(i) - 'A') + 1) * digit;
            }
            digit *= 26;
        }
        return result;
    }
}
