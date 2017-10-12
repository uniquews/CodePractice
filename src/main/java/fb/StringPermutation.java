package fb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringPermutation {
    public List<String> permutation(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }

        char[] a = s.toCharArray();
        Arrays.sort(a);

        char[] str = new char[s.length()];
        boolean[] visited = new boolean[s.length()];
        dfs(str, 0, a, visited, result);
        return result;
    }

    private void dfs(char[] str, int index, char[] s, boolean[] visited, List<String> result) {
        if (index == s.length) {
            result.add(new String(str));
            return;
        }

        for (int i = 0; i < s.length; i++) {
            if (!visited[i]) {
                str[index] = s[i];
                visited[i] = true;
                dfs(str, index + 1, s, visited, result);
                visited[i] = false;

                while (i + 1 < s.length && s[i] == s[i + 1]) {
                    i++;
                }
            }

        }
    }

    public static void main(String[] args) {
        StringPermutation test = new StringPermutation();
        String s = "aab";
        List<String> result = test.permutation(s);
        for (String ss : result) {
            System.out.println(ss);
        }
    }
}
