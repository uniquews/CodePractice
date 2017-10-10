import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by shuaiwang on 5/20/17.
 */
public class ContiguousArray {

    public int findMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] map = new int[2 * nums.length + 1];
        Arrays.fill(map, -1);
        map[nums.length] = 0;
        int count = 0;
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {
            count += nums[i] == 0 ? -1 : 1;
            if (map[count + nums.length] != -1) {
                maxLen = Math.max(maxLen, i + 1 - map[count + nums.length]);
            } else {
                map[count + nums.length] = i + 1;
            }
        }
        return maxLen;
    }

//    public int findMaxLength(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//
//        Map<Integer, Integer> map = new HashMap<>();
//        map.put(0, 0);
//        int count = 0;
//        int maxLen = 0;
//
//        for (int i = 0; i < nums.length; i++) {
//            count += nums[i] == 0 ? -1 : 1;
//            if (map.containsKey(count)) {
//                maxLen = Math.max(maxLen, i - map.get(count) + 1);
//            } else {
//                map.put(count, i + 1);
//            }
//        }
//        return maxLen;
//    }

    public static void main(String[] args) {
        int[] nums = {0,1};
        ContiguousArray test = new ContiguousArray();
        test.findMaxLength(nums);
    }
}
