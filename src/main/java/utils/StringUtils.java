package utils;

/**
 * Created by bohan on 1/30/2017.
 *
 * @author Bohan Zheng
 */
public class StringUtils {
  public static String charArrayToString(char[] strs) {
    StringBuilder sb = new StringBuilder();
    int count = 0;
    for (char c : strs) {
      if (c == 0) {
        count++;
      } else {
        if (count != 0) {
          sb.append(count);
          count = 0;
        }
        sb.append(c);
      }
    }
    if (count != 0) {
      sb.append(count);
    }
    return sb.toString();
  }
}
