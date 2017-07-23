import java.util.*;

/**
 * Created by shuaiwang on 7/23/17.
 */
public class AddBoldTagInString {
    public String addBoldTag(String s, String[] dict) {
        Queue<int[]> q = new PriorityQueue<>((a, b) -> {
            if (a[0] < b[0]) {
                return -1;
            } else if (a[0] > b[0]) {
                return 1;
            } else {
                return a[1] - b[1];
            }
        });

        for (String d : dict) {
            getInterval(s, d, q);
        }

        List<int[]> list = new ArrayList<>();
        while (!q.isEmpty()) {
            int[] interval = q.poll();
            while (!q.isEmpty() && (q.peek()[0] <= interval[1] || q.peek()[0] == interval[1] + 1)) {
                int[] next = q.poll();
                interval[1] = Math.max(interval[1], next[1]);
            }
            list.add(interval);
        }

        int start = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i)[0] <= start) {
                sb.append("<b>");
                sb.append(s.substring(list.get(i)[0], list.get(i)[1] + 1));
                sb.append("</b>");
                start = list.get(i)[1] + 1;
            } else {
                sb.append(s.substring(start, list.get(i)[0]));
                start = list.get(i)[0];
                i--;
            }
        }
        if (start < s.length()) {
            sb.append(s.substring(start));
        }
        return sb.toString();
    }

    private void getInterval(String s, String d, Queue<int[]> q) {
        if (s.indexOf(d) == -1)
            return;

        int offset = 0;
        while (offset < s.length()) {
            int start = s.indexOf(d, offset);
            if (start == -1)
                break;
            int end = start + d.length() - 1;
            int[] interval = new int[2];
            interval[0] = start;
            interval[1] = end;
            q.add(interval);

            offset++;
        }
    }

    public static void main(String[] args) {
//        String s = "abcxyz123";
//        String[] dict = {"abc","123"};

        String s = "aaabbcc";
        String[] dict = {"aaa","aab","bc"};

//        String s = "ttt";
//        String[] dict = {"tt"};
        AddBoldTagInString test = new AddBoldTagInString();
        System.out.print(test.addBoldTag(s, dict));
    }

}
