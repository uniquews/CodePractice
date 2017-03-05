import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by shuaiwang on 3/2/17.
 */
public class UniqueWordAbbreviation {
    HashMap<String, HashSet<String>> hashMap = new HashMap<>();
    public UniqueWordAbbreviation(String[] dictionary) {
        for (int i = 0; i < dictionary.length; i++) {
            if (dictionary[i].length() <= 2) {
                if (!hashMap.containsKey(dictionary[i])) {
                    hashMap.put(dictionary[i], new HashSet<>(Arrays.asList(dictionary[i])));
                } else {
                    hashMap.get(dictionary[i]).add(dictionary[i]);
                }
            } else {
                if (!hashMap.containsKey(abbreviate(dictionary[i]))) {
                    hashMap.put(abbreviate(dictionary[i]), new HashSet<>(Arrays.asList(dictionary[i])));
                } else {
                    hashMap.get(abbreviate(dictionary[i])).add(dictionary[i]);
                }
            }
        }
    }

    public boolean isUnique(String word) {
        String origin = new String(word);
        if (word.length() > 2) {
            word = abbreviate(word);
        }
        if (!hashMap.containsKey(word)) {
            return true;
        }

        if (hashMap.get(word).size() > 1) {
            return false;
        }

        return hashMap.get(word).contains(origin);
    }

    private String abbreviate(String word) {
        if (word.length() == 0)
            return word;
        int size = word.length() - 2;
        return String.join("", word.substring(0, 1), String.valueOf(size),
                word.substring(word.length() - 1, word.length()));
    }


}
