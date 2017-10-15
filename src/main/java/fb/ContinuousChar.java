package fb;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.ArrayList;
import java.util.List;

public class ContinuousChar {
    public List<Character> continuousChar(String s) {
        List<Character> result = new ArrayList<>();

        if (s == null || s.length() == 0) {
            return result;
        }

        int maxLen = 1;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                continue;
            }
            int len = 1;
            int j = i + 1;
            while (j < s.length() && (s.charAt(i) == s.charAt(j) || s.charAt(j) == ' ')) {
                if (s.charAt(i) == s.charAt(j)) {
                    len++;
                }
                j++;
            }

            if (len == maxLen) {
                result.add(s.charAt(i));
            }

            if (len > maxLen) {
                maxLen = len;
                result.clear();
                result.add(s.charAt(i));
            }
            i = j - 1;
        }
        return result;
    }

    public static void main(String[] args) {

//        String a = "this send meet";
        String a = "this is pea";
        ContinuousChar test = new ContinuousChar();
        List<Character> result = test.continuousChar(a);
        for (Character c : result) {
            System.out.println(c);
        }

    }
}
