package b;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

/**
 * Created by bohan on 7/16/17.
 */
public class EncodeStringWithShortestLengthTest {
    @Test
    public void test() {
        EncodeStringWithShortestLength test = new EncodeStringWithShortestLength();
        assertThat(test.encode("aaa")).isEqualTo("aaa");
    }

    @Test
    public void test2() {
        EncodeStringWithShortestLength test = new EncodeStringWithShortestLength();
        assertThat(test.encode("aaaaa")).isEqualTo("5[a]");
    }

    @Test
    public void test3() {
        EncodeStringWithShortestLength test = new EncodeStringWithShortestLength();
        assertThat(test.encode("aaaaaaaaaa")).isIn(ImmutableList.of("10[a]", "9[a]a", "a9[a]"));
    }

    @Test
    public void test4() {
        EncodeStringWithShortestLength test = new EncodeStringWithShortestLength();
        assertThat(test.encode("aabcaabcd")).isEqualTo("2[aabc]d");
    }

    @Test
    public void test5() {
        EncodeStringWithShortestLength test = new EncodeStringWithShortestLength();
        assertThat(test.encode("abbbabbbcabbbabbbc")).isEqualTo("2[2[abbb]c]");
    }

    @Test
    public void test6() {
        EncodeStringWithShortestLength test = new EncodeStringWithShortestLength();
        assertThat(test.encode("abcdcdcdabcdcdcdxyxyxyxy")).isEqualTo("2[ab3[cd]]4[xy]");
    }
}
