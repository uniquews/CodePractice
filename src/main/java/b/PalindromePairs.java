package b;

import java.util.*;

public class PalindromePairs {
    public List<List<Integer>> palindromePairs(String[] words) {
        Map<String, Integer> wordIndexMap = new HashMap<>(words.length);
        for (int i = 0; i < words.length; i++) {
            wordIndexMap.put(words[i], i);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            String reversedWord = reverseOfString(word);
            // s1 = "", s2 is a Palindrome
            if (wordIndexMap.containsKey("") && isPalindrome(word) && i != wordIndexMap.get("")) {
                res.add(Arrays.asList(wordIndexMap.get(""), i));
                res.add(Arrays.asList(i, wordIndexMap.get("")));
            }
            // s1 is reverse of s2
            if (wordIndexMap.containsKey(reversedWord) && wordIndexMap.get(reversedWord) != i) {
                res.add(Arrays.asList(wordIndexMap.get(reversedWord), i));
            }
            for (int k = 1; k < word.length(); k++) {
                String a = word.substring(0, k);
                String b = word.substring(k);
                // s1[0, k] is a palindrome, s1[k] is the reverse of s2, append s1 after s2
                if (isPalindrome(a)) {
                    String reverseB = reverseOfString(b);
                    if (wordIndexMap.containsKey(reverseB)) {
                        res.add(Arrays.asList(wordIndexMap.get(reverseB), i));
                    }
                }
                // s1[k] is a palindrome and s1[0, k] is the reverse of s2, append s2 after s1
                if (isPalindrome(b)) {
                    String reverseA = reverseOfString(a);
                    if (wordIndexMap.containsKey(reverseA)) {
                        res.add(Arrays.asList(i, wordIndexMap.get(reverseA)));
                    }
                }
            }

        }
        return res;
    }

    private String reverseOfString(String s1) {
        StringBuilder sb = new StringBuilder(s1);
        return sb.reverse().toString();
    }

    private boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;
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
