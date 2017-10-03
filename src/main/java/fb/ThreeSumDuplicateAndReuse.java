package fb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumDuplicateAndReuse {
    /**
     *
     * 只要一个数允许用n多次，就没办法用two pointer  O(n^3)
     * 允许重复的结果出现 3个{-1(a),-1(b),2} {-1(a),-1(a),2} {-1(b),-1(b),2}
     * */
//    public List<List<Integer>> threeSum(int[] a, int target) {
//        List<List<Integer>> result = new ArrayList<>();
//        for (int i = 0; i < a.length; i++) {
//            for (int j = i; j < a.length; j++) {
//                for (int k = j; k < a.length; k++) {
//                    if (a[i] + a[j] + a[k] == target) {
//                        result.add(Arrays.asList(a[i], a[j], a[k]));
//                    }
//                }
//            }
//        }
//        return result;
//    }

    /***
     * 不允许有重复的结果 {-1(a), -1(a), 2}
     *
     * */
    public List<List<Integer>> threeSum(int[] a, int target) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                for (int k = j; k < a.length; k++) {
                    if (a[i] + a[j] + a[k] == target) {
                        result.add(Arrays.asList(a[i], a[j], a[k]));
                    }
                    while (k + 1 < a.length && a[k] == a[k + 1]) {
                        k++;
                    }
                }
                while (j + 1 < a.length && a[j] == a[j + 1]) {
                    j++;
                }
            }
            while (i + 1 < a.length && a[i] == a[i + 1]) {
                i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSumDuplicateAndReuse test = new ThreeSumDuplicateAndReuse();
        int[] a = {-1, -1, 2};
        int target = 0;
        List<List<Integer>> result = test.threeSum(a, target);
        for (List<Integer> list : result) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.print(", ");
        }
    }
}
