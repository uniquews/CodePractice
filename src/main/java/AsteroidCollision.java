import java.util.LinkedList;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] a) {
        LinkedList<Integer> stk = new LinkedList<>();

        for (int i = 0; i < a.length; i++) {
            if (a[i] > 0 || stk.isEmpty() || stk.peekLast() < 0) {
                stk.addLast(a[i]);
            } else {
                if (stk.peekLast() < -a[i]) {
                    stk.pollLast();
                    i--;
                } else if (stk.peekLast() == -a[i]) {
                    stk.pollLast();
                }
            }
        }
        return stk.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {
        AsteroidCollision test = new AsteroidCollision();
//        int[] a = {10, 2, -5};
//        int[] a = {-2,-2,1,-2};
//        int[] a = {5,10,-5};
//        int[] a = {-2,-2,2,-1};
        int[] a = {-2,2,1,-2};
        test.asteroidCollision(a);
    }
}
