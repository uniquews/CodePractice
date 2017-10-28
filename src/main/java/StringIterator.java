/**
 * Created by shuaiwang on 7/16/17.
 */
public class StringIterator {
    private char cur;
    private int num;
    private int index;
    private String s;
    public StringIterator(String compressedString) {
        s = compressedString;
        helper();
    }

    private void helper() {
        while (index < s.length() && num == 0) {
            cur = s.charAt(index);
            int j = index + 1;
            while (j < s.length() && Character.isDigit(s.charAt(j))) {
                j++;
            }
            num = Integer.parseInt(s.substring(index + 1, j));
            index = j;
        }
    }

    public char next() {
        helper();
        if (num == 0) {
            return ' ';
        } else {
            num--;
            return cur;
        }
    }

    public boolean hasNext() {
        return num != 0 || index != s.length();
    }

    public static void main(String[] args) {
        StringIterator test = new StringIterator("x6");
        test.next();
        test.next();
        test.next();
        test.hasNext();
        test.next();
        test.next();
        test.next();
        test.next();
    }
}
