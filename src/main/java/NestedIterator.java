import utils.NestedInteger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Created by shuaiwang on 2/14/17.
 */
public class NestedIterator implements Iterator<Integer> {
//    private List<Integer> listOfInterger;
//    private Iterator<Integer> iter;
//    public NestedIterator(List<NestedInteger> nestedList) {
//        // Initialize your data structure here.
//        listOfInterger = new ArrayList<>();
//        dfs(nestedList);
//        iter = listOfInterger.iterator();
//    }
//
//    // @return {int} the next element in the iteration
//    @Override
//    public Integer next() {
//        // Write your code here
//        return iter.next();
//    }
//
//    private void dfs(List<NestedInteger> l) {
//        if (l == null) {
//            return;
//        }
//
//        for (int i = 0; i < l.size(); i++) {
//            if (l.get(i).isInteger()) {
//                listOfInterger.add(l.get(i).getInteger());
//            } else {
//                dfs(l.get(i).getList());
//            }
//        }
//    }
//
//    // @return {boolean} true if the iteration has more element or false
//    @Override
//    public boolean hasNext() {
//        // Write your code here
//        return iter.hasNext();
//    }
//
//    public static void main(String[] args) {
//        List test = new ArrayList();
//        test.add(null);
//        System.out.print(test.size());
//    }

//    Stack<NestedInteger> stk;
//    Integer current;
//    public NestedIterator(List<NestedInteger> nestedList) {
//        stk = new Stack<>();
//        current = null;
//        for (int i = nestedList.size() - 1; i >= 0; i--) {
//            stk.push(nestedList.get(i));
//        }
//        helper();
//    }
//
//    private void helper() {
//        if (stk.isEmpty()) {
//            current = null;
//            return;
//        }
//
//        while (!stk.isEmpty() && !stk.peek().isInteger()) {
//            List<NestedInteger> l = stk.pop().getList();
//            for (int i = l.size() - 1; i >= 0; i--) {
//                stk.push(l.get(i));
//            }
//        }
//
//        current = stk.peek().getInteger();
//    }
//
//    @Override
//    public Integer next() {
//        Integer result = current;
//        helper();
//        return result;
//    }
//
//    @Override
//    public boolean hasNext() {
//        return !stk.isEmpty();
//    }



    Stack<NestedInteger> stk;
    Integer current;
    public NestedIterator(List<NestedInteger> nestedList) {
        stk = new Stack<>();
        current = null;
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stk.push(nestedList.get(i));
        }
        helper();
    }

    private void helper() {
        if (stk.isEmpty()) {
            current = null;
            return;
        }

        while (!stk.isEmpty() && !stk.peek().isInteger()) {
            List<NestedInteger> l = stk.pop().getList();
            for (int i = l.size() - 1; i >= 0; i--) {
                stk.push(l.get(i));
            }
        }

        if (!stk.isEmpty())
            current = stk.pop().getInteger();
        else
            current = null;
    }

    @Override
    public Integer next() {
        Integer result = current;
        helper();
        return result;
    }

    @Override
    public boolean hasNext() {
        return !stk.isEmpty() || current != null;
    }
}
