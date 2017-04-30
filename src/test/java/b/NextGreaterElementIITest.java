package b;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

/**
 * Created by bohan on 4/30/17.
 */
public class NextGreaterElementIITest {
    @Test
    public void test() {
        NextGreaterElementII test = new NextGreaterElementII();
        int[] nums = {1, 2, 1};
        assertThat(test.nextGreaterElements(nums)).isEqualTo(new int[]{2, -1, 2});
    }
}
