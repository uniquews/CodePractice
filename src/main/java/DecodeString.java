/**
 * Created by shuaiwang on 2/28/17.
 */
public class DecodeString {
    public String decodeString(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        helper(s, 0, sb);
        return sb.toString();
    }

    private int helper(String s, int index, StringBuilder sb) {
        int endIndexOfSubstring = 0; // endIndexOfSubstring means the ] of current level substring
        for (int i = index; i < s.length(); i++) {
            if (s.charAt(i) == ']') { // if we met ']', then it means the current level string is end
                endIndexOfSubstring = i;
                return endIndexOfSubstring;
            }
            if (isCurrentNumber(s.charAt(i))) { // if it is number
                int j = i; // j is index of [
                while (j < s.length() && isCurrentNumber(s.charAt(j))) {
                    j++;
                }
                int times = Integer.parseInt(s.substring(i, j));

                endIndexOfSubstring = i;
                while (endIndexOfSubstring < s.length() && s.charAt(endIndexOfSubstring) != ']') {
                    endIndexOfSubstring++;
                }
                i = endIndexOfSubstring;
                while (times != 0) {
                    i = helper(s, j + 1, sb);
                    times--;
                }
            } else {
                sb.append(s.charAt(i));
            }
        }
        return endIndexOfSubstring;
    }

    private boolean isCurrentNumber(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String s = "3[a2[c]]";
        DecodeString test = new DecodeString();
        System.out.print(test.decodeString(s)) ;
    }
}
