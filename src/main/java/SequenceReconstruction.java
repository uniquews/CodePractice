import java.util.*;

/**
 * Created by shuaiwang on 4/12/17.
 */
public class SequenceReconstruction {
//    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
//        Map<Integer, Set<Integer>> map = new HashMap<>();
//        Map<Integer, Integer> indegree = new HashMap<>();
//
//        for (List<Integer> list : seqs) {
//            for (int n : list) {
//                map.put(n, new HashSet<>());
//                indegree.put(n, 0);
//            }
//        }
//
//        for (List<Integer> list : seqs) {
//            if (list == null)
//                continue;
//            if (list.size() >= 1 && (list.get(0) <= 0 || list.get(0) > org.length))
//                return false;
//            for (int i = 1; i < list.size(); i++) {
//                if (list.get(i) <= 0 || list.get(i) > org.length)
//                    return false;
//                if (map.get(list.get(i - 1)).add(list.get(i)))
//                    indegree.put(list.get(i), indegree.get(list.get(i)) + 1);
//            }
//        }
//
//        Queue<Integer> q = new LinkedList<>();
//        for (Integer n : indegree.keySet()) {
//            if (indegree.get(n) == 0)
//                q.add(n);
//        }
//
//        int cnt = 0;
//        while (q.size() == 1) {
//            int current = q.poll();
//            for (int next : map.get(current)) {
//                indegree.put(next, indegree.get(next) - 1);
//                if (indegree.get(next) == 0)
//                    q.add(next);
//            }
//            cnt++;
//        }
//        return cnt == org.length;
//    }

    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> degree = new HashMap<>();

        for (List<Integer> list : seqs) {
            for (int i = 0; i < list.size(); i++) {
                graph.put(list.get(i), new HashSet<>());
                degree.put(list.get(i), 0);
            }
        }

        for (List<Integer> list : seqs) {
            for (int i = 0; i < list.size() - 1; i++) {
                int source = list.get(i);
                int target = list.get(i + 1);

                if (!graph.get(source).contains(target)) { // 否则【5，2】出现两次就会在2的 degree上加两遍
                    graph.get(source).add(target);
                    degree.put(target, degree.get(target) + 1);
                }
            }
        }

        if (graph.keySet().size() != org.length)
            return false;

        int[] tp = new int[org.length];
        Queue<Integer> q = new LinkedList<>();
        for (Integer k : degree.keySet()) {
            if (degree.get(k) == 0) {
                q.add(k);
            }
        }

        int index = 0;
        while (q.size() == 1) {
            int current = q.poll();
            tp[index++] = current;
            for (Integer target : graph.get(current)) {
                degree.put(target, degree.get(target) - 1);
                if (degree.get(target) == 0)
                    q.add(target);
            }
        }

        if (index != org.length)
            return false;

        for (int i = 0; i < index; i++) {
            if (org[i] != tp[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>(Arrays.asList(5,2,6,3));
        List<Integer> b = new ArrayList<>(Arrays.asList(4,1,5,2));
//        List<Integer> c = new ArrayList<>(Arrays.asList(2,3));

        List<List<Integer>> input = new ArrayList<>();
        input.add(a);
        input.add(b);
//        input.add(c);
        int[] org = {4,1,5,2,6,3};
        SequenceReconstruction test = new SequenceReconstruction();
        test.sequenceReconstruction(org, input);


    }

}
