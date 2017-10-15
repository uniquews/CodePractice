package fb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DecodeWayPrint {
//    public List<String> decodeWay(String s) {
//        List<String> result = new ArrayList<>();
//        StringBuilder sb = new StringBuilder();
//        helper(s, 0, sb, result);
//        return result;
//    }
//
//    private void helper(String s, int index, StringBuilder sb, List<String> result) {
//        if (index == s.length()) {
//            sb.deleteCharAt(sb.length() - 1);
//            result.add(sb.toString());
//            return;
//        }
//
//        int len = sb.length();
//        if (s.charAt(index) != '0') {
//            sb.append(s.charAt(index)).append(" ");
//            helper(s, index + 1, sb, result);
//        }
//        sb.setLength(len);
//
//        if (index < s.length() - 1) {
//            int tmp = Integer.valueOf(s.substring(index, index + 2));
//            if (tmp >= 10 && tmp <= 26) {
//                sb.append(s.substring(index, index + 2)).append(" ");
//                helper(s, index + 2, sb, result);
//            }
//        }
//        sb.setLength(len);
//    }

    public List<String> decodeWay(String s) {
        Map<Integer, List<String>> cache = new HashMap<>();
        return helper(s, 0, cache);
    }

    private List<String> helper(String s, int index, Map<Integer, List<String>> cache) {
        List<String> result = new ArrayList<>();
        if (index == s.length()) {
            result.add("");
            return result;
        }

        if (cache.containsKey(index)) {
            return cache.get(index);
        }

        if (s.charAt(index) != '0') {
            List<String> next = helper(s, index + 1, cache);
            for (String n : next) {
                result.add(s.charAt(index) + "," + n);
            }
        }

        if (index < s.length() - 1) {
            int tmp = Integer.valueOf(s.substring(index, index + 2));
            if (tmp >= 10 && tmp <= 26) {
                List<String> next = helper(s, index + 2, cache);
                for (String n : next) {
                    result.add(s.substring(index, index + 2) + "," + n);
                }
            }
        }
        cache.put(index, result);
        return result;
    }



    public static void main(String[] args) {
        DecodeWayPrint test = new DecodeWayPrint();
//        String s = "12";
//        String s = "10";
        String s = "1234";
//        String s = "01";
        List<String> result = test.decodeWay(s);
        for (String r : result) {
            System.out.print(r + ", ");
        }
    }
}
