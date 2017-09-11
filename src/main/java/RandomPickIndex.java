import java.util.Random;

/**
 * Created by shuaiwang on 5/16/17.
 */


/**
 * 这个做法可以解决shffule array with array size is unlimited. 需要用到额外空间
 *
 * O(1) space 的 shuffle array with fixed size 和这道题用的都是Reservoir sampling
 * 只不过 shuffle array 在call random.nextInt时，样本大小是从大到小的，这道题是从小到大的，
 * 正因这个性质，使得本题的解法可以用来解决size is unlimited的情况。 我不需要知道后面还有多少个数
 * */
public class RandomPickIndex {
    private int[] n;
    private Random rand;
    public RandomPickIndex(int[] nums) {
        n = nums;
        rand = new Random();
    }

    public int pick(int target) {
        int candidate = -1;
        int count = 1;
        for (int i = 0; i < n.length; i++) {
            if (n[i] == target) {
                int guess = rand.nextInt(count);
                if (guess == 0) {
                    candidate = i;
                }
                count++;
            }
        }
        return candidate;
    }
}
