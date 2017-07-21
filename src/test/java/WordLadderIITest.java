import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.List;

/**
 * Created by shuaiwang on 7/12/17.
 */
public class WordLadderIITest {
    @Test
    public void test() {
        WordLadderII test = new WordLadderII();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = ImmutableList.of("hot", "dot", "dog", "lot", "log", "cog");
        List<List<String>> actual = test.findLadders(beginWord, endWord, wordList);

    }

    @Test
    public void test1() {
        WordLadderII test = new WordLadderII();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = ImmutableList.of("hot", "dot", "dog", "lot", "log", "cog");
        List<List<String>> actual = test.findLadders(beginWord, endWord, wordList);

    }


}
