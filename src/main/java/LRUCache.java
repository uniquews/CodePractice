import java.util.HashMap;

/**
 * Created by shuaiwang on 10/24/16.
 */
public class LRUCache {
    private class Node {
        public int key;
        public int value;
        public Node prev;
        public Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int size;
    private HashMap<Integer, Node> hs;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        // write your code here
        size = capacity;
        hs = new HashMap<>(capacity);
        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    // @return an integer
    public int get(int key) {
        // write your code here
        if (!hs.containsKey(key)) {
            return -1;
        }
        Node cur = hs.get(key);
        int result = cur.value;
        Node prevCur = cur.prev;
        Node nextCur = cur.next;
        prevCur.next = cur.next;
        nextCur.prev = cur.prev;

        moveToTail(hs.get(key));
        return result;
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        // write your code here
        if (hs.containsKey(key)) {
            this.get(key);
            hs.get(key).value = value;
            return;
        }

        if (hs.size() == size) {
            Node cur = head.next;
            hs.remove(cur.key);
            cur.prev.next = cur.next;
            cur.next.prev = cur.prev;
        }

        Node cur = new Node(key, value);
        hs.put(key, cur);
        moveToTail(cur);
    }

    private void moveToTail(Node cur) {
        cur.next = tail;
        cur.prev = tail.prev;
        cur.prev.next = cur;
        tail.prev = cur;
    }

    public static void main(String[] args) {
        LRUCache test = new LRUCache(2);
        test.set(2, 1);
        test.set(1, 1);
        System.out.print(test.get(2));
        test.set(4, 1);

        System.out.print(test.get(1));
        System.out.print(test.get(2));
    }
}
