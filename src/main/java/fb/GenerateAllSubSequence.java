package fb;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenerateAllSubSequence {
    public List<String> generate(String s) {
        List<String> result = new ArrayList<>();
        Set<String> tmp = new HashSet<>();

        dfs(s, 0, new StringBuilder(), tmp);
        result.addAll(tmp);
        return result;
    }

    private void dfs(String s, int index, StringBuilder sb, Set<String> result) {

        int len = sb.length();
        for (int i = index; i < s.length(); i++) {
            sb.append(s.charAt(i));
            result.add(sb.toString());
            dfs(s, i + 1, sb, result);
            sb.setLength(len);
        }
    }

    public static void main(String[] args) {
        String s = "abbc";
        GenerateAllSubSequence test = new GenerateAllSubSequence();
        List<String> r = test.generate(s);
        for (String rr : r) {
            System.out.println(rr);
        }
    }
}
