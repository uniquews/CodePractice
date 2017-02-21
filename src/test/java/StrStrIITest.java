import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by shuaiwang on 2/18/17.
 */
public class StrStrIITest {
    @Test
    public void testStrStr2() {
        String source = "abacababc";
        String target = "abab";
        StrStrII str = new StrStrII();
        assertEquals(4, str.strStr2(source, target));
    }

    @Test
    public void testStrStr2_2() {
        String source = "abcd";
        String target = "bc";
        StrStrII str = new StrStrII();
        assertEquals(1, str.strStr2(source, target));
    }
}
