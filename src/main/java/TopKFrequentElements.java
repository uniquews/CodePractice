import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by shuaiwang on 1/24/17.
 */
public class TopKFrequentElements {
    class Node {
        public int key;
        public int times;

        public Node(int key, int times) {
            this.key = key;
            this.times = times;
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Node> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                Node current = hashMap.get(nums[i]);
                current.times++;
                hashMap.put(nums[i], current);
            } else {
                Node current = new Node(nums[i], 1);
                hashMap.put(nums[i], current);
            }
        }

        PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> b.times - a.times);
        for (int num : hashMap.keySet()) {
            queue.add(hashMap.get(num));
        }

        List<Integer> result = new ArrayList<>();
        while (k > 0) {
            result.add(queue.poll().key);
            k--;
        }
        return result;
    }
}
