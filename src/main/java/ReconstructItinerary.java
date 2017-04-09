import java.util.*;

/**
 * Created by shuaiwang on 4/5/17.
 */
public class ReconstructItinerary {
    public List<String> findItinerary(String[][] tickets) {
        HashMap<String, PriorityQueue<String>> hashMap = new HashMap<>();
        preprocess(tickets, hashMap);
        List<String> result = new ArrayList<>();
        helper(hashMap, result, "JFK");
        return result;
    }

    private void preprocess(String[][] tickets, HashMap<String, PriorityQueue<String>> hashMap) {
        for (int i = 0; i < tickets.length; i++) {
            String start = tickets[i][0];
            String end = tickets[i][1];
            if (hashMap.containsKey(start)) {
                hashMap.get(start).add(end);
            } else {
                hashMap.put(start, new PriorityQueue<>(Arrays.asList(end)));
            }
        }
        return;
    }

    private void helper(HashMap<String, PriorityQueue<String>> hashMap, List<String> result, String source) {
        while (hashMap.containsKey(source) && !hashMap.get(source).isEmpty()) {
            helper(hashMap, result, hashMap.get(source).poll());
        }
        result.add(0, source);
    }
}
