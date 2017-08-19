import java.util.*;

/**
 * Created by shuaiwang on 4/18/17.
 */

/***
 *
 *
 * 思路： An ugly number must be multiplied by either 2, 3, or 5 from a smaller ugly number.
 *
 * 最先的ugly number 是1
 *
 * 那么作为factor 2, 7, 13
 *
 * heap =
 * (2,1,2)
 * (7,1,7)
 * (13,1,13)
 *
 * peek 2
 * ugly = {1,2} // 1是最开始加的
 *
 * 利用Num (2,1,2)计算下一个进入heap的值  index = 1表示对于factor 2 我们需要看的smaller ugly number在ugly数组的index = 1的位置，
 * 也就是新加进来的 2， 进而heap变成:
 *
 *（4,2,2）
 * (7,1,7)
 * (13,1,13)
 *
 *
 * index
 * 也可以这么理解
 * ugly 数组里表示的是按照从小到大的顺序的ugly number。对于每一个factor，哪些数字还没有乘过自己。
 *
 *
 * 比如在ugly number II中
 *
 */

public class SuperUglyNumber {

//    class Num {
//        public int value; // 当前value
//        public int index; // 求下一个value，需要用prime * 所对应的上一个ugly number，这个index存的是上一个ugly number的index
//        public int prime; // factor
//
//        public Num(int v, int i, int p) {
//            value = v;
//            index = i;
//            prime = p;
//        }
//    }
//    public int nthSuperUglyNumber(int n, int[] primes) {
//        PriorityQueue<Num> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a.value));
//        for (int i = 0; i < primes.length; i++) {
//            Num current = new Num(primes[i], 1, primes[i]); // 1 * 2, 1 * 7, 1 * 13, 1 * 19先放进heap，
//            heap.add(current);
//        }
//
//        List<Integer> ugly = new ArrayList<>();
//        ugly.add(1);
//
//        while (n > 1) {
//            Num current = heap.peek();
//            ugly.add(current.value);
//
//            while (!heap.isEmpty() && heap.peek().value == current.value) {
//                Num sameValue = heap.poll();
//                Num nextForSameValue = new Num(sameValue.prime * ugly.get(sameValue.index), sameValue.index + 1, sameValue.prime);
//                heap.add(nextForSameValue);
//            }
//            n--;
//        }
//        return ugly.get(ugly.size() - 1);
//    }

    class Node {
        public int prime;
        public int index;
        public int value;
        public Node(int p, int i, int v) {
            prime = p;
            index = i;
            value = v;
        }
    }
    public int nthSuperUglyNumber(int n, int[] primes) {
        Queue<Node> heap = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.value - o2.value;
            }
        });
        for (int i = 0; i < primes.length; i++) {
            Node node = new Node(primes[i], 1, primes[i]);
            heap.add(node);
        }

        List<Integer> ugly = new ArrayList<>();
        ugly.add(1);
        n--;

        while (n != 0) {
            Node current = heap.peek();
            ugly.add(current.value);

            while (!heap.isEmpty() && heap.peek().value == current.value) {
                heap.add(new Node(heap.peek().prime, heap.peek().index + 1, heap.peek().prime * ugly.get(heap.peek().index)));
                heap.poll();
            }
            n--;
        }

        return ugly.get(ugly.size() - 1);
    }



    public static void main(String[] args) {
        int n = 7;
        int[] a = {2,3,5};
        SuperUglyNumber test = new SuperUglyNumber();
        System.out.print(test.nthSuperUglyNumber(n, a));
    }

}
