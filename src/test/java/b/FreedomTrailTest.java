package b;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

/**
 * Created by bohan on 4/30/17.
 */
public class FreedomTrailTest {
    @Test
    public void test() {
        FreedomTrail test = new FreedomTrail();
        assertThat(test.findRotateSteps("godding", "gd")).isEqualTo(4);
    }
}
