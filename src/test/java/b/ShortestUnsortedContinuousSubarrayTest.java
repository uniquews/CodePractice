package b;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class ShortestUnsortedContinuousSubarrayTest {
    @Test
    public void test() {
        ShortestUnsortedContinuousSubarray test = new ShortestUnsortedContinuousSubarray();
        int[] A = {8, 9, 1, 2, 3, 4};
        assertThat(test.findUnsortedSubarray(A)).isEqualTo(6);
    }

    @Test
    public void test2() {
        ShortestUnsortedContinuousSubarray test = new ShortestUnsortedContinuousSubarray();
        int[] A = {2, 6, 4, 8, 10, 9, 15};
        assertThat(test.findUnsortedSubarray(A)).isEqualTo(5);
    }

    @Test
    public void test3() {
        ShortestUnsortedContinuousSubarray test = new ShortestUnsortedContinuousSubarray();
        int[] A = {1};
        assertThat(test.findUnsortedSubarray(A)).isEqualTo(0);
    }

    @Test
    public void test4() {
        ShortestUnsortedContinuousSubarray test = new ShortestUnsortedContinuousSubarray();
        int[] A = {1, 2, 3, 4};
        assertThat(test.findUnsortedSubarray(A)).isEqualTo(0);
    }
}
