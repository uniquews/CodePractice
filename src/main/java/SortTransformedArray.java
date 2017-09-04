import java.util.Arrays;

/**
 * Created by shuaiwang on 2/1/17.
 */
public class SortTransformedArray {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int[] result = new int[nums.length];
        if (nums == null || nums.length == 0) {
            return result;
        }

        if (a == 0) {
            if (b >= 0) {
                for (int i = 0; i < result.length; i++) {
                    result[i] = helper(a, b, c, nums[i]);
                }
            } else {
                int index = result.length - 1;
                for (int i = 0; i < result.length; i++) {
                    result[index--] = helper(a, b, c, nums[i]);
                }
            }
        } else {
            if (a > 0) {
                int left = 0, right = nums.length - 1, index = result.length - 1;
                while (index >= 0) {
                    int val1 = helper(a, b, c, nums[left]);
                    int val2 = helper(a, b, c, nums[right]);
                    if (val1 <= val2) {
                        result[index--] = val2;
                        right--;
                    } else {
                        result[index--] = val1;
                        left++;
                    }
                }
            } else {
                int left = 0, right = nums.length - 1, index = 0;
                while (index < nums.length) {
                    int val1 = helper(a, b, c, nums[left]);
                    int val2 = helper(a, b, c, nums[right]);
                    if (val1 <= val2) {
                        result[index++] = val1;
                        left++;
                    } else {
                        result[index++] = val2;
                        right--;
                    }
                }
            }
        }
        return result;
    }

    private int helper(int a, int b, int c, int x) {
        return x * x * a + b * x + c;
    }


    public static void main(String[] args) {
        SortTransformedArray test = new SortTransformedArray();
//        int[] array = {-98,-97,-96,-93,-90,-89,-89,-88,-85,-83,-83,-79,-78,-78,-76,-74,-63,-63,-63,-62,-59,-59,-57,-55,-54,-53,-49,-45,-41,-37,-35,-31,-25,-22,-20,-20,-17,-16,-16,-15,-13,-12,-12,-11,-4,-1,0,5,6,7,8,9,13,16,16,29,29,29,31,31,32,32,33,33,34,35,36,39,41,42,43,45,47,49,53,56,59,59,65,66,68,68,70,75,78,80,80,81,82,84,85,85,89,90,90,92,99,99};
//        int[] array = {-98,-97,-96,-93,-90,-89,-89};
        int[] array = {-100,-98,-96,-90,-90,-86,-85,-77,-71,-70,-68,-59,-53,-47,-46,-45,-45,-37,-32,-17,-16,-14,-12,-12,-9,-5,-5,-4,-3,-1,1,7,10,18,19,21,24,28,29,29,32,42,46,46,54,55,59,62,64,68,76,80,96,98};
        System.out.print(test.sortTransformedArray(array, 74,77,64));
    }
}
