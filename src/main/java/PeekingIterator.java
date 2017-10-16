import java.util.Iterator;

/**
 * Created by shuaiwang on 3/15/17.
 */
public class PeekingIterator implements Iterator<Integer> {
    public Integer current;
    public Iterator<Integer> iter;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        current = null;
        iter = iterator;
        helper();
    }

    private void helper() {
        if (iter.hasNext()) {
            current = iter.next();
        } else {
            current = null;
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return current;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer result = current;
        helper();
        return result;
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }
}
