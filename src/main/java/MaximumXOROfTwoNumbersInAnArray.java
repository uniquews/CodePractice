import java.util.HashSet;
import java.util.Set;

/**
 * Created by shuaiwang on 1/31/17.
 */

/**
 * From Leetode discusion, the alg idea is:
 to iteratively determine what would be each bit of the final result from left to right.
 And it narrows down the candidate group iteration by iteration. e.g. assume input are a,b,c,d,...z, 26 integers in total.
 In first iteration, if you found that a, d, e, h, u differs on the MSB(most significant bit), so you are sure your final
 result's MSB is set. Now in second iteration, you try to see if among a, d, e, h, u there are at least two numbers make
 the 2nd MSB differs, if yes, then definitely, the 2nd MSB will be set in the final result. And maybe at this point the
 candidate group shrinks from a,d,e,h,u to a, e, h. Implicitly, every iteration, you are narrowing down the candidate group,
 but you don't need to track how the group is shrinking, you only cares about the final result.
 *
 * */

/**
 * After I read the algorithm, I was still very confused. Then I walked through algorithm
 *
 * Max is the result, which needs to be satisfied with resultNumber1 ^ resultNumber2
 *
 * Mask is just for extracting the prefix bit digit for every number. For example, if mask = 110000...00 is
 * when we want to examine first two digits in array
 *
 * a^b = c means b^c = a
 *
 * Given {3,5,8} which are {0011, 0101, 1000}
 *
 * we examine numbers from left to right because if the most significant digit can be satisfied, the final result will be
 * bigger
 *
 * Let's make i start with 3, and i >= 0
 *
 * Round i == 3
 * mask  = 0000 | 1000 = 1000
 * hashset will contain the first digit of each number
 * tmp = 1000
 * tmp ^ each prefix in hashset, if the result can be found in hashset, then it means the current most significant digit can
 * be satisfied
 * max will be updated with max = 1000
 *
 * Round i == 2
 * mask = 1100
 * tmp = 1100
 * hashSet  {0000, 0100, 1000}
 * we can find tmp ^ one of numbers in hashset = one of numbers in hashSet (a ^ b = c => b ^ c = a)
 * max = 1100
 *
 * Round i == 1
 * mask = 1110
 * tmp = 1110
 * hashSet {0010, 0100, 1000}
 * we can't find tmp ^ one of numbers in hashSet = one of numbers in hashSet
 * so we don't update max, max is still 1100
 *
 * Round == 0
 * mask = 1111
 * tmp = 1101
 * this time we can find tmp ^ one of numbers in hashSet = one of numbers in hashSet
 * update max and this is final result
 *
 * */


public class MaximumXOROfTwoNumbersInAnArray {
    public int findMaximumXOR(int[] nums) {
        int max = 0, mask = 0;
        for (int i = 31; i >= 0; i--) {
            mask = mask | 1 << i;
            Set<Integer> hashSet = new HashSet<>();
            for (int n : nums) {
                hashSet.add(n & mask);
            }

            int tmp = max | 1 << i;
            for (int prefix : hashSet) {
                if (hashSet.contains(tmp ^ prefix)) {
                    max = tmp;
                    break;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaximumXOROfTwoNumbersInAnArray test = new MaximumXOROfTwoNumbersInAnArray();
        int[] nums = {3,5,10};
        test.findMaximumXOR(nums);
    }
}
