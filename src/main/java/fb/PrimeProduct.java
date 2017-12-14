package fb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeProduct {
    public List<Integer> getProduct(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        Arrays.sort(nums);

        int init = 1;
        dfs(nums, 0, init, result);
        return result;
    }

    private void dfs(int[] nums, int index, int cur, List<Integer> result) {
        if (index == nums.length) {
            return;
        }

        for (int i = index; i < nums.length; i++) {
            int tmp = cur * nums[i];
            if (cur != 1) {
                result.add(tmp);
            }
            dfs(nums, i + 1, tmp, result);
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        PrimeProduct test = new PrimeProduct();
        int[] nums = {2,2,7};
        List<Integer> result = test.getProduct(nums);
        for (int i : result) {
            System.out.println(i);
        }

    }
}
