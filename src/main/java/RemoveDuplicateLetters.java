import java.util.Stack;

/**
 * Created by shuaiwang on 4/25/17.
 */
public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        int[] map = new int[26];
        boolean[] inStack = new boolean[26];
        Stack<Character> stk = new Stack<>();

        for (char c : s.toCharArray()) {
            map[c - 'a']++;
        }

        for (char c : s.toCharArray()) {
            map[c - 'a']--;
            if (inStack[c - 'a'])
                continue;
            while (!stk.isEmpty() && stk.peek() > c && map[stk.peek() - 'a'] > 0) {
                inStack[stk.pop() - 'a'] = false;
            }
            stk.push(c);
            inStack[c - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!stk.isEmpty()) {
            sb.insert(0, stk.pop());
        }
        return sb.toString();
    }
}
