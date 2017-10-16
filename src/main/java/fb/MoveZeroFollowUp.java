package fb;

public class MoveZeroFollowUp {

    // 不需要维护相对顺序但是care后面是什么值
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            if (nums[left] == val) {
                if (nums[right] != val) {
                    swap(nums, left, right);
                }
                right--;
            } else {
                left++;
            }
        }
        return left;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    // 不需要保持顺序且不需要维护右边

//    public int removeElement(int[] nums, int val) {
//        int left = 0;
//        int right = nums.length - 1;
//
//        while (left <= right) {
//            while (left <= right && nums[left] != val) {
//                left++;
//            }
//
//            while (left <= right && nums[right] == val) {
//                right--;
//            }
//
//            if (left < right) {
//                nums[left] = nums[right];
//                left++;
//                right--;
//            }
//        }
//        return left;
//    }

    // duplicate logic少 更好
//    public int removeElement(int[] nums, int val) {
//        int left = 0;
//        int right = nums.length - 1;
//
//        while (left <= right) {
//            if (nums[left] == val) {
//                if (nums[right] != val) {
//                    nums[left] = nums[right];
//                }
//                right--;
//            } else {
//                left++;
//            }
//        }
//        return left;
//    }

    public static void main(String[] args) {
//        int[] a = {1,0,2,3,4};
//        int[] a = {0,0,2,3,4};
//        int[] a = {0,0,0,0,0};
//        int[] a = {2,3,4,5,0};
        int[] a = {2,3,4,5,6};
        MoveZeroFollowUp test = new MoveZeroFollowUp();
        System.out.println(test.removeElement(a, 0));
        for (int i : a) {
            System.out.println(i);
        }
    }
}
