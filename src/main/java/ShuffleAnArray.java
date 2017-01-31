import java.util.Random;

/**
 * Created by shuaiwang on 1/29/17.
 */
public class ShuffleAnArray {
    private int[] origins;
    public ShuffleAnArray(int[] nums) {
        origins = new int[nums.length];
        origins = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return origins;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int [] result = origins.clone();
        for (int i = result.length - 1; i >= 0; i--) {
            Random rand = new Random();
            int index = rand.nextInt(i + 1);
            swap(result, i, index);
        }
        return result;
    }

    private int[] swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
        return array;
    }
}
