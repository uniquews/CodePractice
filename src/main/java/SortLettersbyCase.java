/**
 * Created by shuaiwang on 10/14/16.
 */
public class SortLettersbyCase {
    public void sortLetters(char[] chars) {
        //write your code here
        if (chars == null || chars.length == 0) {
            return;
        }

        int lower = 0;
        int upper = chars.length - 1;

        while (lower <= upper) {
            while (lower <= upper && Character.isLowerCase(chars[lower])) {
                lower++;
            }

            while (upper >= lower && Character.isUpperCase(chars[upper])) {
                upper--;
            }

            if (lower < upper) {
                char tmp = chars[lower];
                chars[lower] = chars[upper];
                chars[upper] = tmp;
                lower++;
                upper--;
            }
        }
    }
}
