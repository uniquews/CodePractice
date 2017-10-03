package fb;

import java.util.*;

public class DetectBipartite {

    public boolean detectBipartite(Map<Integer, Set<Integer>> map) {
        Set<Integer> color1 = new HashSet<>();
        Set<Integer> color2 = new HashSet<>();

        int start = map.keySet().iterator().next();
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color1.add(start);

        while (!q.isEmpty()) {
            int cur = q.poll();
            Set<Integer> neighbors = map.get(cur);
            if (color1.contains(cur)) {
                if (!helper(neighbors, color2, color1, q)) {
                    return false;
                }
            } else {
                if (!helper(neighbors, color1, color2, q)) {
                    return false;
                }
            }

        }
        return true;
    }

    private boolean helper(Set<Integer> neighbor, Set<Integer> correct,
                           Set<Integer> wrong, Queue<Integer> q) {
        for (Integer n : neighbor) {
            if (correct.contains(n)) {
                return true;
            }

            if (wrong.contains(n)) {
                return false;
            }
            correct.add(n);
            q.add(n);
        }
        return true;
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        Set<Integer> set3 = new HashSet<>();
        Set<Integer> set4 = new HashSet<>();

        set1.add(1);
        set1.add(3);
        set2.add(0);
        set2.add(2);
        set3.add(1);
        set3.add(3);
        set4.add(0);
        set4.add(2);
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        map.put(0, set1);
        map.put(1, set2);
        map.put(2, set1);
        map.put(3, set2);

        DetectBipartite test = new DetectBipartite();
        System.out.println(test.detectBipartite(map));
    }
}
