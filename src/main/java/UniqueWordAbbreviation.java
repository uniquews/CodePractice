import java.util.*;

/**
 * Created by shuaiwang on 3/2/17.
 */
public class UniqueWordAbbreviation {
    Map<String, Set<String>> map = new HashMap<>();
    public UniqueWordAbbreviation(String[] dictionary) {
        for (String s : dictionary) {
        String abb = getAbbr(s);
        Set<String> set = map.getOrDefault(abb, new HashSet<>());
        set.add(s);
        map.put(abb, set);
    }
}

    public boolean isUnique(String word) {
        String abb = getAbbr(word);
        if (!map.containsKey(abb)) return true;
        if (map.get(abb).size() > 1) return false;
        if (!map.get(abb).contains(word)) return false;
        return true;
    }

    private String getAbbr(String s) {
        if (s.length() <= 2) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        sb.append(s.length() - 2);
        sb.append(s.charAt(s.length() - 1));
        return sb.toString();
    }



}
