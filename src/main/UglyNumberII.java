package main;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuaiwang on 10/23/16.
 *
 * i, j, k are three pointers. Every time you picke the smallest one as current ugly number
 */
public class UglyNumberII {
    public int nthUglyNumber(int n) {
        // Write your code here
        int i = 0, j = 0, k = 0;
        List<Integer> result = new ArrayList<>();

        result.add(1);
        while (result.size() < n) {
            int m2 = result.get(i) * 2;
            int m3 = result.get(j) * 3;
            int m5 = result.get(k) * 5;

            int cur = Math.min(m2, Math.min(m2, m5));
            result.add(cur);

            if (cur == m2) {
                i++;
            }

            if (cur == m3) {
                j++;
            }

            if (cur == m5) {
                k++;
            }
        }

        return result.get(result.size() - 1);
    }

    public static void main(String[] args) {
        UglyNumberII test = new UglyNumberII();
        test.nthUglyNumber(3);
    }
}
