import org.junit.Assert;
import org.junit.Test;

/**
 * Created by shuaiwang on 4/20/17.
 */
public class CreateMaximumNumberTest {
    @Test
    public void testF1() {
        int[] a = {3, 4, 6, 5};
        int[] b = {9, 1, 2, 5, 8, 3};
        int[] result = {9, 8, 6, 5, 3};
        Assert.assertArrayEquals(result, new CreateMaximumNumber().maxNumber(a,b,5));
    }

    @Test
    public void testF2() {
        int[] a = {6, 7};
        int[] b = {6,0,4};
        int[] result = {6,7,6,0,4};
        Assert.assertArrayEquals(result, new CreateMaximumNumber().maxNumber(a,b,5));
    }

    @Test
    public void testF3() {
        int[] a = {3, 9};
        int[] b = {8,9};
        int[] result = {9,8,9};
        Assert.assertArrayEquals(result, new CreateMaximumNumber().maxNumber(a,b,3));
    }
}
