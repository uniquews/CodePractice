import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by shuaiwang on 11/21/16.
 */
public class KthLargestinNArrays {
    class NumElement {
        public int val;
        public int row;
        public int index;

        public NumElement(int v, int r, int i) {
            val = v;
            row = r;
            index = i;
        }

    }

    public int KthInArrays(int[][] arrays, int k) {
        // Write your code here

        Queue<NumElement> heap = new PriorityQueue<>(k, new Comparator<NumElement>() {
            @Override
            public int compare(NumElement o1, NumElement o2) {
                if (o1.val > o2.val)
                    return -1;
                else if (o1.val > o2.val)
                    return 1;
                else
                    return 0;
            }

        });

        for (int i = 0; i < arrays.length; i++) {
            Arrays.sort(arrays[i]);
            if (arrays[i].length > 0) {
                int val = arrays[i][arrays[i].length - 1];
                int row = i;
                int column = arrays[i].length - 1;
                NumElement obj = new NumElement(val, row, column);
                heap.add(obj);
            }
        }

        for (int i = 0; i < k; i++) {
            NumElement cur = heap.poll();
            int row = cur.row;
            int index = cur.index;
            int val = cur.val;

            if (i == k - 1) {
                return val;
            }

            if (index > 0) {
                index--;
                NumElement nextElement = new NumElement(arrays[row][index], row, index);
                heap.add(nextElement);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] arrays = {{9, 3, 2, 4, 7}, {1, 2, 3, 4, 8}};
        KthLargestinNArrays test = new KthLargestinNArrays();
        System.out.print(test.KthInArrays(arrays, 3));
    }
}
