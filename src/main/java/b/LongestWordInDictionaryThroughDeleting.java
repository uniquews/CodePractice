package b;

import java.util.List;

/**
 * Created by bohan on 4/29/17.
 */
public class LongestWordInDictionaryThroughDeleting {
    public String findLongestWord(String s, List<String> d) {
        d.sort((s1, s2) -> {
            if (s1.length() == s2.length()) {
                return s1.compareTo(s2);
            } else {
                return s2.length() - s1.length();
            }
        });
        for (String word : d) {
            if (isSubSequenceOf(word, s)) {
                return word;
            }
        }
        return "";
    }

    private boolean isSubSequenceOf(String word, String s) {
        int j = 0;
        for (int i = 0; i < s.length() && j < word.length(); i++) {
            if (word.charAt(j) == s.charAt(i)) {
                j++;
            }
        }
        return j == word.length();
    }
}
