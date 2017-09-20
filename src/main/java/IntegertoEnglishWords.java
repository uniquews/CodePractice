import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shuaiwang on 5/13/17.
 */
public class IntegertoEnglishWords {
    private static final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty",
            "Seventy", "Eighty", "Ninety"};
    private static final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        String result = "";
        if (num == 0) {
            return "Zero";
        }

        int current = num;
        int index = 0;
        while (current != 0) {
            int tmp = current % 1000;
            if (tmp != 0) { // 防止 One millon thousand 出现
                result = helper(tmp).trim() + " " + THOUSANDS[index] + " " + result;
            }
            current /= 1000;
            index++;
        }
        return result.trim();
    }

    private String helper(int n) {
        if (n == 0) {
            return "";
        }

        if (n < 20) {
            return LESS_THAN_20[n];
        }

        if (n < 100) {
            return TENS[n / 10] + " " + helper(n % 10);
        }

        return LESS_THAN_20[n / 100] + " Hundred " + helper(n % 100);
    }

    public static void main(String[] args) {
        int a = 10000000;
        IntegertoEnglishWords test = new IntegertoEnglishWords();
        test.numberToWords(a);
    }
}
