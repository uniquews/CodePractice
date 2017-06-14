/**
 * Created by shuaiwang on 1/31/17.
 */

// Better method see Decode String
public class ExpressionExpand {
    public String expressionExpand(String s) {
        // Write your code here
        if (s == null || s.length() == 0 || s.charAt(0) == '0')
            return "";
        StringBuilder sb = new StringBuilder();
        helper(s, 0, 1, sb);
        return sb.toString();
    }

    private int helper(String s, int index, int times, StringBuilder sb) {
        int endIndexOfSubString = index;
        // this while loop is for when times = 0, then it needs to find the most recent ]
        while (endIndexOfSubString < s.length() && s.charAt(endIndexOfSubString) != ']') {
            endIndexOfSubString++;
        }
        while (times != 0) {
            for (int i = index; i < s.length(); i++) {
                if (s.charAt(i) == ']') {
                    endIndexOfSubString = i;
                    break;
                } else if (!isCurrentNumber(s.charAt(i))) {
                    sb.append(s.charAt(i));
                } else {
                    // first, we need to extact number
                    int start = i, left = i + 1;
                    while (s.charAt(left) != '[') {//
                        left++;
                    }
                    int numbers = Integer.parseInt(s.substring(start, left));
                    int end = helper(s,left+ 1, numbers, sb);
                    i = end;
                }
            }
            times--;
        }
        return endIndexOfSubString;
    }

    private boolean isCurrentNumber(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        ExpressionExpand test = new ExpressionExpand();
        String s1 = "3[2[ad]3[pf]]xyz";
        String s2 = "abc3[a]";
        String s3 = "3[abc]";
        String s4 = "4[ac]dy";
        String s5 = "4[wer]0[er]";
        System.out.print(test.expressionExpand(s5));
    }

}
