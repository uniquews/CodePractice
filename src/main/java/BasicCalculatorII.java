public class BasicCalculatorII {
//    public int calculate(String s) {
//        if (s == null || s.length() == 0) {
//            return 0;
//        }
//
//        s = s.trim().replaceAll(" +", "");
//
//        int result = 0;
//        int last = 0;
//
//        int index = 0;
//        while (index < s.length() && Character.isDigit(s.charAt(index))) {
//            index++;
//        }
//        result = Integer.valueOf(s.substring(0, index));
//        last = result;
//
//        for (int i = index; i < s.length(); i++) {
//            int j = i + 1;
//            while (j < s.length() && Character.isDigit(s.charAt(j))) {
//                j++;
//            }
//
//            int tmp = Integer.valueOf(s.substring(i + 1, j));
//
//            if (s.charAt(i) == '+') {
//                result += tmp;
//                last = tmp;
//            } else if (s.charAt(i) == '-') {
//                result -= tmp;
//                last = -tmp;
//            } else if (s.charAt(i) == '*') {
//                result -= last;
//                last *= tmp;
//                result += last;
//            } else {
//                result -= last;
//                last /= tmp;
//                result += last;
//            }
//            i = j - 1;
//        }
//        return result;
//    }
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        s = s.trim();

        int result;
        int last;

        int index = 0;
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            index++;
        }
        result = Integer.valueOf(s.substring(0, index));
        last = result;

        for (int i = index; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                continue;
            }
            int j = i + 1;
            // 易错
            while (j < s.length() && (Character.isDigit(s.charAt(j)) || s.charAt(j) == ' ')) {
                j++;
            }

            // 易错
            int tmp = Integer.valueOf(s.substring(i + 1, j).trim());

            if (s.charAt(i) == '+') {
                result += tmp;
                last = tmp;
            } else if (s.charAt(i) == '-') {
                result -= tmp;
                last = -tmp;
            } else if (s.charAt(i) == '*') {
                result -= last;
                last *= tmp;
                result += last;
            } else {
                result -= last;
                last /= tmp;
                result += last;
            }
            i = j - 1;
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "1 + 1";
        BasicCalculatorII test = new BasicCalculatorII();
        System.out.println(test.calculate(s));
    }
}
