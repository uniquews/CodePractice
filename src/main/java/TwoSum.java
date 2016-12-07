import java.util.HashMap;

/**
 * Created by shuaiwang on 10/4/16.
 */
public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        // write your code here
        int[] result = new int[2];
        if (numbers == null || numbers.length == 0) {
            return result;
        }

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int tmp = target - numbers[i];
            if (hashMap.containsKey(tmp)) {
                result[0] = hashMap.get(tmp) + 1;
                result[1] = i + 1;
            } else {
                hashMap.put(numbers[i], i);
            }
        }
        return result;
    }
}
