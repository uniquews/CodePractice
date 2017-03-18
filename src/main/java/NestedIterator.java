import utils.NestedInteger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Created by shuaiwang on 2/14/17.
 */
public class NestedIterator implements Iterator<Integer> {
    private List<Integer> listOfInterger;
    private Iterator<Integer> iter;
    public NestedIterator(List<NestedInteger> nestedList) {
        // Initialize your data structure here.
        listOfInterger = new ArrayList<>();
        dfs(nestedList);
        iter = listOfInterger.iterator();
    }

    // @return {int} the next element in the iteration
    @Override
    public Integer next() {
        // Write your code here
        return iter.next();
    }

    private void dfs(List<NestedInteger> l) {
        if (l == null) {
            return;
        }

        for (int i = 0; i < l.size(); i++) {
            if (l.get(i).isInteger()) {
                listOfInterger.add(l.get(i).getInteger());
            } else {
                dfs(l.get(i).getList());
            }
        }
    }

    // @return {boolean} true if the iteration has more element or false
    @Override
    public boolean hasNext() {
        // Write your code here
        return iter.hasNext();
    }

    public static void main(String[] args) {
        List test = new ArrayList();
        test.add(null);
        System.out.print(test.size());
    }
}
