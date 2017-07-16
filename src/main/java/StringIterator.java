/**
 * Created by shuaiwang on 7/16/17.
 */
public class StringIterator {
    public char cur;
    public int index = 0;
    public int num = 0;
    public String s = null;

    public StringIterator(String compressedString) {
        s = compressedString;
        cur = getChar();
        num = getNum();
    }

    public char next() {
        char result = ' ';
        if (num != 0) {
            result = cur;
            num--;
        }

        if (num == 0) {
            cur = getChar();
            num = getNum();
        }
        return result;
    }

    public boolean hasNext() {
        if (s == null || (index == s.length() && num == 0))
            return false;
        return true;
    }

    public char getChar() {
        return index >= s.length() ? ' ' : s.charAt(index++);
    }

    public int getNum() {
        if (index >= s.length())
            return 0;
        int start = index, end = index;
        while (end < s.length() && Character.isDigit(s.charAt(end))) {
            end++;
        }
        index = end;
        return Integer.valueOf(s.substring(start, end));
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
