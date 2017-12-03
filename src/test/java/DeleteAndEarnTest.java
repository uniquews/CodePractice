import org.junit.Assert;
import org.junit.Test;

public class DeleteAndEarnTest {
    @Test
    public void test1() {
        DeleteAndEarn tester = new DeleteAndEarn();
        int[] a = {3, 4, 2};
        Assert.assertEquals(6, tester.deleteAndEarn(a));
    }

    @Test
    public void test2() {
        DeleteAndEarn tester = new DeleteAndEarn();
        int[] a = {2, 2, 3, 3, 3, 4};
        Assert.assertEquals(9, tester.deleteAndEarn(a));
    }
}
