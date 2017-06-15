import java.util.Stack;

/**
 * Created by shuaiwang on 1/31/17.
 */

// Better method see Decode String
public class ExpressionExpand {
//    public String expressionExpand(String s) {
//        // Write your code here
//        if (s == null || s.length() == 0 || s.charAt(0) == '0')
//            return "";
//        StringBuilder sb = new StringBuilder();
//        helper(s, 0, 1, sb);
//        return sb.toString();
//    }
//
//    private int helper(String s, int index, int times, StringBuilder sb) {
//        int endIndexOfSubString = index;
//        // this while loop is for when times = 0, then it needs to find the most recent ]
//        while (endIndexOfSubString < s.length() && s.charAt(endIndexOfSubString) != ']') {
//            endIndexOfSubString++;
//        }
//        while (times != 0) {
//            for (int i = index; i < s.length(); i++) {
//                if (s.charAt(i) == ']') {
//                    endIndexOfSubString = i;
//                    break;
//                } else if (!isCurrentNumber(s.charAt(i))) {
//                    sb.append(s.charAt(i));
//                } else {
//                    // first, we need to extact number
//                    int start = i, left = i + 1;
//                    while (s.charAt(left) != '[') {//
//                        left++;
//                    }
//                    int numbers = Integer.parseInt(s.substring(start, left));
//                    int end = helper(s,left+ 1, numbers, sb);
//                    i = end;
//                }
//            }
//            times--;
//        }
//        return endIndexOfSubString;
//    }
//
//    private boolean isCurrentNumber(char c) {
//        if (c >= '0' && c <= '9') {
//            return true;
//        } else {
//            return false;
//        }
//    }

    public String expressionExpand(String s) {
        // Write your code here
        Stack<String> stk = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                int endOfDigit = i;
                while (endOfDigit < s.length() && Character.isDigit(s.charAt(endOfDigit))) {
                    endOfDigit++;
                }
                String number = s.substring(i, endOfDigit);
                stk.add(number);
                i = endOfDigit - 1;
            } else if (s.charAt(i) == '[') {
                continue;
            } else if (s.charAt(i) == ']') {
              // pop stack
                StringBuilder unit = new StringBuilder();
                while (!stk.isEmpty() && !Character.isDigit(stk.peek().charAt(0))) {
                    unit.insert(0, stk.pop());
                }
                StringBuilder sb = new StringBuilder();
                Integer number = 1;
                if (!stk.isEmpty()) {
                    number = Integer.parseInt(stk.pop());
                }
                while (number > 0) {
                    sb = sb.append(unit);
                    number--;
                }
                if (sb.length() > 0)
                    stk.push(sb.toString());
            } else {
                stk.push(String.valueOf(s.charAt(i)));
            }
        }
        if (stk.isEmpty())
            return "";
        else {
            StringBuilder result = new StringBuilder();
            while (!stk.isEmpty()) {
                result.insert(0, stk.pop());
            }
            return result.toString();
        }
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
