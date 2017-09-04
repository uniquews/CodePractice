import java.util.*;

/**
 * Created by shuaiwang on 7/23/17.
 */
public class AddBoldTagInString {
//    public String addBoldTag(String s, String[] dict) {
//        Queue<int[]> q = new PriorityQueue<>((a, b) -> {
//            if (a[0] < b[0]) {
//                return -1;
//            } else if (a[0] > b[0]) {
//                return 1;
//            } else {
//                return a[1] - b[1];
//            }
//        });
//
//        for (String d : dict) {
//            getInterval(s, d, q);
//        }
//
//        List<int[]> list = new ArrayList<>();
//        while (!q.isEmpty()) {
//            int[] interval = q.poll();
//            while (!q.isEmpty() && (q.peek()[0] <= interval[1] || q.peek()[0] == interval[1] + 1)) {
//                int[] next = q.poll();
//                interval[1] = Math.max(interval[1], next[1]);
//            }
//            list.add(interval);
//        }
//
//        int start = 0;
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i)[0] <= start) {
//                sb.append("<b>");
//                sb.append(s.substring(list.get(i)[0], list.get(i)[1] + 1));
//                sb.append("</b>");
//                start = list.get(i)[1] + 1;
//            } else {
//                sb.append(s.substring(start, list.get(i)[0]));
//                start = list.get(i)[0];
//                i--;
//            }
//        }
//        if (start < s.length()) {
//            sb.append(s.substring(start));
//        }
//        return sb.toString();
//    }
//
//    private void getInterval(String s, String d, Queue<int[]> q) {
//        if (s.indexOf(d) == -1)
//            return;
//
//        int offset = 0;
//        while (offset < s.length()) {
//            int start = s.indexOf(d, offset);
//            if (start == -1)
//                break;
//            int end = start + d.length() - 1;
//            int[] interval = new int[2];
//            interval[0] = start;
//            interval[1] = end;
//            q.add(interval);
//
//            offset++;
//        }
//    }

    class Interval {
        public int start;
        public int end;
        public Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public String addBoldTag(String s, String[] dict) {
        List<Interval> l = new ArrayList<>();
        for (int i = 0; i < dict.length; i++) {
            List<Interval> current = getInterval(s, dict[i]);
            if (current.size() == 0) {
                continue;
            }
            l.addAll(current);
        }
        Collections.sort(l, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        List<Interval> afterMerge = mergeInterval(l);
        StringBuilder sb = new StringBuilder(s);
        for (int i = afterMerge.size() - 1; i >= 0; i--) { //倒着放不会影响前面的Index
            int start = afterMerge.get(i).start;
            int end = afterMerge.get(i).end;

            sb.insert(end, "</b>");
            sb.insert(start, "<b>");
        }
        return sb.toString();
    }

    private List<Interval> mergeInterval(List<Interval> l) {
        List<Interval> result = new ArrayList<>();
        if (l == null || l.size() == 0)
            return result;

        result.add(l.get(0));
        int i = 1;
        while (i < l.size()) {
            if (l.get(i).start > result.get(result.size() - 1).end) {
                result.add(l.get(i++));
            } else {
                result.get(result.size() - 1).end = Math.max(result.get(result.size() - 1).end,
                        l.get(i++).end);
            }

        }
        return result;

    }

    private List<Interval> getInterval(String s, String t) {
        List<Interval> result = new ArrayList<>();
        int index = 0;
        while (index < s.length()) {
            int pos = s.indexOf(t, index);
            if (pos != -1) {
                Interval in = new Interval(pos, pos + t.length()); // exclusive end
                result.add(in);
            }
            index++;
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "abcxyz123";
        String[] dict = {"abc","123"};

//        String s = "aaabbcc";
//        String[] dict = {"aaa","aab","bc"};

//        String s = "ttt";
//        String[] dict = {"tt"};
        AddBoldTagInString test = new AddBoldTagInString();
        System.out.print(test.addBoldTag(s, dict));
    }

}
