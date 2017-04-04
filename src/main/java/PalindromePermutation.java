import java.util.HashMap;

/**
 * Created by shuaiwang on 4/3/17.
 */
public class PalindromePermutation {
    public boolean canPermutePalindrome(String s) {
        int size = s.length();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (hashMap.containsKey(s.charAt(i))) {
                hashMap.put(s.charAt(i), hashMap.get(s.charAt(i)) + 1);
            } else {
                hashMap.put(s.charAt(i), 1);
            }
        }
        if (size % 2 == 0) {
            for (Integer times : hashMap.values()) {
                if (times % 2 != 0) {
                    return false;
                }
            }
            return true;
        } else {
            boolean alreadyOdd = false;
            for (Integer times : hashMap.values()) {
                if (times % 2 != 0 && !alreadyOdd) {
                    alreadyOdd = true;
                } else if (times % 2 != 0 && alreadyOdd) {
                    return false;
                }
            }
            return true;
        }
    }
}
