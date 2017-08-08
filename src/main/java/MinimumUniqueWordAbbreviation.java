import java.util.*;

/**
 * Created by shuaiwang on 3/16/17.
 */
public class MinimumUniqueWordAbbreviation {

    /**
     * 这道题是unique word abbr 和 generalized abbr 结合，自己需要写一个getLength 方法
     *
     * */
    public String minAbbreviation(String target, String[] dictionary) {
        if (dictionary.length == 0) return String.valueOf(target.length());
        List<String> result = generateAbbreviations(target);

        int minLen = target.length();
        String minAbbr = target;
        for (String s : result) {
            boolean found = false;
            for (String d : dictionary) {
                found = validWordAbbreviation(d, s);
                if (found) {
                    break;
                }
            }
            if (!found && getLength(s) < minLen) {
                minAbbr = s;
                minLen = getLength(s);
            }
        }
        return minAbbr;
    }

    private int getLength(String abbr) {
        int length = 0;
        int count = 0;
        for (int i = 0; i < abbr.length(); i++) {
            if (Character.isDigit(abbr.charAt(i))) {
                count++;
            } else {
                if (count != 0) {
                    count = 0;
                    length++;
                }
                length++;
            }
        }
        return length;
    }

    private List<String> generateAbbreviations(String word) {
        List<String> result = new ArrayList<>();
        result.add(word);
        helper(result, word, 0);
        List<String> strs = new ArrayList<>();
        for (String aResult : result) {
            strs.add(convert(aResult));
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

    private boolean validWordAbbreviation(String word, String abbr) {
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
        String target = "aaaa";
        String[] dic = {"adaa"};
        MinimumUniqueWordAbbreviation test = new MinimumUniqueWordAbbreviation();
        System.out.println(test.minAbbreviation(target, dic));
    }
}
