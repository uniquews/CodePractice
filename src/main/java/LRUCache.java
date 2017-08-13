import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * Created by shuaiwang on 10/24/16.
 */
//public class LRUCache {
//    private class Node {
//        public int key;
//        public int value;
//        public Node prev;
//        public Node next;
//
//        public Node(int key, int value) {
//            this.key = key;
//            this.value = value;
//        }
//    }
//
//    private int size;
//    private HashMap<Integer, Node> hs;
//    private Node head;
//    private Node tail;
//
//    public LRUCache(int capacity) {
//        // write your code here
//        size = capacity;
//        hs = new HashMap<>(capacity);
//        head = new Node(0, 0);
//        tail = new Node(0, 0);
//
//        head.next = tail;
//        tail.prev = head;
//    }
//
//    // @return an integer
//    public int get(int key) {
//        // write your code here
//        if (!hs.containsKey(key)) {
//            return -1;
//        }
//        Node cur = hs.get(key);
//        int result = cur.value;
//        Node prevCur = cur.prev;
//        Node nextCur = cur.next;
//        prevCur.next = cur.next;
//        nextCur.prev = cur.prev;
//
//        moveToTail(hs.get(key));
//        return result;
//    }
//
//    // @param key, an integer
//    // @param value, an integer
//    // @return nothing
//    public void set(int key, int value) {
//        // write your code here
//        if (hs.containsKey(key)) {
//            this.get(key);
//            hs.get(key).value = value;
//            return;
//        }
//
//        if (hs.size() == size) {
//            Node cur = head.next;
//            hs.remove(cur.key);
//            cur.prev.next = cur.next;
//            cur.next.prev = cur.prev;
//        }
//
//        Node cur = new Node(key, value);
//        hs.put(key, cur);
//        moveToTail(cur);
//    }
//
//    private void moveToTail(Node cur) {
//        cur.next = tail;
//        cur.prev = tail.prev;
//        cur.prev.next = cur;
//        tail.prev = cur;
//    }
//
//    public static void main(String[] args) {
//        LRUCache test = new LRUCache(2);
//        test.set(2, 1);
//        test.set(1, 1);
//        System.out.print(test.get(2));
//        test.set(4, 1);
//
//        System.out.print(test.get(1));
//        System.out.print(test.get(2));
//    }
//}


    //做完LFU之后，想用LinededHashSet实现一遍
//public class LRUCache {
//
//    private HashMap<Integer, Integer> values;
//    private LinkedHashSet<Integer> linkedHashSet;
//    private int size;
//    public LRUCache(int capacity) {
//        size = capacity;
//        values = new HashMap<>(size);
//        linkedHashSet = new LinkedHashSet<>();
//    }
//
//    public int get(int key) {
//        if (!values.containsKey(key)) {
//            return -1;
//        }
//
//        linkedHashSet.remove(key);
//        linkedHashSet.add(key);
//        return values.get(key);
//    }
//
//    public void put(int key, int value) {
//        if (values.containsKey(key)) {
//            values.put(key, value);
//            get(key);
//            return;
//        }
//
//        if (values.size() == size) {
//            int leastRecentUsedKey = linkedHashSet.iterator().next();
//            values.remove(leastRecentUsedKey);
//            linkedHashSet.remove(leastRecentUsedKey);
//        }
//
//        values.put(key, value);
//        linkedHashSet.add(key);
//    }


public class LRUCache {


    class Node {
        public int key;
        public int val;
        public Node prev;
        public Node next;
        public Node(int k, int v) {
            key = k;
            val = v;
        }
    }

    public Node head;
    public Node tail;
    public Map<Integer, Node> map;
    public int size;
    public LRUCache(int capacity) {
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
        size = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        Node current = map.get(key);
        int result = current.val;
        current.prev.next = current.next;
        current.next.prev = current.prev;

        current.next = null;
        current.prev = null;

        moveToTail(current);
        return result;
    }

    private void moveToTail(Node current) {
        current.prev = tail.prev;
        current.next = tail;
        tail.prev = current;
        current.prev.next = current;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.get(key).val = value;
            get(key);
            return;
        }

        if (map.keySet().size() == size) {
            Node out = head.next;
            head.next = out.next;
            out.next.prev = out.prev;
            out.next = null;
            out.prev = null;

            map.remove(out.key);
        }
        Node n = new Node(key, value);
        map.put(key, n);
        moveToTail(n);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
