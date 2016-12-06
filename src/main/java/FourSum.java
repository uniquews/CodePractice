import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by shuaiwang on 10/13/16.
 */
public class FourSum {
    public ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target) {
        /* your code */
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (numbers == null || numbers.length == 0) {
            return result;
        }

        Arrays.sort(numbers);
        int first = 0;
        while (first < numbers.length - 3) {
            ArrayList<Integer> eachResult = new ArrayList<>();
            eachResult.add(numbers[first]);
            int minusFirst = target - numbers[first];
            int second = first + 1;
            while (second < numbers.length - 2) {
                eachResult.add(numbers[second]);
                int minusSecond = minusFirst - numbers[second];
                twoSum(numbers, result, eachResult, second + 1, minusSecond);
                eachResult.remove(eachResult.size() - 1);
                while (second + 1 < numbers.length - 2 && numbers[second] == numbers[second + 1]) {
                    second++;
                }
                second++;
            }
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
