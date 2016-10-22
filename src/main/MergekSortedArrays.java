package main;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by shuaiwang on 10/21/16.
 */
public class MergekSortedArrays {
    public List<Integer> mergekSortedArrays(int[][] arrays) {
        // Write your code here
        return mergeHelper(arrays, 0, arrays.length - 1);
    }

    private List<Integer> mergeHelper(int[][] arrays, int start, int end) {
        if (start == end) {
//            return Arrays.stream(arrays[start]).boxed().collect(Collectors.toList());
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < arrays[start].length; i++) {
                result.add(arrays[start][i]);
            }
            return result;
        }

        int mid = start + (end - start) / 2;
        List leftList = mergeHelper(arrays, start, mid);
        List rightList = mergeHelper(arrays, mid + 1, end);
        return mergeTwoSortedList(leftList, rightList);
    }

    private List<Integer> mergeTwoSortedList(List<Integer> leftList, List<Integer> rightList) {
        int p = 0, q = 0;
        List<Integer> result = new ArrayList<>();
        while (p < leftList.size() && q < rightList.size()) {
            if (leftList.get(p) < rightList.get(q)) {
                result.add(leftList.get(p++));
            } else {
                result.add(rightList.get(q++));
            }
        }

        while (p < leftList.size() ) {
            result.add(leftList.get(p++));
        }

        while (q < rightList.size()) {
            result.add(rightList.get(q++));
        }
        return result;
    }
}
