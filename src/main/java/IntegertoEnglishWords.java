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
        if (num == 0)
            return "Zero";
        String result = "";
        int index = 0;
        while (num != 0) {
            int current = num % 1000;
            if (current != 0)
                result = helper(current).trim() + " " + THOUSANDS[index] + " " + result;
            num /= 1000;
            index++;
        }

        return result.trim();
    }

    private String helper(int current) {
        if (current == 0)
            return "";

        if (current < 20) {
            return LESS_THAN_20[current];
        }

        if (current < 100) {
            return TENS[current / 10] + " " + LESS_THAN_20[current % 10];
        }

        return LESS_THAN_20[current / 100] + " Hundred " + helper(current % 100);
    }

    public static void main(String[] args) {
        int a = 10000000;
        IntegertoEnglishWords test = new IntegertoEnglishWords();
        test.numberToWords(a);
    }
}
