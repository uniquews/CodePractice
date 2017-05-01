import java.util.*;

/**
 * Created by shuaiwang on 4/30/17.
 */
public class WordAbbreviation {
    public List<String> wordsAbbreviation(List<String> dict) {
        HashMap<String, String> wordToAbbrv = new HashMap<>();
        HashMap<String, List<String>> abbrToWord = new HashMap<>();

        for (String s : dict) {
            wordToAbbrv.put(s, getAbbreviation(s, 1));
        }

        for (String key : wordToAbbrv.keySet()) {
            if (!abbrToWord.containsKey(wordToAbbrv.get(key))) {
                abbrToWord.put(wordToAbbrv.get(key), new ArrayList<>(Arrays.asList(key)));
            } else {
                abbrToWord.get(wordToAbbrv.get(key)).add(key);
            }
        }

        List<List<String>> conflict = new ArrayList<>();
        for (String key : abbrToWord.keySet()) {
            if (abbrToWord.get(key).size() > 1) {
                // call cleanDuplicate
                conflict.add(abbrToWord.get(key));
            }
        }

        cleanDuplicate2(conflict, wordToAbbrv);

        List<String> result = new ArrayList<>();
        for (String s : dict) {
            result.add(wordToAbbrv.get(s));
        }
        return result;
    }

//    private void cleanDuplicate(int lenOfPrefix, List<String> words, HashMap<String, String> wordToAbbrv) {
//        HashMap<String, List<String>> abbrToWord = new HashMap<>();
//        for (String s : words) {
//            String abbr = getAbbreviation(s, lenOfPrefix);
//            if (!abbrToWord.containsKey(abbr)) {
//                abbrToWord.put(abbr, new ArrayList<>(Arrays.asList(s)));
//            } else {
//                abbrToWord.get(abbr).add(s);
//            }
//        }
//
//        for (String abbr : abbrToWord.keySet()) {
//            if (abbrToWord.get(abbr).size() == 1) {
//                wordToAbbrv.put(abbrToWord.get(abbr).get(0), abbr);
//            } else {
//                List<String> nextLevel = abbrToWord.get(abbr);
//                cleanDuplicate(lenOfPrefix + 1, nextLevel, wordToAbbrv);
//            }
//        }
//    }

    private void cleanDuplicate2(List<List<String>> words, HashMap<String, String> wordToAbbr) {
        List<List<String>> conflict = words;
        for (List<String> sameConflict : conflict) {
            for (int len = 2; sameConflict.size() > 0 && len <= sameConflict.get(0).length() - 2; len++) {
                HashMap<String, List<String>> abbrToWord = new HashMap<>();
                for (String s : sameConflict) {
                    String abbr = getAbbreviation(s, len);
                    if (!abbrToWord.containsKey(abbr)) {
                        abbrToWord.put(abbr, new ArrayList<>(Arrays.asList(s)));
                    } else {
                        abbrToWord.get(abbr).add(s);
                    }
                }
                for (String key : abbrToWord.keySet()) {
                    if (abbrToWord.get(key).size() == 1) {
                        wordToAbbr.put(abbrToWord.get(key).get(0), key);
                        sameConflict.remove(abbrToWord.get(key).get(0));
                    }
                }
            }
        }
    }

    private String getAbbreviation(String s, int lenOfPrefix) {
        if (s.length() <= 3) {
            return s;
        }

        if (lenOfPrefix == s.length() - 2) {
            return s;
        }

        String fist = s.substring(0, lenOfPrefix);
        String num = String.valueOf(s.length() - lenOfPrefix - 1);
        String second = s.substring(s.length() - 1);
        return fist + num + second;
    }

    public static void main(String[] args) {
        List<String> s = new ArrayList<>(Arrays.asList("abcdefg","abccefg","abcckkg"));
        WordAbbreviation test = new WordAbbreviation();
        test.wordsAbbreviation(s);

    }
}
