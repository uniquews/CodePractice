import java.util.*;

/**
 * Created by shuaiwang on 4/12/17.
 */
public class SequenceReconstruction {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        HashMap<Integer, Integer> indegree = new HashMap<>();
        for (int i = 0; i < seqs.size(); i++) {
            for (int j = 0; j < seqs.get(i).size(); j++) {
                int current = seqs.get(i).get(j);
                if (j == seqs.get(i).size() - 1) {
                    if (!graph.containsKey(current)) {
                        graph.put(current, new HashSet<>());
                    }
                } else {
                    if (graph.containsKey(current)) {
                        graph.get(current).add(seqs.get(i).get(j + 1));
                    } else {
                        graph.put(current, new HashSet<>(Arrays.asList(seqs.get(i).get(j + 1))));
                    }
                }
            }
        }

        for (Integer parent : graph.keySet()) {
            for (Integer neighbor : graph.get(parent)) {
                if (indegree.containsKey(neighbor)) {
                    indegree.put(neighbor, indegree.get(neighbor) + 1);
                } else {
                    indegree.put(neighbor, 1);
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (Integer key : graph.keySet()) {
            if (!indegree.containsKey(key)) {
                queue.add(key);
            }
        }

        List<Integer> tpSort = new ArrayList<>();
        while (queue.size() == 1) {
            int current = queue.poll();
            tpSort.add(current);
            for (Integer neighbor : graph.get(current)) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if (indegree.get(neighbor) == 0) {
                    queue.add(neighbor);
                }
            }
        }

        ArrayList<Integer> c = new ArrayList<>();
        for (int i = 0; i < org.length; i++) {
            c.add(org[i]);
        }

        return tpSort.equals(c) && tpSort.size() == graph.keySet().size();
    }

}
