public class RotateArray {
    public void rotate(int[] nums, int k) {
        int count = 0;
        int tmp = nums[0];
        int pos = k % nums.length;
        int start = 0;
        while (count < nums.length) {
            int nextPos = (pos + k) % nums.length;
            int nextTmp = nums[pos];
            nums[pos] = tmp;
            count++;

            if (start == pos) {
                start++;
                pos = (start + k) % nums.length;
                tmp = nums[start];
            } else {
                tmp = nextTmp;
                pos = nextPos;
            }
        }
    }

    public static void main(String[] args) {
        RotateArray test = new RotateArray();
        int[] nums = {1,2,3,4,5,6,7};
        int k = 0;
        test.rotate(nums, k);
        return;
    }
}
