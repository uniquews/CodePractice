import java.util.*;

/**
 * Created by shuaiwang on 1/24/17.
 */
public class TopKFrequentElements {
//    class Node {
//        public int key;
//        public int times;
//
//        public Node(int key, int times) {
//            this.key = key;
//            this.times = times;
//        }
//    }
//
//    public List<Integer> topKFrequent(int[] nums, int k) {
//        HashMap<Integer, Node> hashMap = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (hashMap.containsKey(nums[i])) {
//                Node current = hashMap.get(nums[i]);
//                current.times++;
//                hashMap.put(nums[i], current);
//            } else {
//                Node current = new Node(nums[i], 1);
//                hashMap.put(nums[i], current);
//            }
//        }
//
//        PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> b.times - a.times);
//        for (int num : hashMap.keySet()) {
//            queue.add(hashMap.get(num));
//        }
//
//        List<Integer> result = new ArrayList<>();
//        while (k > 0) {
//            result.add(queue.poll().key);
//            k--;
//        }
//        return result;
//    }

    // O(n) bucket sort  bucket本身会用一个Null 的额外空间
    public List<Integer> topKFrequent(int[] nums, int k) {

        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        List<Integer> res = new ArrayList<>();

        for (int pos = bucket.length - 1; pos >= 0; pos--) {
            List<Integer> sameFreq = bucket[pos];
            if (sameFreq != null) {
                int index = 0;
                while (res.size() < k && index < sameFreq.size()) {
                    res.add(sameFreq.get(index++));
                }
            }
        }
        return res;
    }

}
