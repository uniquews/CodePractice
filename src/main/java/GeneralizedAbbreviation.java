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
        String currentStep;
        if (index > 0 && current.charAt(index - 1) >= '1' && current.charAt(index - 1) <= '9') {
            currentStep = current.substring(0, index - 1) +
                    (Integer.toString(current.charAt(index - 1) - '0' + 1)) +
                    current.substring(index + 1);
            result.add(currentStep);
        } else {
            currentStep = current;
            result.add(currentStep);
        }

        for (int i = index; i < word.length(); i++) {
            String tmp;
            if (index <= word.length() - 2) {
                tmp = current.substring(0, index) + "1" + current.substring(index + 1);
            } else {
                tmp = current.substring(0, index) + "1";
            }

            helper(word, tmp, i + 1, result);
        }
    }

    public static void main(String[] args) {
        GeneralizedAbbreviation test = new GeneralizedAbbreviation();
        String word = "word";
        System.out.print(test.generateAbbreviations(word));
    }
}
