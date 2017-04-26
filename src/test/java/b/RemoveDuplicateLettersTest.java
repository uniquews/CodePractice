package b;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

/**
 * Created by bohan on 4/25/17.
 */
public class RemoveDuplicateLettersTest {
    @Test
    public void test() {
        RemoveDuplicateLetters test = new RemoveDuplicateLetters();
        assertThat(test.removeDuplicateLetters("cbacdcbc")).isEqualTo("acdb");
    }

    @Test
    public void test2() {
        RemoveDuplicateLetters test = new RemoveDuplicateLetters();
        assertThat(test.removeDuplicateLetters("bbcaac")).isEqualTo("bac");
    }
}
