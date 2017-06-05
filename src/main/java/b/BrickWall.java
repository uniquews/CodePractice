package b;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by bohan on 5/19/17.
 */
public class BrickWall {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> wallMap = new HashMap<>();
        int max = 0;
        for (List<Integer> row : wall) {
            int sum = 0;
            for (int i = 0; i < row.size() - 1; i++) {
                sum += row.get(i);
                int numOfEdges = wallMap.getOrDefault(sum, 0) + 1;
                wallMap.put(sum, numOfEdges);
                max = Math.max(max, numOfEdges);
            }
        }
        return wall.size() - max;
    }
}
