/**
 * Created by shuaiwang on 4/16/17.
 */
public class ValidWordAbbreviation {
//    public boolean validWordAbbreviation(String word, String abbr) {
//        int i = 0, j = 0;
//        for (; i < word.length() && j < abbr.length(); i++) {
//            if (word.charAt(i) == abbr.charAt(j)) {
//                j++;
//                continue;
//            }
//
//            if (Character.isAlphabetic(abbr.charAt(j)) || abbr.charAt(j) == '0') {
//                return false;
//            }
//
//            int start = j, num = 0;
//            while (j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
//                j++;
//            }
//            if (start != j) {
//                num = Integer.parseInt(abbr.substring(start, j));
//            }
//
//            while (num > 1) {
//                i++;
//                num--;
//            }
//        }
//        return i == word.length() && j == abbr.length();
//    }

    /**
     * "a" "01" should return false....
     * */
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0, j = 0;

        while (i < word.length() && j < abbr.length()) {
            if (Character.isLetter(abbr.charAt(j))) {
                if (word.charAt(i) != abbr.charAt(j)) {
                    break;
                }
            } else {
                int start = j, end = j;
                if (abbr.charAt(j) == '0')
                    break;
                while (end < abbr.length() && Character.isDigit(abbr.charAt(end))) {
                    end++;
                }
                String sNum = abbr.substring(start, end);
                int num = Integer.valueOf(sNum);
                i += num - 1;
                j = end - 1;
            }
            i++;
            j++;
        }
        return i == word.length() && j == abbr.length();
    }

    public static void main(String[] args) {
        ValidWordAbbreviation test = new ValidWordAbbreviation();
        String word = "internationalization";
        String abbr = "i12iz4n";
        test.validWordAbbreviation(word, abbr);
    }
}
