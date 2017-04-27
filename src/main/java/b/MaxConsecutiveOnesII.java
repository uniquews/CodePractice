package b;

/**
 * Created by bohan on 4/26/17.
 */
public class MaxConsecutiveOnesII {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int aLength = 0;
        int bLength = 0;
        int hasZero = 0;
        for (int num : nums) {
            if (num == 1) {
                bLength++;
            } else {
                aLength = bLength;
                bLength = 0;
                hasZero = 1;
            }
            max = Math.max(max, aLength + bLength);
        }
        return max + hasZero;
    }
}
