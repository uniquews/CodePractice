/**
 * Created by shuaiwang on 1/18/17.
 */
public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        int diff = 0;

        // Pass 1, we use XOR to filter all numbers which exist twice. The diff will be the
        // combination of two target number

        for (int i = 0; i < nums.length; i++) {
            diff ^= nums[i];
        }

        // Since there will always be on bit difference between target a and target b.
        // From the right to left, we find the position of that bit
        // if diff = 3, which is 0...011, -3 will be 1111...01, then diff &= -diff will be
        // 1. 1 means we found the position of the different bit between two numbers
        // if diff = 2, which is 000..000010, -2 will be 111..111110, then the diff = 2
        //

        diff &= -diff;

        int[] result = new int[2];


        // Then we use diff to divide nums into two groups. One group are numbers, which has 0 i at
        // position diff. The other one are numbers, which has 1 at position diff. The target a and
        // target b falls into two group.
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & diff) == 0) {
                result[0] ^= nums[i];
            } else {
                result[1] ^= nums[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int a = Integer.MAX_VALUE;
        System.out.println(Integer.toBinaryString(a));
    }
}
