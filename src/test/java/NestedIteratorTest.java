import org.junit.Test;
import utils.NestedInteger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by shuaiwang on 2/14/17.
 */
public class NestedIteratorTest {
    @Test
    public void test() {
        List<NestedInteger> list = new ArrayList<>();
        List<NestedInteger> subList = new ArrayList<>();
        subList.add(null);
        NestedInteger n1 = new NestedInteger(subList);
        NestedInteger n2 = new NestedInteger(new ArrayList<>(subList));
        list.add(n1);
        list.add(n2);
        NestedIterator iterator = new NestedIterator(list);
        while (iterator.hasNext()) {
            iterator.next();
        }
    }
}
