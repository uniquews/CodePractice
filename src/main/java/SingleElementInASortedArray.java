public class SingleElementInASortedArray {
    public int singleNonDuplicate(int[] nums) {
        int base = 0;
        for (int i = 0; i < nums.length; i++) {
            base ^= nums[i];
        }
        return base;
    }
}
