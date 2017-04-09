import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by shuaiwang on 4/8/17.
 */
public class PalindromePairs {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i< words.length; i++) {
            hashMap.put(words[i], i);
        }

        // s1 = "", s2 is a Palindrome
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals("")) {
                for (int j = 0; j < words.length; j++) {
                    if (i != j && isPalindrome(words[j])) {
                        result.add(new ArrayList<>(Arrays.asList(i, j)));
                        result.add(new ArrayList<>(Arrays.asList(j, i)));
                    }
                }
            }
        }

        // s1 is reverse of s2
        for (int i = 0; i < words.length; i++) {
            String reverseOfS1 = reverseOfString(words[i]);
            if (hashMap.containsKey(reverseOfS1) && hashMap.get(reverseOfS1) != i) {
                result.add(new ArrayList<>(Arrays.asList(i, hashMap.get(reverseOfS1))));
            }
        }

        // s1[0, k] is a palindrome, s1[k] is the reverse of s2, append s1 after s2
        for (int i = 0; i < words.length; i++) {
            for (int k = 0; k < words[i].length() - 1; k++) {
                String left = words[i].substring(0, k + 1);
                String right = words[i].substring(k + 1);
                String reverseOfRight = reverseOfString(right);
                if (isPalindrome(left) && hashMap.containsKey(reverseOfRight)) {
                    result.add(new ArrayList<>(Arrays.asList(hashMap.get(reverseOfRight), i)));
                }
            }
        }

        // s1[k] is a palindrome and s1[0, k] is the reverse of s2, append s2 after s1
        for (int i = 0; i < words.length; i++) {
            for (int k = 0; k < words[i].length() - 1; k++) {
                String left = words[i].substring(0, k + 1);
                String right = words[i].substring(k + 1);
                String reverseOfLeft = reverseOfString(left);
                if (isPalindrome(right) && hashMap.containsKey(reverseOfLeft)) {
                    result.add(new ArrayList<>(Arrays.asList(i, hashMap.get(reverseOfLeft))));
                }
            }
        }
        return result;
    }

    private String reverseOfString(String s1) {
        StringBuilder sb = new StringBuilder(s1);
        return sb.reverse().toString();
    }
    private boolean isPalindrome(String s) {
        int start = 0, end = s. length() - 1;
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            } else {
                start++;
                end--;
            }
        }
        return true;
    }
}
