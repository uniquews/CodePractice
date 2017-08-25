import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuaiwang on 8/24/17.
 */
public class LetterCombinationsOfPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        if (digits == null || digits.length() == 0)
            return result;
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        StringBuilder sb = new StringBuilder();
        dfs(result, 0, digits, sb, mapping);
        return result;
    }

    private void dfs(List<String> result, int index, String digits, StringBuilder s, String[] mapping) {
        if (index == digits.length()) {
            result.add(s.toString());
            return;
        }

        String letters = mapping[Character.getNumericValue(digits.charAt(index))];
        for (int i = 0; i < letters.length(); i++) {
            char c = letters.charAt(i);
            s.append(c);
            dfs(result, index + 1, digits, s, mapping);
            s.deleteCharAt(s.length() - 1);
        }
    }
}
