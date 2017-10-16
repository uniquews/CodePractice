package fb;

import java.util.*;

/**
 * Created by shuaiwang on 9/10/17.
 */
public class SumOfTwoNumbersWithOneDigitDifference {

//    public List<int[]> sumOfTwoDigits(int sum) {
//        List<int[]> result = new ArrayList<>();
//        int totalDigits = String.valueOf(sum).length();
//        if (totalDigits < 2) {
//            return result;
//        }
//
//        int[] setOne = getRange(totalDigits);
//        int[] setTwo = getRange(totalDigits - 1);
//
//        helper(setOne[0], setOne[1], sum, result);
//        if (totalDigits > 2)
//            helper(setTwo[0], setTwo[1], sum, result);
//        return result;
//    }
//
//    private int[] getRange(int n) {
//        int[] result = new int[2];
//        int num = 1;
//        while (n > 1) {
//            num *= 10;
//            n--;
//        }
//
//        result[0] = num;
//        result[1] = num * 10 - 1;
//        return result;
//    }
//
//    private void helper(int start, int end, int sum, List<int[]> result) {
//        if (start >= sum)
//            return;
//        for (int i = start; i <= end; i++) {
//            List<Integer> l = getNumbers(i);
//            for (int j = 0; j < l.size(); j++) {
//                if (i + l.get(j) == sum) {
//                    result.add(new int[]{i, l.get(j)});
//                }
//            }
//        }
//    }
//
//    private List<Integer> getNumbers(int n) {
//        List<Integer> result = new ArrayList<>();
//        String s = String.valueOf(n);
//        for (int i = 0; i < s.length(); i++) {
//            String next = s.substring(0, i) + s.substring(i + 1);
//            if (String.valueOf(Integer.valueOf(next)).length() != s.length() - 1)
//                continue;
//            result.add(Integer.valueOf(next));
//        }
//        return result;
//    }

    /**
     *
         * 123456
             ^
             e
           ^^^ ^^
           h   t

         e为去掉的digit
         h为前缀
         t为后缀

         s = 2 * t + (11 * h + e) * 10^r
         = 2 * t + e * 10^r + h * 11 * 10^r.

         注意2 * t < 10^r, 0 <= e <= 9
     *
     *
     * 整个代码就是在解 2 * t + e * 10^r + h * 11 * 10^r. 这个方程式
     *
     * base = 10 ^ r 最开始 base = 1
     *
     * s / base = h
     * m = s % base
     *
     * 根据方程式 m 应该等于  2 * t + e * base
     *
     * 枚举e 从0 到 9， 因为e只可能是一位数，使t是valid的，就是正确解
     *
     * */

    public void sumOfTwoDigits(int s) {
        int base = 1;

        while (s / (11 * base) > 0) {
            int h = s / (11 * base);
            int m = s % (11 * base);
            int e = 0;

            while (e * base <= m) {
                if ((m - e * base) % 2 == 0 && (m - e * base) / 2 < base) { // t是低位的几个数，一定小于base
                    int t = (m - e * base) / 2;
                    int n1 = h * 10 * base + e * base + t;
                    int n2 = h * base + t;
                    System.out.println(n1 + " " + n2);
                }
                e++;
            }
            base *= 10;
        }
    }

    public static void main(String[] args) {
        int sum = 1346;
        SumOfTwoNumbersWithOneDigitDifference test = new SumOfTwoNumbersWithOneDigitDifference();
        test.sumOfTwoDigits(sum);
//        for (int i = 0; i < result.size(); i++) {
//            System.out.println(result.get(i)[0] + " " + result.get(i)[1]);
//        }


        // this is true
//        Set<List<Integer>> set = new HashSet<>();
//
//        List<Integer> l1 = new ArrayList<>();
//        l1.add(1);
//        List<Integer> l2 = new ArrayList<>();
//        l2.add(1);
//        set.add(l1);
//        System.out.println(set.contains(l2));

        // this is false
//        Set<int[]> set = new HashSet<>();
//        int[] a = {1,2};
//        int[] b = {1,2};
//        set.add(a);
//        System.out.println(set.contains(b));
    }
}
