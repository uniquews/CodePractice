package b;

import com.google.common.collect.ImmutableSet;
import org.junit.Test;

import java.util.Set;

import static com.google.common.truth.Truth.assertThat;

/**
 * Created by bohan on 7/6/17.
 */
public class RemoveSubstringsTest {
    @Test
    public void test1() {
        RemoveSubstrings test = new RemoveSubstrings();
        String s = "ccdaabcdbb";
        Set<String> dict = ImmutableSet.of("ab", "cd");
        assertThat(test.minLength(s, dict)).isEqualTo(2);
    }

    @Test
    public void test2() {
        RemoveSubstrings test = new RemoveSubstrings();
        String s = "abcabd";
        Set<String> dict = ImmutableSet.of("ab", "abcd");
        assertThat(test.minLength(s, dict)).isEqualTo(0);
    }
}
