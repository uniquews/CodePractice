import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuaiwang on 1/29/17.
 */

// The following solution is what based on the idea
// that each position has the chance to be abbreviated
// to 1 or not with a recursion function call.
// It is quite similar to the question of SubsetsII.
public class GeneralizedAbbreviation {
    public List<String> generateAbbreviations(String word) {
        List<String> result = new ArrayList<>();
        helper(word, word, 0, result);
        return result;
    }

    private void helper(String word, String current, int index, List<String> result) {
        String currentAfterCompress = compressString(current);
        result.add(currentAfterCompress);
//        result.add(current);

        for (int i = index; i < word.length(); i++) {
            String tmp;
            if (i <= word.length() - 2) {
                tmp = current.substring(0, i) + "1" + current.substring(i + 1);
            } else {
                tmp = current.substring(0, i) + "1";
            }

            helper(word, tmp, i + 1, result);
        }
    }

    private String compressString(String current) {
        StringBuilder sb = new StringBuilder();
        int start = 0;
        while (start < current.length()) {
            if (current.charAt(start) >= '1' && current.charAt(start) <= '9') {
                int end = start;
                int number = 0;
                while (end < current.length() && current.charAt(end) >= '1' && current.charAt(end) <= '9') {
                    end++;
                    number++;
                }
                sb.append(Integer.toString(number));
                start = end - 1;
            } else {
                sb.append(current.charAt(start));
            }
            start++;

        }

        return sb.toString();
    }

    public static void main(String[] args) {
        GeneralizedAbbreviation test = new GeneralizedAbbreviation();
        String word = "word";
        System.out.print(test.generateAbbreviations(word));
    }
}
