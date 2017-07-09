import java.util.*;

/**
 * Created by shuaiwang on 4/12/17.
 */
public class SequenceReconstruction {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();

        for (List<Integer> list : seqs) {
            for (int n : list) {
                map.put(n, new HashSet<>());
                indegree.put(n, 0);
            }
        }

        for (List<Integer> list : seqs) {
            if (list == null)
                continue;
            if (list.size() >= 1 && (list.get(0) <= 0 || list.get(0) > org.length))
                return false;
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i) <= 0 || list.get(i) > org.length)
                    return false;
                if (map.get(list.get(i - 1)).add(list.get(i)))
                    indegree.put(list.get(i), indegree.get(list.get(i)) + 1);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (Integer n : indegree.keySet()) {
            if (indegree.get(n) == 0)
                q.add(n);
        }

        int cnt = 0;
        while (q.size() == 1) {
            int current = q.poll();
            for (int next : map.get(current)) {
                indegree.put(next, indegree.get(next) - 1);
                if (indegree.get(next) == 0)
                    q.add(next);
            }
            cnt++;
        }
        return cnt == org.length;
    }

}
