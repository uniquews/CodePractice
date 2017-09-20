import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by shuaiwang on 2/20/17.
 */


/**
 *
 * HashMap<Integer, HashSet<Integer>> means
 * for stone i, there is a set of ways(steps) from former stones to reach it. The set size will be 2 at most,
 * since it could only be from stone - k, stone - (k - 1) and stone - (k + 1)
 *
 * hashMap.get(0) means there is 0 zero way to get to stone 0. This is just a initialization.
 *
 * We get current stone from int[] stone. Standing on stone i, we already know how many steps we takes to get here,.
 * which are stored in set as k.
 *
 * For next movement, we can take k, k - 1 or k + 1. If the movement can take us to aa valid stone, then we update
 * that stone with current step (either k, k - 1 or k + 1). Make sure that k - 1 will always be positive number.
 *
 * Finally, we can examine if the last stone has any steps(ways) in its sets? If so, that means there is a way
 * to reach out to last stone.
 *
 * We dont need to calculate if there is a way starting from last stone move to any other stones because we are already
 * at the end and can only move forward.
 * */
public class FrogJump {
//    public boolean canCross(int[] stones) {
//        // Write your code here
//        HashMap<Integer, HashSet<Integer>> hs = new HashMap<>();
//        for (int i = 0; i < stones.length; i++) {
//            hs.put(stones[i], new HashSet<Integer>());
//        }
//
//        hs.get(0).add(0);
//        for (int i = 0; i < stones.length - 1; i++) {
//            int currentStone = stones[i];
//            for (int k : hs.get(currentStone)) {
//                if (hs.containsKey(currentStone + k - 1) && k - 1 > 1) { //  have to move step larger than 0
//                    hs.get(currentStone + k - 1).add(k - 1);
//                }
//
//                if (hs.containsKey(currentStone + k)) {
//                    hs.get(currentStone + k).add(k);
//                }
//
//                if (hs.containsKey(currentStone + k + 1)) {
//                    hs.get(currentStone + k + 1).add(k + 1);
//                }
//            }
//        }
//        return !hs.get(stones[stones.length - 1]).isEmpty();
//    }

    public boolean canCross(int[] stones) {
        // write your code here
        if (stones == null || stones.length == 0)
            return false;

        if (stones.length == 1)
            return true;

        Map<Integer, Set<Integer>> map = new HashMap<>();
        map.put(0, new HashSet<>());
        map.get(0).add(0);

        boolean[] f = new boolean[stones.length];
        f[0] = true;

        for (int i = 1; i < stones.length; i++) {
            map.put(i, new HashSet<>());
            for (int j = 0; j < i ; j++) {
                if (f[j] == false)
                    continue;
                Set<Integer> steps = map.get(j);
                for (Integer s : steps) {
                    if (s > 0 && stones[j] + s == stones[i]) { // s > 0 用于i == 1的情况
                        f[i] = true;
                        map.get(i).add(s);
                    }

                    if (s > 0 && stones[j] + s - 1 == stones[i]) {
                        f[i] = true;
                        map.get(i).add(s - 1);
                    }

                    if (s + 1 > 0 && stones[j] + s + 1 == stones[i]) {
                        f[i] = true;
                        map.get(i).add(s + 1);
                    }
                }
            }
        }
        return f[stones.length - 1];
    }

    public static void main(String[] args) {
        int[] s = {0,1,3,5,6,8,12,17};
        FrogJump test = new FrogJump();
        test.canCross(s);
    }
}
