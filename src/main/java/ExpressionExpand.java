import java.util.Stack;

/**
 * Created by shuaiwang on 1/31/17.
 */

// Better method see Decode String
public class ExpressionExpand {
    public String expressionExpand(String s) {
        // write your code here
        if (s == null) {
            return "";
        }
        Stack<StringBuilder> stk = new Stack<>();
        stk.push(new StringBuilder());
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                int j = i + 1;
                while (j < s.length() && Character.isDigit(s.charAt(j))) {
                    j++;
                }
                String num = s.substring(i, j);
                stk.push(new StringBuilder(num));
                stk.push(new StringBuilder());
                i = j; //  skip [
            } else if (Character.isLetter(s.charAt(i))) {
                stk.peek().append(s.charAt(i));
            } else if (s.charAt(i) == ']') {
                StringBuilder next = stk.pop();
                int num = Integer.valueOf(stk.pop().toString());
                while (num > 0) {
                    stk.peek().append(next);
                    num--;
                }
            }
        }
        return stk.pop().toString();
    }

    public static void main(String[] args) {
        ExpressionExpand test = new ExpressionExpand();
        String s1 = "3[2[ad]3[pf]]xyz";
        String s2 = "abc3[a]";
        String s3 = "3[abc]";
        String s4 = "4[ac]dy";
        String s5 = "4[wer]0[er]";

        String a = "1";
        Integer an = 1;
        an -= 1;
        System.out.print(test.expressionExpand(s5));
    }

}
