package main;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Created by shuaiwang on 10/30/16.
 */
public class TopKFrequentWords {
    private class Pair {
        public int value;
        public String key;

        public Pair(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Comparator<Pair> pairComparator = (left, right) -> {
        if (left.value != right.value) {
            return left.value - right.value;
        }
        return right.key.compareTo(left.key);
    };

    public String[] topKFrequentWords(String[] words, int k) {
        // Write your code here
        if (k == 0 || words == null || words.length == 0) {
            return new String[0];
        }

        HashMap<String, Integer> hs = new HashMap<>();
        for (String word : words) {
            if (hs.containsKey(word)) {
                hs.put(word, hs.get(word) + 1);
            } else {
                hs.put(word, 1);
            }
        }

        PriorityQueue<Pair> queue = new PriorityQueue<>(k, pairComparator);
        for (String word : hs.keySet()) {
            Pair newPair = new Pair(word, hs.get(word));
            if (queue.size() < k) {
                queue.add(newPair);
            } else {
                Pair smallest = queue.peek();
                if (pairComparator.compare(smallest, newPair) < 0) {
                    queue.poll();
                    queue.add(newPair);
                }
            }
        }

        String[] result = new String[k];
        int index = 0;
        while (!queue.isEmpty()) {
            result[index++] = queue.poll().key;
        }

        for (int i = 0; i < index / 2; i++) {
            String tmp = result[i];
            result[i] = result[index - 1 - i];
            result[index - 1 - i] = tmp;
        }
        return result;
    }
}
