import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by shuaiwang on 1/19/17.
 */
public class ZigzagIterator {
//    private List<List<Integer>> list = new ArrayList<>();
//    private int maxRow;
//    private int maxColumn;
//    private int currentRow;
//    private int currentColumn;
//
//    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
//        list.add(v1);
//        list.add(v2);
//        maxRow = list.size();
//        maxColumn = Math.max(v1.size(), v2.size());
//        currentColumn = 0;
//        currentRow = 0;
//    }
//
//    public int next() {
//        return list.get(currentRow).get(currentColumn);
//    }
//
//    public boolean hasNext() {
//        if (list.get(currentRow).get(currentColumn) != null) {
//            return true;
//        }
//
//        while (currentColumn < maxColumn) {
//            currentRow++;
//            if (currentRow == maxRow) {
//                currentRow = 0;
//                currentColumn++;
//            }
//            if (list.get(currentRow).get(currentColumn) != null) {
//                return true;
//            } else {
//                continue;
//            }
//        }
//        return false;
//    }

    private int maxRow;
    private int maxColumn;
    private int currentRow;
    private int currentColumn;
    private List<Integer> list1;
    private List<Integer> list2;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        maxRow = 2;
        maxColumn = Math.max(v1.size(), v2.size());
        currentColumn = 0;
        currentRow = -1;
        list1 = v1;
        list2 = v2;
        findNextNumberIndex();
    }

    public int next() {
        int result = 0;
        if (currentRow == 0) {
            result = list1.get(currentColumn);
        } else {
            result = list2.get(currentColumn);
        }
        findNextNumberIndex();
        return result;
    }

    private void findNextNumberIndex() {
        while (currentColumn < maxColumn) {
            currentRow++;
            if (currentRow == maxRow) {
                currentRow = 0;
                currentColumn++;
            }
            if ((currentRow == 0 && currentColumn < list1.size()) || (currentRow == 1 && currentColumn < list2.size())) {
                break;
            }
        }
    }

    public boolean hasNext() {
        return currentColumn < maxColumn;
    }

    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>(Arrays.asList(1,2));
        List<Integer> l2 = new ArrayList<>(Arrays.asList(3,4,5,6));
        List<Integer> result = new ArrayList<>();
        ZigzagIterator test = new ZigzagIterator(l1,l2);
        while (test.hasNext()) {

            result.add(test.next());
        }
    }

}
