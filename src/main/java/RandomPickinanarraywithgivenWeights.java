import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomPickinanarraywithgivenWeights {
    int[] weights;
    String[] strs;
    Random rand;
    public RandomPickinanarraywithgivenWeights(Map<String, Integer> map) {
        weights = new int[map.keySet().size()];
        strs = new String[map.keySet().size()];
        rand = new Random();

        int sum = 0;
        int index = 0;
        for (String s : map.keySet()) {
            sum += map.get(s);
            weights[index] = sum - 1;
            strs[index] = s;
            index++;
        }
    }

    public String getString() {
        int target = rand.nextInt(weights[weights.length - 1] + 1);
        int start = 0;
        int end = weights.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (weights[mid] == target) {
                return strs[mid];
            } else if (weights[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (weights[start] >= target) {
            return strs[start];
        } else {
            return strs[end];
        }
    }

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 4);
        map.put("orange", 2);
        map.put("lemon", 1);

        RandomPickinanarraywithgivenWeights test = new RandomPickinanarraywithgivenWeights(map);
        test.getString();
    }
}
