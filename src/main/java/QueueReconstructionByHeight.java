import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by shuaiwang on 1/15/17.
 */
public class QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,
                (int[] a, int[] b) ->  a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);

        List<int[]> list = new LinkedList<>();

        for (int i = 0; i < people.length; i++) {
            list.add(people[i][1], people[i]);
        }

        return list.toArray(new int[people.length][]);
    }
}
