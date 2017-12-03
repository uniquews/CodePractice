import org.junit.Assert;
import org.junit.Test;

public class MonotoneIncreasingDigitsTest {
    @Test
    public void test1() {
        int n = 10;
        MonotoneIncreasingDigits tester = new MonotoneIncreasingDigits();
        Assert.assertEquals(9, tester.monotoneIncreasingDigits(n));
    }

    @Test
    public void test2() {
        int n = 1234;
        MonotoneIncreasingDigits tester = new MonotoneIncreasingDigits();
        Assert.assertEquals(1234, tester.monotoneIncreasingDigits(n));
    }

    @Test
    public void test3() {
        int n = 332;
        MonotoneIncreasingDigits tester = new MonotoneIncreasingDigits();
        Assert.assertEquals(299, tester.monotoneIncreasingDigits(n));
    }
}
