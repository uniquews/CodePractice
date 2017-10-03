package fb;

import java.util.ArrayList;
import java.util.List;

public class DecodeWayPrint {
    public List<String> decodeWay(String s) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(s, 0, sb, result);
        return result;
    }

    private void helper(String s, int index, StringBuilder sb, List<String> result) {
        if (index == s.length()) {
            sb.deleteCharAt(sb.length() - 1);
            result.add(sb.toString());
            return;
        }

        int len = sb.length();
        if (s.charAt(index) != '0') {
            sb.append(s.charAt(index)).append(" ");
            helper(s, index + 1, sb, result);
        }
        sb.setLength(len);

        if (index < s.length() - 1) {
            int tmp = Integer.valueOf(s.substring(index, index + 2));
            if (tmp >= 10 && tmp <= 26) {
                sb.append(s.substring(index, index + 2)).append(" ");
                helper(s, index + 2, sb, result);
            }
        }
        sb.setLength(len);
    }

    public static void main(String[] args) {
        DecodeWayPrint test = new DecodeWayPrint();
//        String s = "12";
//        String s = "10";
//        String s = "1234";
        String s = "01";
        List<String> result = test.decodeWay(s);
        for (String r : result) {
            System.out.print(r + ", ");
        }
    }
}
