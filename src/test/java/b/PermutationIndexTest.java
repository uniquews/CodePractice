package b;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

/**
 * Created by bohan on 7/8/17.
 */
public class PermutationIndexTest {
    @Test
    public void test() {
        PermutationIndex test = new PermutationIndex();
        int[] A = {1, 2, 4};
        assertThat(test.permutationIndex(A)).isEqualTo(1);
    }
}
