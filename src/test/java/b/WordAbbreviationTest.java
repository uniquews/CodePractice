package b;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;

/**
 * Created by bohan on 4/30/17.
 */
public class WordAbbreviationTest {
    @Test
    public void test() {
        WordAbbreviation test = new WordAbbreviation();
        List<String> dict = Arrays.asList(
                "like", "god", "internal", "me", "internet", "interval", "intension", "face", "intrusion");
        assertThat(test.wordsAbbreviation(dict))
                .containsExactly("l2e", "god", "internal", "me", "i6t", "interval", "inte4n", "f2e", "intr4n")
                .inOrder();
    }
}
