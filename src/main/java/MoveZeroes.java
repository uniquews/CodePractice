/**
 * Created by shuaiwang on 5/12/17.
 */
public class MoveZeroes {
    // 冒泡排序
//    public void moveZeroes(int[] nums) {
//        int endIndex = nums.length - 1;
//        while (endIndex >= 0 && nums[endIndex] == 0) {
//            endIndex--;
//        }
//        for (int i = 0; i < endIndex; i++) {
//            if (nums[i] != 0)
//                continue;
//            int start = i;
//            for (int j = i + 1; j <= endIndex; j++) {
//                if (nums[j] == 0) {
//                    continue;
//                } else {
//                    swap(nums, start, j);
//                    start = j;
//                }
//            }
//            endIndex--;
//        }
//    }

    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            } else {
                nums[index++] = nums[i];
            }
        }

        while (index < nums.length) {
            nums[index++] = 0;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
