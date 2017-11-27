package fb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllStringWIthSamePattern {
    /**
     * 输入vector<string> strs = {"aabb", "ccdd", "ddyy", "abb","dgg","joe"}，
     * 输出多少对pattern match的数目。对于这道题"aabb", "ccdd", "ddyy"是三对match的， "abb","dgg"这是一对。
     * 用的hashtable。时间复杂度是O(NK) N是string数目，K是平均string长度，空间复杂度是O（N*K）
     *
     * */

    public List<List<String>> findSamePattern(List<String> str) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : str) {
            String key = encodeString(s);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(s);
            map.put(key, list);
        }
        List<List<String>> result = new ArrayList<>();
        for (List<String> l : map.values()) {
            result.add(l);
        }
        return result;
    }

    private String encodeString(String s) {
        Map<Character, Integer> map = new HashMap<>(); // max size is 26
        int count = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                sb.append((char)(map.get(s.charAt(i)) + 'a'));
            } else {
                sb.append((char) ('a' + count));
                map.put(s.charAt(i), count);
                count++;
            }
        }
        return sb.toString();
    }
}
