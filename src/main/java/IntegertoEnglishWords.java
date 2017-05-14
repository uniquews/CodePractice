import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shuaiwang on 5/13/17.
 */
public class IntegertoEnglishWords {
    private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty",
            "Seventy", "Eighty", "Ninety"};
    private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        int i = 0;
        String word = "";
        while (num != 0) {
            int cur = num % 1000;
            if (cur != 0) { // 不加这个 1000000 就会变成 "One Million Thousand"
                word = helper(cur) + THOUSANDS[i] + " " + word;
            }
            num /= 1000;
            i++;
        }
        return word.trim();
    }

    private String helper(int num) {
        if (num == 0) {
            return "";
        }

        if (num < 20) {
            return LESS_THAN_20[num] + " ";
        }

        if (num < 100) {
            return TENS[num / 10] + " " + helper(num % 10);
        }

        return LESS_THAN_20[num / 100] + " " + "Hundred" + " " + helper(num % 100);
    }
}
