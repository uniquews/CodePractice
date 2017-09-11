import java.util.*;

/**
 * Created by shuaiwang on 2/21/17.
 */
public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        // Write your code here
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return result;

        int[] f = new int[nums.length];
        int[] parent = new int[nums.length];

        Arrays.sort(nums);
        Arrays.fill(f, 1);
        Arrays.fill(parent, -1);
        int maxIndex = -1, maxLen = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0)  {
                    if (f[i] < f[j] + 1) {
                        f[i] = f[j] + 1;
                        parent[i] = j;
                    }
                }
            }
            if (maxLen < f[i]) {
                maxLen = f[i];
                maxIndex= i;
            }
        }

        if (maxIndex == -1) {
            result.add(nums[0]);
            return result;
        }


        while (maxIndex != -1) {
            result.add(0, nums[maxIndex]);
            maxIndex = parent[maxIndex];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        LargestDivisibleSubset test = new LargestDivisibleSubset();
        test.largestDivisibleSubset(nums);
    }
}
