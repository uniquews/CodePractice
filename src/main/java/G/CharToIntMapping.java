package G;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CharToIntMapping {
    public boolean isValidMapping(String a, String b, String c, Map<Character, Integer> map) {
        int numA = 0;
        int numB = 0;
        int numC = 0;
        for (int i = 0; i < a.length(); i++) {
            numA = numA * 10 + map.get(a.charAt(i));
        }

        for (int i = 0; i < b.length(); i++) {
            numB = numB * 10 + map.get(b.charAt(i));
        }

        for (int i = 0; i < c.length(); i++) {
            numC = numC * 10 + map.get(c.charAt(i));
        }

        return numA + numB == numC;
    }

    public Map<Character, Integer> generateMapping(String a, String b, String c) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            map.put(a.charAt(i), -1);
        }

        for (int i = 0; i < b.length(); i++) {
            map.put(b.charAt(i), -1);
        }

        for (int i = 0; i < c.length(); i++) {
            map.put(c.charAt(i), -1);
        }
        char[] str = new char[map.keySet().size()];
        Set<Integer> used = new HashSet<>();
        int index = 0;
        for (Character ch : map.keySet()) {
            str[index++] = ch;
        }
        if (dfs(str, 0, used, a, b, c, map)) {
            return map;
        }
        return null;
    }

    private boolean dfs(char[] str, int index, Set<Integer> used, String a, String b, String c, Map<Character, Integer> map) {
        if (index == str.length) {
            if (isValidMapping(a, b, c, map)) {
                return true;
            }
            return false;
        }

        for (int i = 0; i <= 9; i++) {
            if (used.contains(i)) {
                continue;
            }

            map.put(str[index], i);
            used.add(i);
            if (dfs(str, index + 1, used, a, b, c, map)) {
                return true;
            }
            used.remove(i);
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
