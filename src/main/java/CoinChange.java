import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CoinChange {
//    public int coinChange(int[] coins, int amount) {
//        if (coins == null || coins.length == 0) {
//            return 0;
//        }
//        int[] f = new int[amount + 1];
//        Arrays.fill(f, Integer.MAX_VALUE);
//        f[0] = 0;
//        for (int i = 1; i <= amount; i++) {
//            for (int j = 0; j < coins.length; j++) {
//                if (i - coins[j] >= 0 && f[i - coins[j]] != Integer.MAX_VALUE) {
//                    f[i] = Math.min(f[i], f[i - coins[j]] + 1);
//                }
//            }
//        }
//        return f[amount] == Integer.MAX_VALUE ? -1 : f[amount];
//    }
    Map<Integer, Integer> map = new HashMap<>();
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return 0;
        }

        if (amount == 0) {
            return 0;
        }

        if (map.containsKey(amount)) {
            return map.get(amount);
        }

        int count = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            if (amount - coins[i] >= 0) {
                int tmp = coinChange(coins, amount - coins[i]);
                if (tmp == -1) {
                    continue;
                }
                count = Math.min(count, tmp);
            }
        }

        if (count == Integer.MAX_VALUE)
            map.put(amount, -1);
        else {
            map.put(amount, count + 1);
        }
        return map.get(amount);
    }
}
