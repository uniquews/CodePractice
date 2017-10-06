package fb;

public class SolveTheEquationFB {
    public String solveEquation(String equation) {
        String[] s = equation.split("=");
        int[] left = helper(s[0]);
        int[] right = helper(s[1]);

        int count1 = left[0] - right[0];
        int count2 = right[1] - left[1];

        if (count1 == 0 && count2 == 0) {
            return "Infinite solutions";
        } else if (count1 == 0 && count2 != 0) {
            return "No solution";
        } else {
            return "x=" + String.valueOf(count2 / count1);
        }
    }

    private int findCorrespondingParen(String s, int left) {
        int open = 1;
        for (int i = left + 1; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                open++;
            } else if (s.charAt(i) == ')') {
                open--;
            }

            if (open == 0) {
                return i;
            }
        }
        return -1; // dummy
    }

    private String dfs(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                int right = findCorrespondingParen(s, i);
                String next = dfs(s.substring(i + 1, right)); //  i +1 跳过左括号

                if (i == 0 || s.charAt(i - 1) == '+') {
                    sb.append(next);
                } else {
                    char[] tmp = next.toCharArray();
                    for (int j = 0; j < next.toCharArray().length; j++) {
                        if (tmp[j] == '+') {
                            tmp[j] = '-';
                        } else if (tmp[j] == '-') {
                            tmp[j] = '+';
                        }
                    }
                    sb.append(tmp);
                }
                i = right;
            } else if (s.charAt(i) != '(') {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }

    private int[] helper(String s) {
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < s.length(); i++) {
            int j = i;
            while (j < s.length() && s.charAt(j) != '+' && s.charAt(j) != '-') {
                j++;
            }

            String tmp = s.substring(i, j);
            if (tmp.length() == 0) { // "-x=-1"
                continue;
            }
            int num;
            if (tmp.contains("x")) {
                num = tmp.length() == 1 ? 1 : Integer.valueOf(tmp.substring(0, tmp.length() - 1));
                if (i == 0 || s.charAt(i - 1) == '+') {
                    count1 += num;
                } else {
                    count1 -= num;
                }
            } else {
                num = Integer.valueOf(tmp);
                if (i == 0 || s.charAt(i - 1) == '+') {
                    count2 += num;
                } else {
                    count2 -= num;
                }
            }
            i = j;
        }
        int[] result = new int[2];
        result[0] = count1;
        result[1] = count2;
        return result;
    }

    public static void main(String[] args) {
        String a = "5-(3-(2+1)+4)";
        SolveTheEquationFB test = new SolveTheEquationFB();
        System.out.print(test.dfs(a));
    }
}
