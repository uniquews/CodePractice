package b;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

/**
 * Created by bohan on 7/16/17.
 */
public class SlidingWindowMaximumTest {
    @Test
    public void test() {
        SlidingWindowMaximum test = new SlidingWindowMaximum();
        assertThat(test.maxSlidingWindow(new int[]{1, 2, 7, 7, 2}, 1)).containsExactly(1, 2, 7, 7, 2).inOrder();
    }

    @Test
    public void test2() {
        SlidingWindowMaximum test = new SlidingWindowMaximum();
        assertThat(test.maxSlidingWindow(new int[]{1, 2, 7, 7, 2}, 3)).containsExactly(7, 7, 7).inOrder();
    }
}
