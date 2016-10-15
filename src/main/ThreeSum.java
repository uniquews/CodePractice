package main;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by shuaiwang on 10/14/16.
 */
public class ThreeSum {
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (numbers == null || numbers.length == 0) {
            return result;
        }

        Arrays.sort(numbers);
        int first = 0;
        while (first < numbers.length - 2) {
            ArrayList<Integer> eachResult = new ArrayList<>();
            eachResult.add(numbers[first]);
            int minusFirst = 0 - numbers[first];
            twoSum(numbers, result, eachResult, first + 1, minusFirst);
            eachResult.remove(eachResult.size() - 1);
            while (first + 1 < numbers.length - 3 && numbers[first] == numbers[first + 1]) {
                first++;
            }
            first++;
        }
        return result;
    }

    private void twoSum(int[] numbers, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> eachResult, int position, int target) {
        int first = position;
        while (first < numbers.length - 1) {
            eachResult.add(numbers[first]);
            int second = first + 1;
            int minusFirst = target - numbers[first];
            while (second < numbers.length) {
                eachResult.add(numbers[second]);
                if (minusFirst == numbers[second]) {
                    result.add(new ArrayList<>(eachResult));
                }
                eachResult.remove(eachResult.size() - 1);
                while (second + 1 < numbers.length && numbers[second] == numbers[second + 1]) {
                    second++;
                }
                second++;
            }
            eachResult.remove(eachResult.size() - 1);
            while (first + 1 < numbers.length - 1 && numbers[first] == numbers[first + 1]) {
                first++;
            }
            first++;
        }
    }
}
