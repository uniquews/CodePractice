package main;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by shuaiwang on 10/21/16.
 */
public class MergekSortedArrays {
//    public List<Integer> mergekSortedArrays(int[][] arrays) {
//        // Write your code here
//        return mergeHelper(arrays, 0, arrays.length - 1);
//    }
//
//    private List<Integer> mergeHelper(int[][] arrays, int start, int end) {
//        if (start == end) {
////            return Arrays.stream(arrays[start]).boxed().collect(Collectors.toList());
//            List<Integer> result = new ArrayList<>();
//            for (int i = 0; i < arrays[start].length; i++) {
//                result.add(arrays[start][i]);
//            }
//            return result;
//        }
//
//        int mid = start + (end - start) / 2;
//        List leftList = mergeHelper(arrays, start, mid);
//        List rightList = mergeHelper(arrays, mid + 1, end);
//        return mergeTwoSortedList(leftList, rightList);
//    }
//
//    private List<Integer> mergeTwoSortedList(List<Integer> leftList, List<Integer> rightList) {
//        int p = 0, q = 0;
//        List<Integer> result = new ArrayList<>();
//        while (p < leftList.size() && q < rightList.size()) {
//            if (leftList.get(p) < rightList.get(q)) {
//                result.add(leftList.get(p++));
//            } else {
//                result.add(rightList.get(q++));
//            }
//        }
//
//        while (p < leftList.size() ) {
//            result.add(leftList.get(p++));
//        }
//
//        while (q < rightList.size()) {
//            result.add(rightList.get(q++));
//        }
//        return result;
//    }

class Element {
    public int row, col, val;
    Element(int row, int col, int val) {
        this.row = row;
        this.col = col;
        this.val = val;
    }
}

private Comparator<Element> ElementComparator = (left, right) -> left.val - right.val;

    /**
     * @param arrays k sorted integer arrays
     * @return a sorted array
     */
    public int[] mergekSortedArrays(int[][] arrays) {
        if (arrays == null) {
            return new int[0];
        }

        int total_size = 0;
        Queue<Element> Q = new PriorityQueue<Element>(
                arrays.length, ElementComparator);

        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i].length > 0) {
                Element elem = new Element(i, 0, arrays[i][0]);
                Q.add(elem);
                total_size += arrays[i].length;
            }
        }

        int[] result = new int[total_size];
        int index = 0;
        while (!Q.isEmpty()) {
            Element elem = Q.poll();
            result[index++] = elem.val;
            if (elem.col + 1 < arrays[elem.row].length) {
                elem.col += 1;
                elem.val = arrays[elem.row][elem.col];
                Q.add(elem);
            }
        }

        return result;
    }
}
