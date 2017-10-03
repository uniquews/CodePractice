package fb;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuaiwang on 9/10/17.
 */
public class SumOfTwoNumbersWithOneDigitDifference {

    public List<int[]> sumOfTwoDigits(int sum) {
        List<int[]> result = new ArrayList<>();
        int totalDigits = String.valueOf(sum).length();
        if (totalDigits < 2) {
            return result;
        }

        int[] setOne = getRange(totalDigits);
        int[] setTwo = getRange(totalDigits - 1);

        helper(setOne[0], setOne[1], sum, result);
        if (totalDigits > 2)
            helper(setTwo[0], setTwo[1], sum, result);
        return result;
    }

    private int[] getRange(int n) {
        int[] result = new int[2];
        int num = 1;
        while (n > 1) {
            num *= 10;
            n--;
        }

        result[0] = num;
        result[1] = num * 10 - 1;
        return result;
    }

    private void helper(int start, int end, int sum, List<int[]> result) {
        if (start >= sum)
            return;
        for (int i = start; i <= end; i++) {
            List<Integer> l = getNumbers(i);
            for (int j = 0; j < l.size(); j++) {
                if (i + l.get(j) == sum) {
                    result.add(new int[]{i, l.get(j)});
                }
            }
        }
    }

    private List<Integer> getNumbers(int n) {
        List<Integer> result = new ArrayList<>();
        String s = String.valueOf(n);
        for (int i = 0; i < s.length(); i++) {
            String next = s.substring(0, i) + s.substring(i + 1);
            if (String.valueOf(Integer.valueOf(next)).length() != s.length() - 1)
                continue;
            result.add(Integer.valueOf(next));
        }
        return result;
    }

    public static void main(String[] args) {
        int sum = 9888;
        SumOfTwoNumbersWithOneDigitDifference test = new SumOfTwoNumbersWithOneDigitDifference();
        List<int[]> result = test.sumOfTwoDigits(sum);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i)[0] + " " + result.get(i)[1]);
        }

    }
}
