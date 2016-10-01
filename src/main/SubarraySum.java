package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;

/**
 * Created by shuaiwang on 9/30/16.
 */

//{-3,1,2,-3,4};
public class SubarraySum {
    public ArrayList<Integer> subarraySum(int[] nums) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        Hashtable<Integer, Integer> hashTable = new Hashtable<>();

        hashTable.put(0, -1);

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (hashTable.containsKey(sum)) {
                result.add(hashTable.get(sum) + 1);
                result.add(i);
                return result;
            }
            hashTable.put(sum, i);
        }
        return result;
    }
}
