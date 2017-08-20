import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by shuaiwang on 4/25/17.
 */
public class RemoveDuplicateLetters {
    /**
     * 思路是把每一个char放到当前它们放到最前面的位置且保证它只出现一次，能当道最前的位置是它前面没有比它更大的且不唯一的char
     * */
    public String removeDuplicateLetters(String s) {
        if (s == null || s == "") {
            return s;
        }

        boolean[] inStack = new boolean[26];
        Map<Character, Integer> map = new HashMap<>();
        Stack<Character> stk = new Stack<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : s.toCharArray()) {
            map.put(c, map.get(c) - 1);
            if (inStack[c - 'a']) // already in stack, dont add it again
                continue;
            while (!stk.isEmpty() && stk.peek() > c && map.get(stk.peek()) > 0) {
                inStack[stk.pop() - 'a'] = false;
            }
            inStack[c - 'a'] = true;
            stk.push(c);
        }

        StringBuilder sb = new StringBuilder();
        while (!stk.isEmpty()) {
            sb.insert(0, stk.pop());
        }
        return sb.toString();
    }
}
