import org.junit.Assert;
import org.junit.Test;

/**
 * Created by shuaiwang on 5/14/17.
 */
public class IntegertoEnglishWordsTest {
    @Test
    public void testF1() {
        int num = 123;
        Assert.assertEquals("One Hundred Twenty Three", new IntegertoEnglishWords().numberToWords(num));
    }
}
