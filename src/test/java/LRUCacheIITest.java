import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by bohan on 4/9/17.
 */
public class LRUCacheIITest {

    // ["LRUCache","put","put","get","put","get","put","get","get","get"]
    // [[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
    // [null,null, null, 1,  null, -1, null, -1, 3,  4]
    @Test
    public void test() {
        LRUCacheII cache = new LRUCacheII(2);
        cache.put(1, 1);
        cache.put(2, 2);
        assertEquals(1, cache.get(1));
        cache.put(3, 3);
        assertEquals(-1, cache.get(2));
        cache.put(4, 4);
        assertEquals(-1, cache.get(1));
        assertEquals(3, cache.get(3));
        assertEquals(4, cache.get(4));
    }

    // ["LRUCache","get","put","get","put","put","get","get"]
    //        [[2],[2],  [2,6],[1],  [1,5],[1,2],[1],  [2]]
    //        [null,-1,   null, -1,   null, null, 2,    6]
    @Test
    public void test2() {
        LRUCacheII cache = new LRUCacheII(2);
        assertEquals(-1, cache.get(2));
        cache.put(2, 6);
        assertEquals(-1, cache.get(1));
        cache.put(1, 5);
        cache.put(1, 2);
        assertEquals(2, cache.get(1));
        assertEquals(6, cache.get(2));
    }
}
