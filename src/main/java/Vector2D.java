import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by shuaiwang on 4/10/17.
 */
public class Vector2D implements Iterator<Integer> {

    Iterator<List<Integer>> iter1;
    Iterator<Integer> iter2;
    public Vector2D(List<List<Integer>> vec2d) {
        if (vec2d != null) {
            iter1 = vec2d.iterator();
        }
        helper();
    }

    private void helper() {
        while ((iter2 == null || !iter2.hasNext()) && iter1.hasNext()) {
            iter2 = iter1.next().iterator();
        }
    }

    @Override
    public Integer next() {
        Integer result = iter2.next();
        helper();
        return result;
    }

    @Override
    public boolean hasNext() {
        return iter2 != null && iter2.hasNext();
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
        List<Integer> l2 = new ArrayList<>();
        l.add(null);
        l2.add(1);
        list.add(l);
        list.add(l2);
        Vector2D v = new Vector2D(list);
        while (v.hasNext()) {
            System.out.println(v.next());
        }
    }
}
