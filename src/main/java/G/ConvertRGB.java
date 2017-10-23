package G;

public class ConvertRGB {
    char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
    public String convertRgd(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= s.length() - 2; i += 2) {
            String cur = s.substring(i, i + 2);
            String digit = cur.substring(0, 1);
            int tmp = Integer.parseInt(digit, 16);

            int next1 = getDist(digit + digit, cur);
            int next2 = tmp - 1 < 0 ? Integer.MAX_VALUE : getDist(String.valueOf(map[tmp - 1]) + String.valueOf(map[tmp - 1]), cur);
            int next3 = tmp + 1 == 16 ? Integer.MAX_VALUE : getDist(String.valueOf(map[tmp + 1]) + String.valueOf(map[tmp + 1]), cur);
            String eachResult = digit;

            if (next1 > next2) {
                next1 = next2;
                eachResult = String.valueOf(map[tmp - 1]);
            }
            if (next1 > next3) {
                eachResult = String.valueOf(map[tmp + 1]);
            }
            sb.append(eachResult);
        }
        return sb.toString();
    }

    private int getDist(String a, String b) {
        int tmp1 = Integer.parseInt(a, 16);
        int tmp2 = Integer.parseInt(b, 16);
        return (tmp1 - tmp2) * (tmp1 - tmp2);
    }

    private String helper(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i)).append(s.charAt(i));
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String s = "09f166";
        ConvertRGB test = new ConvertRGB();
        System.out.print(test.convertRgd(s));
    }

}
