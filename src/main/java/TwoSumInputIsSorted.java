/**
 * Created by shuaiwang on 1/22/17.
 */
public class TwoSumInputIsSorted {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int start = 0, end = numbers.length - 1;
        while (start < end) {
            int current = numbers[start] + numbers[end];
            if (current == target) {
                result[0] = start + 1;
                result[1] = end + 1;
                return result;
            } else if (current < target) {
                start++;
            } else {
                end--;
            }
        }
        return  result;
    }
}
