import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by shuaiwang on 4/29/17.
 */
public class LongestWordInDictionaryThroughDeleting {
    public String findLongestWord(String s, List<String> d) {
        Collections.sort(d, (o1, o2) -> {
            if (o1.length() > o2.length()) {
                return -1;
            } else if (o1.length() < o2.length()) {
                return 1;
            } else {
                int i = 0, j = 0;
                while (i < o1.length()) {
                    if (o1.charAt(i) < o2.charAt(j)) {
                        return -1;
                    } else if (o1.charAt(i) > o2.charAt(j)) {
                        return 1;
                    } else {
                        i++;
                        j++;
                    }
                }
                return 0;
            }
        });

        for (String str : d) {
            int j = 0;
            int i = 0;
            int satisfied = 0;
            for (; i < str.length(); i++) {
                while (j < s.length() && s.charAt(j) != str.charAt(i)) {
                    j++;
                }

                if (j < s.length() && s.charAt(j) == str.charAt(i)) {
                    j++;
                    satisfied++;
                }

            }
            if (satisfied == str.length()) {
                return str;
            }
        }
        return "";
    }
}
