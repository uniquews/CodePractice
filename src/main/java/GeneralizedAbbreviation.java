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
        helper(word, word.toCharArray(), 0, result);
        return result;
    }

    private void helper(String word, char[] current, int index, List<String> result) {
        String currentAfterCompress = compressString(current);
        result.add(currentAfterCompress);

        for (int i = index; i < word.length(); i++) {
            char tmp = current[i];
            current[i] = '1';
            helper(word, current, i + 1, result);
            current[i] = tmp;
        }
    }

    private String compressString(char[] current) {
        StringBuilder sb = new StringBuilder();
        int start = 0;
        while (start < current.length) {
            if (current[start] == '1') {
                int end = start;
                int number = 0;
                while (end < current.length && current[end] == '1') {
                    end++;
                    number++;
                }
                sb.append(Integer.toString(number));
                start = end - 1;
            } else {
                sb.append(current[start]);
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
