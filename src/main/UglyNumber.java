package main;

/**
 * Created by shuaiwang on 10/23/16.
 */
public class UglyNumber {
    public boolean isUgly(int num) {
        // Write your code here
        if (num <= 0) {
            return false;
        }

        while (num >= 1 && num % 2 == 0) {
            num /= 2;
        }
        while (num >= 1 &&  num % 3 == 0) {
            num /= 3;
        }

        while (num >= 1 &&  num % 5 == 0) {
            num /= 5;
        }
        return num == 1;
    }
}
