package b;

import java.util.Stack;

/**
 * Created by bohan on 7/16/17.
 */
public class DecodeString {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); ) {
            char c = s.charAt(i);
            if (c == ']') {
                stack.push(getString(stack));
                i++;
            } else if (Character.isLetter(c)) {
                int end = getLetters(s, i);
                stack.push(s.substring(i, end));
                i = end;
            } else if (Character.isDigit(c)) {
                int end = getDigits(s, i);
                stack.push(s.substring(i, end));
                i = end;
            } else if (c == '[') {
                i++;
            }
        }
        return getString(stack);
    }

    private String getString(Stack<String> stack) {
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            String str = stack.pop();
            int num = parseNumber(str);
            if (num == -1) {
                sb.insert(0, str);
            } else {
                String tmp = sb.toString();
                while (num > 1) {
                    num--;
                    sb.append(tmp);
                }
                break;
            }
        }
        return sb.toString();
    }

    private int parseNumber(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private int getDigits(String s, int start) {
        while (start < s.length() && Character.isDigit(s.charAt(start))) {
            start++;
        }
        return start;
    }

    private int getLetters(String s, int start) {
        while (start < s.length() && Character.isLetter(s.charAt(start))) {
            start++;
        }
        return start;
    }
}
