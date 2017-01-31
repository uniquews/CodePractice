import utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * The following solution is what based on the idea
 * that each position has the chance to be abbreviated
 * to 1 or not with a recursion function call.
 * It is quite similar to the question of SubsetsII.
 * <p>
 * Created by shuaiwang on 1/29/17.
 */
public class GeneralizedAbbreviation {
  public List<String> generateAbbreviations(String word) {
    List<String> result = new ArrayList<>();
    helper(word, word.toCharArray(), 0, result);
    return result;
  }

  private void helper(String word, char[] current, int index, List<String> result) {
    result.add(StringUtils.charArrayToString(current));
    for (int i = index; i < word.length(); i++) {
      current[i] = 0;
      helper(word, current, i + 1, result);
      current[i] = word.charAt(i);
    }
  }
}
