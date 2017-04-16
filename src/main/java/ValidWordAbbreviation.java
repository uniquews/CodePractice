/**
 * Created by shuaiwang on 4/16/17.
 */
public class ValidWordAbbreviation {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0, j = 0;
        for (; i < word.length() && j < abbr.length(); i++) {
            if (word.charAt(i) == abbr.charAt(j)) {
                j++;
                continue;
            }

            if (Character.isAlphabetic(abbr.charAt(j)) || abbr.charAt(j) == '0') {
                return false;
            }

            int start = j, num = 0;
            while (j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
                j++;
            }
            if (start != j) {
                num = Integer.parseInt(abbr.substring(start, j));
            }

            while (num > 1) {
                i++;
                num--;
            }
        }
        return i == word.length() && j == abbr.length();
    }
}
