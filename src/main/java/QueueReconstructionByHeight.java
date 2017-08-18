import java.util.*;

/**
 * Created by shuaiwang on 1/15/17.
 */
public class QueueReconstructionByHeight {
//    public int[][] reconstructQueue(int[][] people) {
//        Arrays.sort(people,
//                (int[] a, int[] b) ->  a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
//
//        List<int[]> list = new LinkedList<>();
//
//        for (int i = 0; i < people.length; i++) {
//            list.add(people[i][1], people[i]);
//        }
//
//        return list.toArray(new int[people.length][]);
//    }
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0 || people[0] == null || people[0].length == 0)
            return new int[0][];
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) {
                    return b[0] - a[0];
                } else {
                    return a[1] - b[1];
                }
            }
        });

        int maxHeight = people[0][0];
        List<int[]> l = new ArrayList<>();
        l.add(people[0]);
        for (int i = 1; i < people.length; i++) {
            if (people[i][0] == maxHeight) {
                l.add(people[i]);
            } else {
                l.add(people[i][1], people[i]);
            }
        }
        return l.toArray(new int[l.size()][]);
    }
}
