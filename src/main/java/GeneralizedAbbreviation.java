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
//  public List<String> generateAbbreviations(String word) {
//    List<String> result = new ArrayList<>();
//    helper(word, word.toCharArray(), 0, result);
//    return result;
//  }
//
//  private void helper(String word, char[] current, int index, List<String> result) {
//    String currentAfterCompress = compressString(current);
//    result.add(currentAfterCompress);
//
//    for (int i = index; i < word.length(); i++) {
//      char tmp = current[i];
//      current[i] = '1';
//      helper(word, current, i + 1, result);
//      current[i] = tmp;
//    }
//  }
//
//  private String compressString(char[] current) {
//    StringBuilder sb = new StringBuilder();
//    int start = 0;
//    while (start < current.length) {
//      if (current[start] == '1') {
//        int end = start;
//        int number = 0;
//        while (end < current.length && current[end] == '1') {
//          end++;
//          number++;
//        }
//        sb.append(Integer.toString(number));
//        start = end - 1;
//      } else {
//        sb.append(current[start]);
//      }
//      start++;
//    }
//
//    return sb.toString();
//  }

  public List<String> generateAbbreviations(String word) {
    List<String> result = new ArrayList<>();
    result.add(word);
    helper(result, word, 0);
    List<String> strs = new ArrayList<>();
    for (int i = 0; i < result.size(); i++) {
      strs.add(convert(result.get(i)));
    }
    return strs;
  }

  private void helper(List<String> result, String word, int index) {
    if (index == word.length()) {
      return;
    }

    char[] tmp = word.toCharArray();
    for (int i = index; i < tmp.length; i++) {
      char c = tmp[i];
      tmp[i] = '1';
      String next = new String(tmp);
      result.add(next);
      helper(result, next, i + 1);
      tmp[i] = c;
    }
  }

  private String convert(String s) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      if (Character.isDigit(s.charAt(i))) {
        int start = i, end = i;
        while (end < s.length() && Character.isDigit(s.charAt(end))) {
          end++;
        }
        String num = String.valueOf(end - start);
        sb.append(num);
        i = end - 1;
      } else {
        sb.append(s.charAt(i));
      }
    }
    return sb.toString();
  }
}
