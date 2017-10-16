import javax.xml.stream.events.Characters;
import java.util.*;

/**
 * Created by shuaiwang on 3/13/17.
 */
public class StrobogrammaticNumberII {
    // bfs
//    public List<String> findStrobogrammatic(int n) {
//        Map<Character, Character> map = new HashMap<>();
//        map.put('1', '1');
//        map.put('6', '9');
//        map.put('8', '8');
//        map.put('9', '6');
//        map.put('0', '0');
//
//        List<String> even = Arrays.asList("");
//        List<String> odd = Arrays.asList("0", "1", "8");
//
//        List<String> start;
//        if (n % 2 == 0) {
//            start = even;
//        } else {
//            start = odd;
//        }
//
//        while (n >= 2) {
//            List<String> next = new ArrayList<>();
//            for (String s : start) {
//                String tmp = "";
//                for (Character c : map.keySet()) {
//                    if ((n == 2 || n == 3) && c == '0') {
//                        continue;
//                    }
//                    tmp = c + s + map.get(c);
//                    next.add(tmp);
//                }
//            }
//            start = next;
//            n -= 2;
//        }
//        return start;
//    }

    public List<String> findStrobogrammatic(int n) {
        Map<Character, Character> map = new HashMap<>();
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');
        map.put('0', '0');

        char[] s = new char[n];
        List<String> result = new ArrayList<>();
        dfs(map, s, 0, n - 1, result);
        return result;
    }

    private void dfs(Map<Character, Character> map, char[] s, int start, int end, List<String> result) {
        if (start > end) {
            result.add(new String(s));
            return;
        }

        if (start == end) {
            for (Character c : map.keySet()) {
                if (c == map.get(c)) {
                    s[start] = c;
                    result.add(new String(s));
                }
            }
            return;
        }

        for (Character c : map.keySet()) {
            if (start == 0 && c == '0') {
                continue;
            }
            s[start] = c;
            s[end] = map.get(c);
            dfs(map, s, start + 1, end - 1, result);
        }
    }

    public static void main(String[] args) {
        StrobogrammaticNumberII test = new StrobogrammaticNumberII();
        test.findStrobogrammatic(1);
    }
}
