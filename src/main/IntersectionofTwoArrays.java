package main;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by shuaiwang on 9/29/16.
 */
public class IntersectionofTwoArrays {
//    public int[] intersection(int[] nums1, int[] nums2) {
//        // Write your code here
//        HashSet hashSet = new HashSet();
//        for (int i = 0; i < nums1.length; i++) {
//            hashSet.add(nums1[i]);
//        }
//
//        HashSet<Integer> resultHash = new HashSet<Integer>();
//
//        for (int i = 0; i < nums2.length; i++) {
//            if (hashSet.contains(nums2[i]) && !resultHash.contains(nums2[i])) {
//                resultHash.add(nums2[i]);
//            }
//        }
//
//        int[] result = new int[resultHash.size()];
//        int index = 0;
//        for (Integer num : resultHash) {
//            result[index++] = num;
//        }
//        return result;
//    }

    public int[] intersection(int[] nums1, int[] nums2) {
        // Write your code here
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int []tmp = new int[nums1.length];
        int i = 0, j = 0, index = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                if (index == 0 || tmp[index - 1] != nums1[i]) {
                    tmp[index++] = nums1[i];
                    i++;
                    j++;
                } else {
                    i++;
                    j++;
                }
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        int []result = new int[index];
        int m = 0;
        for (int k = 0; k < index; k++) {
            result[m++] = tmp[k];
        }
        return result;
    }
}
