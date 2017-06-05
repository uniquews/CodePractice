package b;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

/**
 * Created by bohan on 5/15/17.
 */
public class MinimumSizeSubarraySumTest {
    @Test
    public void test() {
        MinimumSizeSubarraySum test = new MinimumSizeSubarraySum();
        int[] nums = {2, 3, 1, 2, 4, 3};
        assertThat(test.minSubArrayLen(7, nums)).isEqualTo(2);
    }
}
