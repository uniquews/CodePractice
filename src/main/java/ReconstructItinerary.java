import java.util.*;

/**
 * Created by shuaiwang on 4/5/17.
 */
public class ReconstructItinerary {
//    public List<String> findItinerary(String[][] tickets) {
//        HashMap<String, PriorityQueue<String>> hashMap = new HashMap<>();
//        preprocess(tickets, hashMap);
//        List<String> result = new ArrayList<>();
//        helper(hashMap, result, "JFK");
//        return result;
//    }
//
//    private void preprocess(String[][] tickets, HashMap<String, PriorityQueue<String>> hashMap) {
//        for (int i = 0; i < tickets.length; i++) {
//            String start = tickets[i][0];
//            String end = tickets[i][1];
//            if (hashMap.containsKey(start)) {
//                hashMap.get(start).add(end);
//            } else {
//                hashMap.put(start, new PriorityQueue<>(Arrays.asList(end)));
//            }
//        }
//        return;
//    }
//
//    private void helper(HashMap<String, PriorityQueue<String>> hashMap, List<String> result, String source) {
//        while (hashMap.containsKey(source) && !hashMap.get(source).isEmpty()) {
//            helper(hashMap, result, hashMap.get(source).poll());
//        }
//        result.add(0, source);
//    }


    // 有可能有重复的票，所以set里面要存index
    public List<String> findItinerary(String[][] tickets) {
        List<String> result = new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();
        Map<String, Set<Integer>> visited = new HashMap<>();

        preprocess(tickets, map, visited);
        dfs(map, visited, result, "JFK", tickets.length);
        return result;
    }

    private void preprocess(String[][] tickets, Map<String, List<String>> map, Map<String, Set<Integer>> visited ) {
        for (int i = 0; i < tickets.length; i++) {
            String from = tickets[i][0];
            String to = tickets[i][1];

            List pq = map.getOrDefault(from, new ArrayList<>());
            pq.add(to);
            map.put(from, pq);
        }

        for (String k : map.keySet()) {
            List<String> l = map.get(k);
            Collections.sort(l);

            visited.put(k, new HashSet<>());
        }
    }

    private boolean dfs(Map<String, List<String>> map, Map<String, Set<Integer>> visited , List<String> result, String current, int numOfTicket) {
        result.add(current);

        if (result.size() == numOfTicket + 1)
            return true;

        if (map.containsKey(current)) {
            List<String> next = map.get(current);
            for (int i = 0; i < next.size(); i++) {
                String n = next.get(i);
                if (visited.get(current).contains(i))
                    continue;
                visited.get(current).add(i);
                boolean isValid = dfs(map, visited, result, n, numOfTicket);
                if (isValid) {
                    return true;
                }
                visited.get(current).remove(i);
            }
        }

        result.remove(result.size() - 1);
        return false;
    }


    //[["JFK","KUL"],["JFK","NRT"],["NRT","JFK"]]

    // [["EZE","AXA"],["TIA","ANU"],["ANU","JFK"],["JFK","ANU"],["ANU","EZE"],["TIA","ANU"],["AXA","TIA"],["TIA","JFK"],["ANU","TIA"],["JFK","TIA"]]
    public static void main(String[] args) {
//        String[][] tickets = new String[][] {{"JFK","SFO"}, {"JFK","ATL"}, {"SFO","ATL"}, {"ATL","JFK"}, {"ATL","SFO"}};
//        String[][] tickets = new String[][] {{"JFK","KUL"}, {"JFK","NRT"}, {"NRT","JFK"}};
        String[][] tickets = new String[][] {{"EZE","AXA"},{"TIA","ANU"},{"ANU","JFK"},{"JFK","ANU"},{"ANU","EZE"},{"TIA","ANU"},{"AXA","TIA"},{"TIA","JFK"},{"ANU","TIA"},{"JFK","TIA"}};
        ReconstructItinerary test = new ReconstructItinerary();
        test.findItinerary(tickets);
    }
}
