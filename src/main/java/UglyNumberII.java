import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuaiwang on 10/23/16.
 * <p>
 * i, j, k are three pointers. Every time you pick the smallest one as current ugly number
 *
 * 关键思路是这句话：
     The key is how to maintain the order of the ugly numbers.
     Try a similar approach of merging from three sorted lists: L1, L2, and L3.
     (1) 1×2, 2×2, 3×2, 4×2, 5×2, …
     (2) 1×3, 2×3, 3×3, 4×3, 5×3, …
     (3) 1×5, 2×5, 3×5, 4×5, 5×5, …
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

            int cur = Math.min(m2, Math.min(m3, m5));
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
