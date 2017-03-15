import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shuaiwang on 3/13/17.
 */
public class StrobogrammaticNumberII {
    public List<String> findStrobogrammatic(int n) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');
        map.put('0', '0');

        char[] s = new char[n];
        List<String> result = new ArrayList<>();
        dfs(map, s, result, 0, n - 1);
        return result;
    }

    private void dfs(HashMap<Character, Character> map, char[] s, List<String> result, int start, int end) {
        if (start > end) {
            result.add(new String(s));//
            //Calling toString on an array will call the toString method from Object. Which will return you the hashCode
            // s.toString is wrong...
            return;
        }

        if (start == end) {
            for (Map.Entry<Character, Character> entry: map.entrySet()) {
                if (entry.getKey() == entry.getValue()) {
                    s[start] = entry.getKey();
                    s[end] = entry.getValue();
                    result.add(new String(s));
                }
            }
            return;
        }

        for (Map.Entry<Character, Character> entry: map.entrySet()) {
            if (start == 0 && entry.getKey() == '0') {
                continue;
            }
            s[start] = entry.getKey();
            s[end] = entry.getValue();

            dfs(map, s, result, start + 1, end - 1);
        }
    }

    public static void main(String[] args) {
        StrobogrammaticNumberII test = new StrobogrammaticNumberII();
        test.findStrobogrammatic(3);
    }
}
