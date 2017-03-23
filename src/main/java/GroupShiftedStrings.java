import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by shuaiwang on 3/22/17.
 */
public class GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();

        for (int i = 0; i < strings.length; i++) {
            String key = projection(strings[i]);
            if (map.containsKey(key)) {
                map.get(key).add(strings[i]);
            } else {
                map.put(key, new ArrayList<>(Arrays.asList(strings[i])));
            }
        }

        result.addAll(map.values());
        return result;
    }

    private String projection(String str) {
        char first = str.charAt(0);
        int dis = first - 'a';
        char[] charArray = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            int tmp = str.charAt(i) - 'a' - dis <= 0 ? str.charAt(i) - 'a' - dis + 26: str.charAt(i) - 'a' - dis;
            charArray[i] = (char)(tmp + 'a');
        }
        return new String(charArray);
    }

    public static void main(String[] args) {
        char t = 'z';
        System.out.println((char)('a' - 'a' - 1 + 26 + 'a'));
    }
}
