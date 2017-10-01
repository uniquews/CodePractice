/**
 * Created by shuaiwang on 1/25/17.
 */

/**
 * For each bit position 1-32 in a 32-bit integer,
 * we count the number of integers in the array which
 * have that bit set. Then, if there are n integers in
 * the array and k of them have a particular bit set and
 * (n-k) do not, then that bit contributes k*(n-k) hamming distance to the total.
 * */
public class TotalHammingDistance {
    public int totalHammingDistance(int[] nums) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int numOfOneBit = 0;
            for (int j = 0; j < nums.length; j++) {
                numOfOneBit += (nums[j] >> i) & 1;
            }
            result += numOfOneBit * (nums.length - numOfOneBit);
        }
        return result;
    }
}
