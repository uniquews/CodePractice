package b;

import org.junit.Test;

import java.lang.annotation.Target;

import static com.google.common.truth.Truth.assertThat;

/**
 * Created by bohan on 5/23/17.
 */
public class DropEggsTest {
    @Test
    public void test() {
        DropEggs test = new DropEggs();
        assertThat(test.eggDrop(100, 2)).isEqualTo(14);
    }
}
