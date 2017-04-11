import java.util.Iterator;
import java.util.List;

/**
 * Created by shuaiwang on 4/10/17.
 */
public class Vector2D implements Iterator<Integer> {
    private Iterator<List<Integer>> i;
    private Iterator<Integer> j;
    public Vector2D(List<List<Integer>> vec2d) {
        i = vec2d.iterator();
        while (j == null && i.hasNext()) {
            j = i.next().iterator();
        }
    }

    @Override
    public Integer next() {
        return j.next();
    }

    @Override
    public boolean hasNext() {
        if (j == null) {
            return false;
        }

        if (j.hasNext()) {
            return true;
        }

        while ((j == null || !j.hasNext()) && i.hasNext()) {
            j = i.next().iterator();
        }
        return j != null && j.hasNext();
    }
}
