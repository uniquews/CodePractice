/**
 * Created by shuaiwang on 7/24/16.
 */
public class WoodCut {
    public int woodCut(int[] L, int k) {
        // write your code here
        int start = 0;
        int end = Integer.MIN_VALUE;

        for (int i = 0; i < L.length; i++) {
            end = Math.max(end, L[i]);
        }

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            int num = getCut(L, mid);
            if (num >= k) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (getCut(L, end) >= k) {
            return end;
        }
        return start;
    }

    private int getCut(int[] L, int len) {
        int num = 0;
        for (int l : L) {
            num += l / len;
        }
        return num;
    }
}
