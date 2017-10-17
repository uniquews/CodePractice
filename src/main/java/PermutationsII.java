import java.util.LinkedList;
import java.util.List;

public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> eachResult = new LinkedList<>();

        result.offer(eachResult);

        for (int i = 0; i < nums.length; i++) {
            int size = result.size();
            for (int j = 0; j < size; j++) {
                List<Integer> pivot = result.poll();
                for (int k = 0; k <= pivot.size(); k++) {
                    if (k > 0 && pivot.get(k - 1) == nums[i]) {
                        break;
                    }
                    LinkedList<Integer> cur = new LinkedList<>(pivot);
                    cur.add(k, nums[i]);
                    result.offer(cur);
                }
            }
        }
        return result;
    }
}
