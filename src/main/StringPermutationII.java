package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by shuaiwang on 11/15/16.
 */
public class StringPermutationII {
    public List<String> stringPermutation2(String str) {
        // Write your code here
        List<String> result = new ArrayList<>();
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        String sortStr = new String(chars);

        boolean[] visited = new boolean[str.length()];
        StringBuilder sb = new StringBuilder();

        dfs(sortStr, visited, 0, result, sb);
        return result;
    }

    private void dfs(String sortStr, boolean[] visited, int index, List<String> result, StringBuilder sb) {
        if (index == sortStr.length()) {
            result.add(sb.toString());
            return;
        }

        for (int i = 0; i < sortStr.length(); i++) {
            if (visited[i] == false) {
                visited[i] = true;
                sb.append(sortStr.charAt(i));
                dfs(sortStr, visited, index + 1, result, sb);
                visited[i] = false;
                sb.deleteCharAt(sb.length() - 1);

                while (i + 1 < sortStr.length() && sortStr.charAt(i + 1) == sortStr.charAt(i)) {
                    i++;
                }
            }
        }
        return;
    }

    public static void main(String[] args) {
        String str = "abb";
        StringPermutationII test = new StringPermutationII();
        test.stringPermutation2(str);
    }
}
