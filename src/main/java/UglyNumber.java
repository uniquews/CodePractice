/**
 * Created by shuaiwang on 10/23/16.
 */


/***
 * 思路：
 *
 * 将Num里的2 3 5 factor都除尽, 和1比较
 */
public class UglyNumber {
    public boolean isUgly(int num) {
        // Write your code here
        if (num <= 0) {
            return false;
        }

        while (num >= 1 && num % 2 == 0) { // change the while loop order is ok
            num /= 2;
        }
        while (num >= 1 && num % 3 == 0) {
            num /= 3;
        }

        while (num >= 1 && num % 5 == 0) {
            num /= 5;
        }
        return num == 1;
    }
}
