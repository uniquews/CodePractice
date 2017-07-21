package b;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.List;

import static com.google.common.truth.Truth.assertThat;

/**
 * Created by bohan on 7/12/17.
 */
public class WordLadderIITest {
    /**
     * beginWord = "hit"
     * endWord = "cog"
     * wordList = ["hot","dot","dog","lot","log","cog"]
     */
    @Test
    public void test() {
        WordLadderII test = new WordLadderII();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = ImmutableList.of("hot", "dot", "dog", "lot", "log", "cog");
        List<List<String>> actual = test.findLadders(beginWord, endWord, wordList);
        assertThat(actual).hasSize(2);
        assertThat(actual.get(0)).containsExactly("hit", "hot", "dot", "dog", "cog");
        assertThat(actual.get(1)).containsExactly("hit", "hot", "lot", "log", "cog");

    }
}
