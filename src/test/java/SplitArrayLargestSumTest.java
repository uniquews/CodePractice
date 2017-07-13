import org.junit.Assert;
import org.junit.Test;

/**
 * Created by shuaiwang on 5/20/17.
 */
public class SplitArrayLargestSumTest {
    @Test
    public void test1() {
        int[] nums = {7,2,5,10,8};
        SplitArrayLargestSum test = new SplitArrayLargestSum();
        Assert.assertEquals(18, test.splitArray(nums, 2));
    }
}
