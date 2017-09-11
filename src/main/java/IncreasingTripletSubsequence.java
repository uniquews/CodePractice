/**
 * Created by shuaiwang on 5/16/17.
 */
public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE, bigger = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (min >= nums[i]) { //   <= otherwise if will fall into second case
                min = nums[i];
            } else if (nums[i] <= bigger) {
                bigger = nums[i];
            } else {
                return true;
            }
        }
        return false;
    }
}
