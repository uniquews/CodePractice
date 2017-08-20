import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by shuaiwang on 4/29/17.
 */
public class LongestWordInDictionaryThroughDeleting {
//    public String findLongestWord(String s, List<String> d) {
//        Collections.sort(d, (o1, o2) -> {
//            if (o1.length() > o2.length()) {
//                return -1;
//            } else if (o1.length() < o2.length()) {
//                return 1;
//            } else {
//                int i = 0, j = 0;
//                while (i < o1.length()) {
//                    if (o1.charAt(i) < o2.charAt(j)) {
//                        return -1;
//                    } else if (o1.charAt(i) > o2.charAt(j)) {
//                        return 1;
//                    } else {
//                        i++;
//                        j++;
//                    }
//                }
//                return 0;
//            }
//        });
//
//        for (String str : d) {
//            int j = 0;
//            int i = 0;
//            int satisfied = 0;
//            for (; i < str.length(); i++) {
//                while (j < s.length() && s.charAt(j) != str.charAt(i)) {
//                    j++;
//                }
//
//                if (j < s.length() && s.charAt(j) == str.charAt(i)) {
//                    j++;
//                    satisfied++;
//                }
//
//            }
//            if (satisfied == str.length()) {
//                return str;
//            }
//        }
//        return "";
//    }
    public String findLongestWord(String s, List<String> d) {
        Collections.sort(d, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() != o2.length()) {
                    return o2.length() - o1.length();
                } else {
                    int i = 0;
                    while (i < o1.length()) {
                        if (o1.charAt(i) < o2.charAt(i)) {
                            return -1;
                        } else if (o1.charAt(i) > o2.charAt(i)) {
                            return 1;
                        }
                        i++;
                    }
                }
                return 0;
            }
        });

        for (String str : d) {
            int i = 0, j = 0;
            while (i < s.length() && j < str.length()) {
                if (s.charAt(i) == str.charAt(j)) {
                    j++;
                }
                i++;
            }
            if (j == str.length()) {
                return str;
            }
        }
        return "";
    }
}
