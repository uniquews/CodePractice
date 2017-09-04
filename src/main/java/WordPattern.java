import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by shuaiwang on 7/11/17.
 */
public class WordPattern {
    /**
     * Integer 超过128就不能用== 必须用Objects.equals
     * */
//    public boolean wordPattern(String pattern, String str) {
//        String[] arr = str.split(" ");
//        Map<Character, Integer> map1 = new HashMap<>();
//        Map<String, Integer> map2 = new HashMap<>();
//
//        if (pattern.length() != arr.length)
//            return false;
//
//        for (int i = 0; i < pattern.length(); i++) {
//            if (!Objects.equals(map1.put(pattern.charAt(i), i), map2.put(arr[i], i))) {
//                return false;
//            }
//        }
//        return true;
//    }

    public boolean wordPattern(String pattern, String str) {
        String[] arr = str.split(" ");
        Map<Character, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        if (pattern.length() != arr.length)
            return false;

        for (int i = 0; i < pattern.length(); i++) {
            if (map1.containsKey(pattern.charAt(i)) && map2.containsKey(arr[i])) {
                if (!Objects.equals(map1.get(pattern.charAt(i)), map2.get(arr[i]))) {
                    return false;
                }
            } else if (map1.containsKey(pattern.charAt(i)) && !map2.containsKey(arr[i])) {
                return false;
            } else if (!map1.containsKey(pattern.charAt(i)) && map2.containsKey(arr[i])) {
                return false;
            }
            map1.put(pattern.charAt(i), i);
            map2.put(arr[i], i);
        }
        return true;
    }

    public static void main(String[] args) {
        WordPattern test = new WordPattern();
        String p ="ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccdd";
//        String p ="cdd";
        String a = "s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s t t";
//        String a = "s t t";

        System.out.print(test.wordPattern(p, a));
//        Integer a = -215;
//        Integer b = -215;
//        if (a == b)
//            System.out.println("***");


    }
}
