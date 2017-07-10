package b;

import java.util.*;

/**
 * Created by bohan on 7/6/17.
 */
public class SequenceReconstruction {
    /**
     * @param org  a permutation of the integers from 1 to n
     * @param seqs a list of sequences
     * @return true if it can be reconstructed only one or false
     */
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();

        for (int[] seq : seqs) {
            for (int i = 0; i < seq.length - 1; i++) {
                Set<Integer> next = graph.getOrDefault(seq[i], new HashSet<>());
                next.add(seq[i + 1]);
                graph.putIfAbsent(seq[i], next);
                int nextInDegree = inDegree.getOrDefault(seq[i + 1], 0) + 1;
                inDegree.put(seq[i + 1], nextInDegree);
            }
            graph.putIfAbsent(seq[seq.length - 1], new HashSet<>());
        }

        Queue<Integer> queue = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.offer(entry.getKey());
            }
        }
        List<Integer> superSequence = new ArrayList<>(org.length);
        while (!queue.isEmpty()) {
            int num = queue.poll();
            superSequence.add(num);
            Set<Integer> next = graph.get(num);
            for (Integer n : next) {
                int newInDegree = inDegree.get(n) - 1;
                if (newInDegree == 0) {
                    queue.offer(n);
                } else {
                    inDegree.put(n, newInDegree);
                }
            }
            if (queue.size() > 1) {
                return false;
            }
        }
        return Objects.deepEquals(superSequence.toArray(), org);
    }
}
