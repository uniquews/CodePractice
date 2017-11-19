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

//    public List<String> restoreIpAddresses(String s) {
//        List<String> result = new ArrayList<>();
//        char[] sb = new char[s.length() + 3];
//        dfs(s, 0, sb, 0, result);
//        return result;
//    }
//
//    private void dfs(String s, int num, char[] sb, int index, List<String> result) {
//        if (s.equals("") && num == 4) {
//            result.add(new String(sb));
//            return;
//        }
//
//        if (s.equals("") || num == 4) {
//            return;
//        }
//
//        if (s.charAt(0) == '0') {
//            sb[index] = '0';
//            int next = index;
//            if (num != 3) {
//                next = index + 1;
//                sb[next] = '.';
//            }
//            dfs(s.substring(1), num + 1, sb, next + 1, result);
//            return;
//        }
//
//        for (int i = 1; i <= s.length() && i <= 4; i++) {
//            String cur = s.substring(0, i);
//            int tmp = Integer.valueOf(cur);
//            if (!(tmp >= 1 && tmp <= 255)) {
//                continue;
//            }
//
//            int j = 0;
//            while (j < cur.length()) {
//                sb[index + j] = cur.charAt(j);
//                j++;
//            }
//            int next = index + j;
//            if (num != 3) {
//                sb[next] = '.';
//            } else {
//                next--;
//            }
//            dfs(s.substring(i), num + 1, sb, next + 1, result);
//        }
//
//    }

    public List<String> restoreIpAddresses(String s) {

        List<String> result = new ArrayList<>();
        int len = s.length();
        int start = 0;
        for (int i = 0; i < len - 3 && i < start + 3; i++) {
            int tmp1 = i + 1;
            String ad1 = s.substring(start, i + 1);
            if (!isValid(ad1)) {
                break;
            }
            for (int j = tmp1; j < len - 2 && j < tmp1 + 3; j++) {
                int tmp2 = j + 1;
                String ad2 = s.substring(tmp1, j + 1);
                if (!isValid(ad2)) {
                    break;
                }
                for (int k = tmp2; k < len - 1 && k < tmp2 + 3; k++) {
                    String ad3 = s.substring(tmp2, k + 1);
                    String ad4 = s.substring(k + 1);

                    if (isValid(ad3) && isValid(ad4)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(ad1).append(".").append(ad2).append(".").append(ad3).append(".").append(ad4);
                        result.add(sb.toString());
                    }
                }
            }
        }
        return result;
    }

    private boolean isValid(String s) {
        if (s.charAt(0) == '0') {
            return s.length() == 1;
        }
        int n;
        try {
            n = Integer.valueOf(s);
        } catch (Exception e) {
            return false;
        }

        return n >= 1 && n <= 255;
    }

    public static void main(String[] args) {
        String s = "9245587303";
        RestoreIPAddresses test = new RestoreIPAddresses();
        test.restoreIpAddresses(s);
    }
}
