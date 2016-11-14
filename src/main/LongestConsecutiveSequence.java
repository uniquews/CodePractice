package main;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by shuaiwang on 10/31/16.
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] num) {
        // write you code here
        HashSet<Integer> hs = new HashSet<>();
        for (int elem : num) {
            hs.add(elem);
        }

        int longest = 0;
        for (int i = 0; i < num.length; i++) {
            int prev = num[i] - 1;

            int currentLen= 1;
            while (hs.contains(prev)) {
                hs.remove(prev);
                prev--;
                currentLen++;

            }

            int next = num[i] + 1;
            while (hs.contains(next)) {
                hs.remove(next);
                next++;
                currentLen += 1;
            }
            longest = Math.max(longest, currentLen);
        }

        return longest;
    }
}
