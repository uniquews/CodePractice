/**
 * Created by shuaiwang on 5/1/17.
 */
public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        if (word.charAt(0) >= 'A' && word.charAt(0) <= 'Z') {
            int index = 1;
            return allLower(word) || allUpper(word);
        } else {
            return allLower(word);
        }
    }

    private boolean allLower(String word) {
        int index = 1;
        while (index < word.length() && word.charAt(index) >= 'a' && word.charAt(index) <= 'z') {
            index++;
        }
        return index == word.length();
    }

    private boolean allUpper(String word) {
        int index = 1;
        while (index < word.length() && word.charAt(index) >= 'A' && word.charAt(index) <= 'Z') {
            index++;
        }
        return index == word.length();
    }
}
