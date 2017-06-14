import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by shuaiwang on 4/10/17.
 */
public class Vector2D implements Iterator<Integer> {
    private Iterator<List<Integer>> i;
    private Iterator<Integer> j;
    public Vector2D(List<List<Integer>> vec2d) {
        // Initialize your data structure here
        i = vec2d.iterator();
        j = null;
        helper();
    }

    @Override
    public Integer next() {
        // Write your code here
        return j.next();
    }

    @Override
    public boolean hasNext() {
        // Write your code here
        if (j == null) {
            return false;
        }

        if (j.hasNext()) {
            return true;
        }
        j = null;
        helper();
        if (j == null) return false;
        return j.hasNext();
    }

    private void helper() {
        while (j == null && i.hasNext()) {
            List<Integer> l = i.next();
            if (l != null)
                j = l.iterator();
        }
    }

    /**
     *  List<List<Integer>> list = new ArrayList<>();
        List<Integer> l = new ArrayList<>();

        如果l.add(null)  list.add(l) 那么iterator i 有一个element，iterator j 也有一个element 是null
        如果list.add(null) 那么iterator i有一个null element，i.hasNext()不会报错但是i.next().iterator会报错，因为i.next()是Null
     * */

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        l.add(1);
        list.add(l);
        Vector2D v = new Vector2D(list);
        while (v.hasNext()) {
            System.out.println(v.next());
        }
    }
}
