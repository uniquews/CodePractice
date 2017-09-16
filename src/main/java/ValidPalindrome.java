/**
 * Created by shuaiwang on 6/8/17.
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        // Write your code here
        if (s == null || s.length() == 0)
            return true;

        int start = 0;
        int end = s.length() - 1;

        while (start <= end) {
            while (start <= end && !isValid(s.charAt(start)))
                start++;

            while (start <= end && !isValid(s.charAt(end)))
                end--;

            if (start > end) {
                break;
            }


            if (Character.toLowerCase(s.charAt(start)) == Character.toLowerCase(s.charAt(end))) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }

    private boolean isValid(char c) {
        return Character.isLetter(c) || Character.isDigit(c);
    }
}
