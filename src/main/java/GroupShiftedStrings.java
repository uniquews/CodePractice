import java.util.*;

/**
 * Created by shuaiwang on 3/22/17.
 */
public class GroupShiftedStrings {
//    public List<List<String>> groupStrings(String[] strings) {
//        HashMap<String, List<String>> map = new HashMap<>();
//        List<List<String>> result = new ArrayList<>();
//
//        for (int i = 0; i < strings.length; i++) {
//            String key = projection(strings[i]);
//            if (map.containsKey(key)) {
//                map.get(key).add(strings[i]);
//            } else {
//                map.put(key, new ArrayList<>(Arrays.asList(strings[i])));
//            }
//        }
//
//        result.addAll(map.values());
//        return result;
//    }
//
//    private String projection(String str) {
//        char first = str.charAt(0);
//        int dis = first - 'a';
//        char[] charArray = new char[str.length()];
//        for (int i = 0; i < str.length(); i++) {
//            int tmp = str.charAt(i) - 'a' - dis <= 0 ? str.charAt(i) - 'a' - dis + 26: str.charAt(i) - 'a' - dis;
//            charArray[i] = (char)(tmp + 'a');
//        }
//        return new String(charArray);
//    }

//    public List<List<String>> groupStrings(String[] strings) {
//        List<List<String>> result = new ArrayList<>();
//        Map<String, List<String>> map = new HashMap<>();
//        for (String s : strings) {
//            helper(map, s);
//        }
//        for (String k : map.keySet()) {
//            result.add(map.get(k));
//        }
//        return result;
//    }
//
//    private void helper(Map<String, List<String>> map, String s) {
//        int dis = s.charAt(0) - 'a';
//        String current = "";
//        for (int i = 0; i < s.length(); i++) {
//            int tmp = s.charAt(i) - 'a' - dis;
//
//            int c = (tmp < 0 ? tmp + 26 : tmp);
//            current += (char)(c + 'a');
//        }
//        List<String> v = map.getOrDefault(current, new ArrayList<>());
//        v.add(s);
//        map.put(current, v);
//    }

    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> result = new ArrayList<>();

        if (strings == null || strings.length == 0) {
            return result;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strings) {
            if (s == null || s.length() == 0)
                continue;
            int dist = s.charAt(0) - 'a';
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                int j = s.charAt(i) - 'a';
                char n = (char)((j - dist + 26) % 26 + 'a');
                sb.append(n);
            }
            List<String> l = map.getOrDefault(sb.toString(), new ArrayList<>());
            l.add(s);
            map.put(sb.toString(), l);
        }
        for (String k : map.keySet()) {
            result.add(map.get(k));
        }
        return result;
    }

    public static void main(String[] args) {
        String[] string = {"ba", "az"};
        GroupShiftedStrings test = new GroupShiftedStrings();
        test.groupStrings(string);
//        char t = 'z';
//        System.out.println((char)('a' - 'a' - 1 + 26 + 'a'));
    }
}
