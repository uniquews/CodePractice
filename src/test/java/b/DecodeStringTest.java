package b;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

/**
 * Created by bohan on 7/16/17.
 */
public class DecodeStringTest {
    @Test
    public void test() {
        DecodeString test = new DecodeString();
        assertThat(test.decodeString("3[a]2[bc]")).isEqualTo("aaabcbc");
    }

    @Test
    public void test2() {
        DecodeString test = new DecodeString();
        assertThat(test.decodeString("3[a2[c]]")).isEqualTo("accaccacc");
    }

    @Test
    public void test3() {
        DecodeString test = new DecodeString();
        assertThat(test.decodeString("2[abc]3[cd]ef")).isEqualTo("abcabccdcdcdef");
    }
}
