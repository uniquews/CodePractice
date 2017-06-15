import org.junit.Assert;
import org.junit.Test;

/**
 * Created by shuaiwang on 6/14/17.
 */
public class ExpressionExpandTest {
    @Test
    public void test1() {
        String a = "3[abc]";
        ExpressionExpand test = new ExpressionExpand();
        Assert.assertEquals("abcabcabc", test.expressionExpand(a));
    }

    @Test
    public void test2() {
        String a = "abc3[ab]";
        ExpressionExpand test = new ExpressionExpand();
        Assert.assertEquals("abcababab", test.expressionExpand(a));
    }

    @Test
    public void test3() {
        String a = "4[ac]dy";
        ExpressionExpand test = new ExpressionExpand();
        Assert.assertEquals("acacacacdy", test.expressionExpand(a));
    }

    @Test
    public void test4() {
        String a = "3[2[ad]3[pf]]xyz";
        ExpressionExpand test = new ExpressionExpand();
        Assert.assertEquals("adadpfpfpfadadpfpfpfadadpfpfpfxyz", test.expressionExpand(a));
    }

    @Test
    public void test5() {
        String a = "4[wer]0[er]";
        ExpressionExpand test = new ExpressionExpand();
        Assert.assertEquals("werwerwerwer", test.expressionExpand(a));
    }

    // 1[0[abc]xy]
    @Test
    public void test6() {
        String a = "1[0[abc]xy]";
        ExpressionExpand test = new ExpressionExpand();
        Assert.assertEquals("xy", test.expressionExpand(a));
    }

}
