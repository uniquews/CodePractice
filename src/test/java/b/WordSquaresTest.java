package b;

import org.junit.Test;

import java.util.List;

import static com.google.common.truth.Truth.assertThat;

/**
 * Created by bohan on 7/11/17.
 */
public class WordSquaresTest {
    @Test
    public void test() {
        WordSquares test = new WordSquares();
        String[] words = {"area", "lead", "wall", "lady", "ball"};
        List<List<String>> res = test.wordSquares(words);
        assertThat(res).hasSize(2);
        assertThat(res.get(0)).containsExactly("wall", "area", "lead", "lady");
        assertThat(res.get(1)).containsExactly("ball", "area", "lead", "lady");
    }
}
