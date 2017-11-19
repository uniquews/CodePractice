package fb;

import java.util.*;

public class RandomMines {
    public List<int[]> randomMines(int h, int w, int m) {
        List<Integer> result = new ArrayList<>();
        Random rand = new Random();

        Map<Integer, Integer> changed = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int index = rand.nextInt(h * w - i);
            result.add(changed.containsKey(index) ? changed.get(index) : index);
            changed.put(index, h * w - 1 - i);
        }

        List<int[]> points = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            int r = result.get(i) / w;
            int c = result.get(i) % w;
            points.add(new int[]{r, c});
        }
        return points;
    }
}
