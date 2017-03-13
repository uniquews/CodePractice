import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by shuaiwang on 3/12/17.
 */
public class OptimalAccountBalancing {
    public int minTransfers(int[][] transactions) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < transactions.length; i++) {
            int begin = transactions[i][0];
            int end = transactions[i][1];
            int money = transactions[i][2];

            if (!map.containsKey(begin)) {
                map.put(begin, (-1) * money);
            } else {
                map.put(begin, map.get(begin) - money);
            }

            if (!map.containsKey(end)) {
                map.put(end, money);
            } else {
                map.put(end, map.get(end) + money);
            }
        }

        int[] account = new int[map.values().size()];
        int i = 0;
        for (Integer value : map.values()) {
            account[i] = value;
            i++;
        }

        return dfs(account, 0, 0);
    }

    private int dfs(int[] account, int current, int numOfTransaction) {
        int result = Integer.MAX_VALUE;
        while (current < account.length && account[current] == 0) {
            current++;
        }

        // give money out from current to other indices
        for (int i = current + 1; i < account.length; i++) {
            if ((account[current] > 0 && account[i] < 0) ||
                    (account[current] < 0 && account[i] > 0)) {
                account[i] += account[current]; // 此时account[current] = 0, 只是不 explicitly更新
                result = Math.min(result, dfs(account, current + 1, numOfTransaction + 1));
                account[i] -= account[current];
            }
        }

        return result == Integer.MAX_VALUE ? numOfTransaction : result;
    }

    public static void main(String[] args) {
        int[][] transaction = {{0,1,10},{2,0,5}};
        OptimalAccountBalancing test = new OptimalAccountBalancing();
        test.minTransfers(transaction);
    }
}
