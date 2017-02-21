import utils.NestedInteger;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Created by shuaiwang on 2/14/17.
 */
public class NestedIterator implements Iterator<Integer> {
    private final Stack<NestedInteger> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        pushToStack(nestedList);
    }

    @Override
    public Integer next() {
        NestedInteger nestedInteger = stack.pop();
        if (nestedInteger.isInteger()) {
            return nestedInteger.getInteger();
        }
        pushToStack(nestedInteger.getList());
        return this.next();
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void pushToStack(List<NestedInteger> nestedList) {
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            if (nestedList.get(i) == null) {
                continue;
            }
            if (nestedList.get(i).isInteger()) {
                stack.push(nestedList.get(i));
            } else {
                if (!nestedList.get(i).getList().isEmpty() && nestedList.get(i).getList().get(0) != null) {
                    stack.push(nestedList.get(i));
                }
            }
        }
    }
}
