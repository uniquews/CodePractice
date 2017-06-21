/**
 * Created by shuaiwang on 6/21/17.
 */
public class ReverseWordsinaStringII {
    public void reverseWords(char[] s) {
        int start = 0, end = s.length - 1;
        while (start < end) {
            if (start < end) {
                swap(s, start, end);
                start++;
                end--;
            }
        }

        start = 0;
        while (start < s.length) {
            while (start < s.length && s[start] == ' ') {
                start++;
            }
            end = start;
            while (end < s.length && s[end] != ' ') {
                end++;
            }

            int i = start, j = end - 1;
            while (i < j) {
                swap(s, i, j);
                i++;
                j--;
            }
            start = end;
        }
    }

    private void swap(char[] s, int i, int j) {
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }

    public static void main(String[] args) {
        String s1 = "hello world!";
        ReverseWordsinaStringII test= new ReverseWordsinaStringII();
        test.reverseWords(s1.toCharArray());

    }
}
