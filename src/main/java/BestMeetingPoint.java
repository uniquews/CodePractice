/**
 * Created by shuaiwang on 3/1/17.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The difference between Build Post Office I is that,
 *
 * The best meeting point doesn't have to be empty, it can be 1
 *
 * So we dont need to find medain, we just need to get the sum of
 * the distance between the [0, i], [1, i - 1] then [2, i -2]
 *
 * Why median could give the shortest distance
 *
 *
 * */
public class BestMeetingPoint {

    public int minTotalDistance(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    x.add(i);
                    y.add(j);
                }
            }
        }
        return getSum(x) + getSum(y);
    }

    private int getSum(List<Integer> list) {
        Collections.sort(list);

        int left = 0, right = list.size() - 1, result = 0;

        while (left < right) {
            result += list.get(right--) - list.get(left++);
        }
        return result;
    }
}
