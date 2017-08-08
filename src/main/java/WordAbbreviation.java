import java.util.*;

/**
 * Created by shuaiwang on 4/30/17.
 */
public class WordAbbreviation {
    public List<String> wordsAbbreviation(List<String> dict) {
        Map<String, String> wordToAbbr = new HashMap<>();
        Map<String, List<String>> abbrToWord = new HashMap<>();
        List<String> result = new ArrayList<>();

        helper(wordToAbbr, dict, 1);
        for (String s : dict) {
            result.add(wordToAbbr.get(s));
        }
        return result;
    }

    private void helper(Map<String, String> wordToAbbr, List<String> wordWithSameAbbr, int preLen) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < wordWithSameAbbr.size(); i++) {
            String ab = getAbbr(wordWithSameAbbr.get(i), preLen);
            List<String> l = map.getOrDefault(ab, new ArrayList<>());
            l.add(wordWithSameAbbr.get(i));
            map.put(ab, l);
        }

        for (String s : map.keySet()) {
            if (map.get(s).size() == 1) {
                wordToAbbr.put(map.get(s).get(0), s);
            } else {
                helper(wordToAbbr, map.get(s), preLen + 1);
            }
        }
    }

    private String getAbbr(String s, int preLen) {
        if (s.length() <= 3 || preLen == s.length() - 2)
            return s;

        StringBuilder sb = new StringBuilder();
        String pre = s.substring(0, preLen);
        String num = String.valueOf(s.length() - 1 - preLen);
        sb.append(pre).append(num).append(s.charAt(s.length() - 1));
        return sb.toString();
    }



    public static void main(String[] args) {
        List<String> s = new ArrayList<>(Arrays.asList("abcdefg","abccefg","abcckkg"));
        WordAbbreviation test = new WordAbbreviation();
        test.wordsAbbreviation(s);

    }
}
