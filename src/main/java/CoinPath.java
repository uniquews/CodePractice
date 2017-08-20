import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by shuaiwang on 8/15/17.
 */
public class CoinPath {
    public List<Integer> cheapestJump(int[] A, int B) {
        HashMap<Integer, Long> cache = new HashMap<>();
        int[] path = new int[A.length];
        Arrays.fill(path, -1);

        dfs(A, B, 0, path, cache);

        int i = 0;
        List<Integer> result = new ArrayList<>();

        if (path[i] == -1)
            return result;
        while (i != A.length) {
            result.add(i + 1);
            i = path[i];
        }
        return result;
    }

    private long dfs(int[] A, int B, int index, int[] path, HashMap<Integer, Long> cache) {
        if (index == A.length - 1) {
            path[index] = A.length;
            return A[A.length - 1];
        }

        if (cache.containsKey(index))
            return cache.get(index);

        long cost = Integer.MAX_VALUE;
        for (int i = 1; i <= B; i++) {
            int next = index + i;
            if (next >= A.length || A[next] == -1) {
                continue;
            }

            long tmp = A[index] + dfs(A, B, next, path, cache);
            if (tmp < cost) {
                cost = tmp;
                path[index] = next;
            }
        }
        cache.put(index, cost);
        return cost;
    }

    public static void main(String[] args) {
        int[] A = {1,2,4,-1,2};
        int B = 1;
        CoinPath co = new CoinPath();
        List<Integer> l = co.cheapestJump(A, B);
        for (int i = 0; i < l.size(); i++) {
            System.out.print(l.get(i) + " ");
        }
    }
}
