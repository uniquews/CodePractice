package b;

import java.util.Stack;

/**
 * Created by bohan on 4/25/17.
 */
public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        int[] charCount = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i) - 'a'] += 1;
        }
        boolean[] stackContains = new boolean[26];
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stackContains[c - 'a']) {
                charCount[c - 'a'] -= 1;
                continue;
            }
            while (!stack.isEmpty()) {
                char stackTop = stack.peek();
                if (c < stackTop && charCount[stackTop - 'a'] > 1) {
                    stack.pop();
                    charCount[stackTop - 'a'] -= 1;
                    stackContains[stackTop - 'a'] = false;
                } else {
                    break;
                }
            }
            stack.push(c);
            stackContains[c - 'a'] = true;
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.insert(0, stack.pop());
        }
        return builder.toString();
    }
}
