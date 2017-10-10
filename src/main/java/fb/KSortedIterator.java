package fb;

import java.util.*;

public class KSortedIterator<E extends Comparable<E>> implements Iterator<E> {
    private class Node {
        private int arr;
        private int index;
        private E val;

        private Node(int arr, int index, E val) {
            this.arr = arr;
            this.index = index;
            this.val = val;
        }
    }

    private final Queue<Node> q;
    private final List<List<E>> list;

    public KSortedIterator(List<List<E>> list) {
        q = new PriorityQueue<>(Comparator.comparing(a -> a.val));
        this.list = list;

        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException();
        }


        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == null || list.get(i).isEmpty()) {
                continue;
            }
            Node n = new Node(i, 0, list.get(i).get(0));
            q.offer(n);
        }
    }

    @Override
    public E next() {
        Node cur = q.poll();
        if (cur.index + 1 < this.list.get(cur.arr).size()) {
            Node next = new Node(cur.arr, cur.index + 1, this.list.get(cur.arr).get(cur.index + 1));
            q.offer(next);
        }

        return cur.val;
    }

    @Override
    public boolean hasNext() {
        return !q.isEmpty();
    }

    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(Arrays.asList(90, 100, 101));
        result.add(Arrays.asList(1, 2, 3));
        result.add(Arrays.asList(40, 50, 200));

        KSortedIterator<Integer> test = new KSortedIterator<>(result);
        while (test.hasNext()) {
            System.out.println(test.next());
        }
    }
}
