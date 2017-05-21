/**
 * Created by shuaiwang on 5/21/17.
 */
public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        int num = n;
        while (num > 0) {
            int current = num % 26;
            if (current == 0) {
                sb.insert(0, "Z");
                num -= 26;
            }
            else
                sb.insert(0, (char)(current - 1 + 'A'));
            num = num / 26;
        }
        return sb.toString();
    }
}
