package fb;

import java.util.*;

//public class KSortedIterator<E extends Comparable<E>> implements Iterator<E> {
//    private class Node {
//        private int arr;
//        private int index;
//        private E val;
//
//        private Node(int arr, int index, E val) {
//            this.arr = arr;
//            this.index = index;
//            this.val = val;
//        }
//    }
//
//    private final Queue<Node> q;
//    private final List<List<E>> list;
//
//    public KSortedIterator(List<List<E>> list) {
//        q = new PriorityQueue<>(Comparator.comparing(a -> a.val));
//        this.list = list;
//
//        if (list == null || list.isEmpty()) {
//            throw new IllegalArgumentException();
//        }
//
//
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i) == null || list.get(i).isEmpty()) {
//                continue;
//            }
//            Node n = new Node(i, 0, list.get(i).get(0));
//            q.offer(n);
//        }
//    }
//
//    @Override
//    public E next() {
//        Node cur = q.poll();
//        if (cur.index + 1 < this.list.get(cur.arr).size()) {
//            Node next = new Node(cur.arr, cur.index + 1, this.list.get(cur.arr).get(cur.index + 1));
//            q.offer(next);
//        }
//
//        return cur.val;
//    }
//
//    @Override
//    public boolean hasNext() {
//        return !q.isEmpty();
//    }


public class KSortedIterator implements Iterator<Integer> {
    class Node {
        int val;
        Iterator<Integer> iter;
        Node(int val, Iterator<Integer> iter) {
          this.val = val;
          this.iter = iter;
        }
    }

    private final Queue<Node> q;

    public KSortedIterator(List<List<Integer>> list) {
        q = new PriorityQueue<>(Comparator.comparing(a -> a.val));

        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == null || list.get(i).isEmpty()) {
                continue;
            }
            Iterator<Integer> iter = list.get(i).iterator();
            while (iter.hasNext()) {
                Integer tmp = iter.next();
                if (tmp == null) {
                    continue;
                } else {
                    Node n = new Node (tmp, iter);
                    q.offer(n);
                    break;
                }
            }

        }
    }

    @Override
    public Integer next() {
        Node cur = q.poll();
        Integer result = cur.val;
        while (cur.iter.hasNext()) {
            Integer tmp = cur.iter.next();
            if (tmp == null) {
                continue;
            } else {
                Node next = new Node(tmp, cur.iter);
                q.offer(next);
                break;
            }
        }
        return result;
    }

    // 不能处理null 元素
//    @Override
//    public Integer next() {
//        Node cur = q.poll();
//        Integer result = cur.val;
//        if (cur.iter.hasNext()) {
//            Node next = new Node(cur.iter.next(), cur.iter);
//            q.offer(next);
//        }
//        return result;
//    }

    @Override
    public boolean hasNext() {
        return !q.isEmpty();
    }

    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(Arrays.asList(90, null, 100, 101));
        result.add(Arrays.asList(null, 1, 2, 3));
        result.add(Arrays.asList(40, 50, 200));

        KSortedIterator test = new KSortedIterator(result);
        while (test.hasNext()) {
            System.out.println(test.next());
        }
    }
}
