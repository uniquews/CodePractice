import org.junit.Assert;
import org.junit.Test;

public class DailyTemperaturesTest {
    @Test
    public void test1() {
        int[] a = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = {1, 1, 4, 2, 1, 1, 0, 0};

        DailyTemperatures tester = new DailyTemperatures();
        Assert.assertArrayEquals(result, tester.dailyTemperatures(a));
    }
}
