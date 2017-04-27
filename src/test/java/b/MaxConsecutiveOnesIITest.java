package b;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class MaxConsecutiveOnesIITest {
    @Test
    public void test() {
        MaxConsecutiveOnesII test = new MaxConsecutiveOnesII();
        int[] array = {1, 0, 1, 1, 0};
        assertThat(test.findMaxConsecutiveOnes(array)).isEqualTo(4);
    }

    @Test
    public void test2() {
        MaxConsecutiveOnesII test = new MaxConsecutiveOnesII();
        int[] array = {1, 1, 1, 1, 1};
        assertThat(test.findMaxConsecutiveOnes(array)).isEqualTo(5);
    }

    @Test
    public void test3() {
        MaxConsecutiveOnesII test = new MaxConsecutiveOnesII();
        int[] array = {0, 1, 1, 1, 0};
        assertThat(test.findMaxConsecutiveOnes(array)).isEqualTo(4);
    }

    @Test
    public void test4() {
        MaxConsecutiveOnesII test = new MaxConsecutiveOnesII();
        int[] array = {1, 1, 1, 0, 0, 1, 1, 1};
        assertThat(test.findMaxConsecutiveOnes(array)).isEqualTo(4);
    }

    @Test
    public void test5() {
        MaxConsecutiveOnesII test = new MaxConsecutiveOnesII();
        int[] array = {0};
        assertThat(test.findMaxConsecutiveOnes(array)).isEqualTo(1);
    }

    @Test
    public void test6() {
        MaxConsecutiveOnesII test = new MaxConsecutiveOnesII();
        int[] array = {};
        assertThat(test.findMaxConsecutiveOnes(array)).isEqualTo(0);
    }
}
