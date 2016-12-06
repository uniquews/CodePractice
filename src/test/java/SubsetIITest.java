import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by shuaiwang on 7/25/16.
 */
public class SubsetIITest {

    @Test
    public void test() {
        SubsetII test = new SubsetII();
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(1, 2));

        ArrayList<Integer> a = new ArrayList<>(Arrays.asList());
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(1));
        ArrayList<Integer> c = new ArrayList<>(Arrays.asList(1, 2));
        ArrayList<Integer> d = new ArrayList<>(Arrays.asList(2));

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        result.add(a);
        result.add(b);
        result.add(c);
        result.add(d);

        test.subsetsWithDup(input);
//        Assert.assertArray(result, test.subsetsWithDup(input));
    }
}
