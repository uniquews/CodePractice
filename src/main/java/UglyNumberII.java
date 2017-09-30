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
        // write your code here
        List<Integer> list = new ArrayList<>();
        list.add(1);

        int i = 0;
        int j = 0;
        int k = 0;

        int count = 1;
        int result = 1;
        while (count < n) {
            int tmp1 = list.get(i) * 2;
            int tmp2 = list.get(j) * 3;
            int tmp3 = list.get(k) * 5;

            result = Math.min(tmp1, Math.min(tmp2, tmp3));
            if (tmp1 == result) {
                i++;
            }
            if (tmp2 == result) {
                j++;
            }
            if (tmp3 == result) {
                k++;
            }
            list.add(result);
            count++;
        }
        return result;
    }

    public static void main(String[] args) {
        UglyNumberII test = new UglyNumberII();
        test.nthUglyNumber(3);
    }
}
