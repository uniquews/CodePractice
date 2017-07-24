/**
 * Created by shuaiwang on 7/16/17.
 */
public class StringIterator {
    private char c;
    private int occur = 0;
    private int index = 0;
    private String s = null;
    public StringIterator(String compressedString) {
        s = compressedString;
        getChar();
    }

    public char next() {
        char result = c;
        if (occur > 0)
            occur--;
        getChar();
        return result;
    }

    public boolean hasNext() {
        if (occur != 0)
            return true;
        if (index != s.length())
            return true;
        return false;
    }

    private void getChar() {
        if (occur > 0)
            return;
        if (index == s.length()) {
            c = ' ';
            return;
        }
        c = s.charAt(index++);
        getNum();
    }

    private void getNum() {
        int start = index, end = index;
        while (end < s.length() && Character.isDigit(s.charAt(end))) {
            end++;
        }
        occur = Integer.valueOf(s.substring(start, end));
        index = end;
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
