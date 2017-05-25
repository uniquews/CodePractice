import java.util.*;

/**
 * Created by shuaiwang on 5/19/17.
 */
public class BrickWall {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> edges = new HashMap<>();
        for (List<Integer> row : wall) {
            int index = 0;
            for (int i = 0; i < row.size() - 1; i++) {
                index += row.get(i);
                edges.put(index, edges.getOrDefault(index, 0) + 1);
            }
        }

        int maxEdge = 0;
        for (Integer edge : edges.keySet()) {
            maxEdge = Math.max(maxEdge, edges.get(edge));
        }
        return wall.size() - maxEdge;
    }

}
