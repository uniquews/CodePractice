package fb;

public class RemoveInvalidParenthesesOutputOne {
//    public String removeParentheses(String s) {
//        char[] pair1 = {'(', ')'};
//        StringBuilder tmp1 = helper(s, pair1);
//        char[] pair2 = {')', '('};
//        StringBuilder tmp2 = helper(tmp1.reverse().toString(), pair2);
//        return tmp2.reverse().toString();
//    }
//
//    private StringBuilder helper(String s, char[] pair) {
//        int count = 0;
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) != pair[0] && s.charAt(i) != pair[1]) {
//                sb.append(s.charAt(i));
//                continue;
//            }
//            if (s.charAt(i) == pair[0]) {
//                count++;
//            } else {
//                count--;
//            }
//
//            if (count >= 0) {
//                sb.append(s.charAt(i));
//            } else {
//                count = 0;
//            }
//        }
//        return sb;
//    }
public String removeParentheses(String s) {
    if (s == null || s.length() == 0) {
        return s;
    }

    char[] pair1 = {'(', ')'};
    String tmp1 = helper(s, pair1);
    char[] pair2 = {')', '('};
    String tmp2 = helper(new StringBuilder(tmp1).reverse().toString(), pair2);
    return new StringBuilder(tmp2).reverse().toString();
}

    private String helper(String s, char[] pair) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != pair[0] && s.charAt(i) != pair[1]) {
                sb.append(s.charAt(i));
                continue;
            }
            if (s.charAt(i) == pair[0]) {
                count++;
            } else if (s.charAt(i) == pair[1]) {
                count--;
            }

            if (count >= 0) {
                sb.append(s.charAt(i));
            } else {
                count = 0;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
//        String s = "()())()";
        String s = "(a)())()";
//        String s = ")(";
//        String s = "(((((()";
        RemoveInvalidParenthesesOutputOne test = new RemoveInvalidParenthesesOutputOne();
        System.out.println(test.removeParentheses(s));
    }
}
