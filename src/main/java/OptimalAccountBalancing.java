import java.util.*;

/**
 * Created by shuaiwang on 3/12/17.
 */
public class OptimalAccountBalancing {
//    public int minTransfers(int[][] transactions) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//
//        for (int i = 0; i < transactions.length; i++) {
//            int begin = transactions[i][0];
//            int end = transactions[i][1];
//            int money = transactions[i][2];
//
//            if (!map.containsKey(begin)) {
//                map.put(begin, (-1) * money);
//            } else {
//                map.put(begin, map.get(begin) - money);
//            }
//
//            if (!map.containsKey(end)) {
//                map.put(end, money);
//            } else {
//                map.put(end, map.get(end) + money);
//            }
//        }
//
//        int[] account = new int[map.values().size()];
//        int i = 0;
//        for (Integer value : map.values()) {
//            account[i] = value;
//            i++;
//        }
//
//        return dfs(account, 0, 0);
//    }
//
//    private int dfs(int[] account, int current, int numOfTransaction) {
//        int result = Integer.MAX_VALUE;
//        while (current < account.length && account[current] == 0) {
//            current++;
//        }
//
//        // give money out from current to other indices
//        for (int i = current + 1; i < account.length; i++) {
//            if ((account[current] > 0 && account[i] < 0) ||
//                    (account[current] < 0 && account[i] > 0)) {
//                account[i] += account[current]; // 此时account[current] = 0, 只是不 explicitly更新
//                result = Math.min(result, dfs(account, current + 1, numOfTransaction + 1));
//                account[i] -= account[current];
//            }
//        }
//
//        return result == Integer.MAX_VALUE ? numOfTransaction : result;
//    }

    public int result = Integer.MAX_VALUE;
    public int minTransfers(int[][] transactions) {
        if (transactions == null || transactions.length == 0 || transactions[0] == null || transactions[0].length == 0)
            return 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < transactions.length; i++) {
            int p1 = transactions[i][0];
            int p2 = transactions[i][1];
            int money = transactions[i][2];
            map.put(p1, map.getOrDefault(p1, 0) - money);
            map.put(p2, map.getOrDefault(p2, 0) + money);
        }

        int[] debts = new int[map.size()];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            debts[i] = entry.getValue();
            i++;
        }
        dfs(debts, 0, 0);
        return result;
    }

    private void dfs(int[] debts, int current, int count) {
        boolean allClear = true;
        for (int i = 0; i < debts.length; i++) {
            if (debts[i] == 0 || current == i) {
                continue;
            } else {
                allClear = false;
                int money = debts[current];
                if ((money ^ debts[i]) >= 0) {
                    continue;
                }

                debts[current] -= money;
                debts[i] += money;
                if (money == 0)
                    dfs(debts, i, count);
                else
                    dfs(debts, i, count + 1);

                debts[current] += money;
                debts[i] -= money;
            }
        }

        if (allClear)
            result = Math.min(result, count);
    }

    public static void main(String[] args) {
//        int[][] transaction = {{2,0,5},{3,4,4}};
        // [[1,5,8],[8,9,8],[2,3,9],[4,3,1]]
        int[][] transaction = {{1,5,8},{8,9,8},{2,3,9},{4,3,1}};
        OptimalAccountBalancing test = new OptimalAccountBalancing();
        System.out.print(test.minTransfers(transaction));
    }
}
