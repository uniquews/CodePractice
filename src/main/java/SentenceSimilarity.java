import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SentenceSimilarity {
    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) {
            return false;
        }

        Map<String, Set<String>> map = new HashMap<>();
        for (String[] pair : pairs) {
            String s1 = pair[0];
            String s2 = pair[1];

            Set<String> set1 = map.getOrDefault(s1, new HashSet<>());
            Set<String> set2 = map.getOrDefault(s2, new HashSet<>());

            set1.add(s2);
            set2.add(s1);

            map.put(s1, set1);
            map.put(s2, set2);
        }

        for (int i = 0; i < words1.length; i++) {
            if (words1[i].equals(words2[i])) {
                continue;
            }
            if (!(map.containsKey(words1[i]) && map.get(words1[i]).contains(words2[i]))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words1 = {"great","acting","skills"};
        String[] words2 = {"fine","drama","talent"};
        String[][] pair = {{"great","fine"},{"drama","acting"},{"skills","talent"}};

        SentenceSimilarity test = new SentenceSimilarity();
        test.areSentencesSimilar(words1, words2, pair);

    }
}
