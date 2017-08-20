import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shuaiwang on 3/13/17.
 */
public class StrobogrammaticNumberII {
//    public List<String> findStrobogrammatic(int n) {
//        HashMap<Character, Character> map = new HashMap<>();
//        map.put('1', '1');
//        map.put('6', '9');
//        map.put('8', '8');
//        map.put('9', '6');
//        map.put('0', '0');
//
//        char[] s = new char[n];
//        List<String> result = new ArrayList<>();
//        dfs(map, s, result, 0, n - 1);
//        return result;
//    }
//
//    private void dfs(HashMap<Character, Character> map, char[] s, List<String> result, int start, int end) {
//        if (start > end) {
//            result.add(new String(s));//
//            //Calling toString on an array will call the toString method from Object. Which will return you the hashCode
//            // s.toString is wrong...
//            return;
//        }
//
//        if (start == end) {
//            for (Map.Entry<Character, Character> entry: map.entrySet()) {
//                if (entry.getKey() == entry.getValue()) {
//                    s[start] = entry.getKey();
//                    s[end] = entry.getValue();
//                    result.add(new String(s));
//                }
//            }
//            return;
//        }
//
//        for (Map.Entry<Character, Character> entry: map.entrySet()) {
//            if (start == 0 && entry.getKey() == '0') {
//                continue;
//            }
//            s[start] = entry.getKey();
//            s[end] = entry.getValue();
//
//            dfs(map, s, result, start + 1, end - 1);
//        }
//    }

    public List<String> findStrobogrammatic(int n) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');
        map.put('0', '0');

        char[] s = new char[n];
        List<String> result = new ArrayList<>();
        dfs(result, s, 0, n - 1, map);
        return result;
    }

    private void dfs(List<String> result, char[] s, int left, int right, HashMap<Character, Character> map) {
        if (left > right) {
            result.add(new String(s));
            return;
        }

        if (left == right) {
            for (Character c : map.keySet()) {
                if (c == map.get(c)) {
                    s[left] = c;
                    result.add(new String(s));
                }
            }
            return;
        }

        for (Character c : map.keySet()) {
            if (left == 0 && c == '0') {
                continue;
            }
            s[left] = c;
            s[right] = map.get(c);
            dfs(result, s, left + 1, right - 1, map);
        }
        return;
    }

    public static void main(String[] args) {
        StrobogrammaticNumberII test = new StrobogrammaticNumberII();
        test.findStrobogrammatic(1);
    }
}
