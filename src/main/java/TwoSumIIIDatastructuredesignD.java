import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by shuaiwang on 2/9/17.
 */
public class TwoSumIIIDatastructuredesignD {
    // Add the number to an internal data structure.

    private HashMap<Integer, Integer> hs = new HashMap<>();

    public void add(int number) {
        // Write your code here
        if (hs.containsKey(number)) {
            hs.put(number, hs.get(number) + 1);
        } else {
            hs.put(number, 1);
        }
    }

    // Find if there exists any pair of numbers which sum is equal to the value.
    public boolean find(int value) {
        // Write your code here
        for (int k : hs.keySet()) {
            int tmp = value - k;
            if (!hs.containsKey(tmp)) {
                continue;
            }
            if (tmp == k && hs.get(k) == 1) {
                return false;
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        TwoSumIIIDatastructuredesignD test = new TwoSumIIIDatastructuredesignD();
        test.add(-12);
        test.add(25);
        test.add(-20);
        test.add(-22);
        test.add(12);
        test.add(-39);
        test.add(11);
        test.add(-15);
        test.add(25);
        test.add(47);
        test.add(-24);
        test.add(18);
        test.add(21);
        test.add(-21);
        test.add(32);
        test.add(-11);
        test.add(-35);
        test.add(37);
        test.add(-8);
        test.add(-18);
        test.add(42);
        test.add(17);
        test.add(16);
        test.add(-46);
        test.add(-27);
        test.add(-34);
        test.add(43);
        test.add(31);
        test.add(-13);
        test.add(44);
        test.add(-6);
        test.add(10);
        test.add(19);
        test.add(12);
        test.add(-11);
        test.add(-12);
        test.add(-25);
        test.add(-39);
        test.add(40);
        test.add(36);
        test.add(-19);
        test.add(-43);
        test.add(12);
        test.add(42);
        test.add(-39);
        test.add(3);
        test.add(-33);
        test.add(-5);
        test.add(0);
        test.add(48);
        test.add(-34);
        test.add(-41);
        test.add(-18);
        test.add(16);
        test.add(43);
        test.add(43);
        test.add(21);
        test.add(-1);
        test.add(-7);
        test.add(7);
        test.add(-13);
        test.add(26);
        test.add(17);
        test.add(-33);
        test.add(-47);
        test.add(23);
        test.add(-7);
        test.add(38);
        test.add(-4);
        test.add(-29);
        test.add(-40);
        test.add(-11);
        test.add(-6);
        test.add(-34);
        test.add(-32);
        test.add(46);
        test.add(25);
        test.add(-6);
        test.add(22);
        test.add(0);
        test.add(-45);
        test.add(-20);
        test.add(-36);
        test.add(3);
        test.add(-46);
        test.add(39);
        test.add(15);
        test.add(19);
        test.add(28);
        test.add(0);
        test.add(29);
        test.add(9);
        test.add(34);
        test.add(22);
        test.add(-8);
        test.add(1);
        test.add(-28);
        test.add(0);
        test.add(40);
        test.add(47);
//        System.out.print(test.find(-20));
//        System.out.print(test.find(20));
//        System.out.print(test.find(3));
//        System.out.print(test.find(-42));
//        System.out.print(test.find(14));
//        System.out.print(test.find(-1));
//        System.out.print(test.find(-38));
//        System.out.print(test.find(31));
//        System.out.print(test.find(40));
//        System.out.print(test.find(-31));
//        System.out.print(test.find(-26));
//        System.out.print(test.find(41));
//        System.out.print(test.find(16));
//        System.out.print(test.find(-30));
//        System.out.print(test.find(-20));
//        System.out.print(test.find(24));
//        System.out.print(test.find(2));
//        System.out.print(test.find(8));
//        System.out.print(test.find(32));
//        System.out.print(test.find(42));
        System.out.print(test.find(2));
    }

}
