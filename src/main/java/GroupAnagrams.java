import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] tmp = s.toCharArray();
            Arrays.sort(tmp);
            String key = new String(tmp);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(s);
            map.put(key, list);
        }

        for (String key : map.keySet()) {
            result.add(map.get(key));
        }
        return result;
    }
}
