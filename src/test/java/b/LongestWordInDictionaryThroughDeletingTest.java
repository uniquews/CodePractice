package b;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;

/**
 * Created by bohan on 4/29/17.
 */
public class LongestWordInDictionaryThroughDeletingTest {
    @Test
    public void test() {
        LongestWordInDictionaryThroughDeleting test = new LongestWordInDictionaryThroughDeleting();
        List<String> d = Arrays.asList("ale", "apple", "monkey", "plea");
        assertThat(test.findLongestWord("abpcplea", d)).isEqualTo("apple");
    }

    @Test
    public void test2() {
        LongestWordInDictionaryThroughDeleting test = new LongestWordInDictionaryThroughDeleting();
        List<String> d = Arrays.asList("a","b","c");
        assertThat(test.findLongestWord("abpcplea", d)).isEqualTo("a");
    }
}
