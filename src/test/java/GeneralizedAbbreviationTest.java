import org.junit.Test;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;

/**
 * Created by bohan on 1/30/2017.
 *
 * @author Bohan Zheng
 */
public class GeneralizedAbbreviationTest {
  @Test
  public void test() {
    GeneralizedAbbreviation test = new GeneralizedAbbreviation();
    assertThat(test.generateAbbreviations("word"),
        containsInAnyOrder("word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"));
  }
}
