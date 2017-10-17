import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(1, n, k, new ArrayList<>(), result);
        return result;
    }

    private void dfs(int index, int n, int k, List<Integer> eachResult, List<List<Integer>> result) {
        if (k == 0) {
            result.add(new ArrayList<>(eachResult));
            return;
        }

        for (int i = index; i <= n; i++) {
            eachResult.add(i);
            dfs(i + 1, n, k - 1, eachResult, result);
            eachResult.remove(eachResult.size() - 1);
        }

    }
}
