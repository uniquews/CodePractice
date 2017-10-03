package fb;

public class MoveZeroFollowUp {
    /**
     * 不需要维护相对顺序
     * */

    public void moveZero(int[] nums) {
        int i = 0;
        while (i < nums.length && nums[i] != 0) {
            i++;
        }

        int j = nums.length - 1;
        while (j >= 0 && nums[j] == 0) {
            j--;
        }

        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;

            while (i < nums.length && nums[i] != 0) {
                i++;
            }

            while (j >= 0 && nums[j] == 0) {
                j--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
//        int[] a = {1,0,2,3,4};
//        int[] a = {0,0,2,3,4};
//        int[] a = {0,0,0,0,0};
//        int[] a = {2,3,4,5,0};
        int[] a = {2,3,4,5,6};
        MoveZeroFollowUp test = new MoveZeroFollowUp();
        test.moveZero(a);
        for (int i : a) {
            System.out.println(i);
        }
    }
}
