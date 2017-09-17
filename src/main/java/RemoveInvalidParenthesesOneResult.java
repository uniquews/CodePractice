public class RemoveInvalidParenthesesOneResult {

    class ReturnType {
        public String s;
        public int count;
        public ReturnType(String ss, int cc) {
            s = ss;
            count = cc;
        }
    }
    public String remove(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        char[] pair = {'(', ')'};
        ReturnType leftToRight = helper(s, pair);
        char[] pair2 = {')', '('};

        ReturnType rightToLeft = helper(new StringBuilder(s).reverse().toString(), pair2);

        if (leftToRight.count == 0) {
            return leftToRight.s;
        }

        if (rightToLeft.count == 0) {
            return new StringBuilder(rightToLeft.s).reverse().toString();
        }
        return "";
    }
    private ReturnType helper(String s, char[] pair) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '(' && s.charAt(i) != ')') {
                continue;
            }

            if (s.charAt(i) == pair[0]) {
                count++;
            }
            if (s.charAt(i) == pair[1]) {
                count--;
            }

            if (count < 0) {
                s = s.substring(0, i) + s.substring(i + 1);
                i--;
                count++;
            }
        }
        return new ReturnType(s, count);
    }

    public static void main(String[] args) {
        String s = "(((";
        RemoveInvalidParenthesesOneResult test = new RemoveInvalidParenthesesOneResult();
        System.out.println(test.remove(s));
    }
}
