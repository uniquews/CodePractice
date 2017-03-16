import java.util.Iterator;

/**
 * Created by shuaiwang on 3/15/17.
 */
public class PeekingIterator implements Iterator<Integer> {

    private Integer nextNumber;
    private Iterator<Integer> iter;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        iter = iterator;
        if (iter.hasNext()) {
            nextNumber = iter.next();
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return nextNumber;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer currentNext = nextNumber;
        if (iter.hasNext()) {
            nextNumber = iter.next();
        } else {
            nextNumber = null;
        }
        return currentNext;
    }

    @Override
    public boolean hasNext() {
        return nextNumber != null;
    }
}
