import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
//    public List<String> restoreIpAddresses(String s) {
//        List<String> result = new ArrayList<>();
//        StringBuilder sb = new StringBuilder();
//        dfs(s, 0, sb, result);
//        return result;
//    }
//
//    private void dfs(String s, int num, StringBuilder sb, List<String> result) {
//        if (s.equals("") && num == 4) {
//            sb.deleteCharAt(sb.length() - 1);
//            result.add(sb.toString());
//            return;
//        }
//
//        if (s.equals("") || num == 4) {
//            return;
//        }
//
//        int len = sb.length();
//        if (s.charAt(0) == '0') {
//            String cur = s.substring(0, 1);
//            sb.append(cur).append(".");
//            dfs(s.substring(1), num + 1, sb, result);
//            sb.setLength(len);
//            return;
//        }
//
//        for (int i = 1; i <= s.length() && i <= 4; i++) {
//            String cur = s.substring(0, i);
//            int tmp = Integer.valueOf(cur);
//            if (!(tmp >= 1 && tmp <= 255)) {
//                continue;
//            }
//            sb.append(cur).append(".");
//            dfs(s.substring(i), num + 1, sb, result);
//            sb.setLength(len);
//        }
//        return;
//    }

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        char[] sb = new char[s.length() + 3];
        dfs(s, 0, sb, 0, result);
        return result;
    }

    private void dfs(String s, int num, char[] sb, int index, List<String> result) {
        if (s.equals("") && num == 4) {
            result.add(new String(sb));
            return;
        }

        if (s.equals("") || num == 4) {
            return;
        }

        if (s.charAt(0) == '0') {
            sb[index] = '0';
            int next = index;
            if (num != 3) {
                next = index + 1;
                sb[next] = '.';
            }
            dfs(s.substring(1), num + 1, sb, next + 1, result);
            return;
        }

        for (int i = 1; i <= s.length() && i <= 4; i++) {
            String cur = s.substring(0, i);
            int tmp = Integer.valueOf(cur);
            if (!(tmp >= 1 && tmp <= 255)) {
                continue;
            }

            int j = 0;
            while (j < cur.length()) {
                sb[index + j] = cur.charAt(j);
                j++;
            }
            int next = index + j;
            if (num != 3) {
                sb[next] = '.';
            } else {
                next--;
            }
            dfs(s.substring(i), num + 1, sb, next + 1, result);
        }

    }
}
