/**
 * Created by shuaiwang on 3/28/17.
 */
public class NthDigit {
    public int findNthDigit(int n) {
        // check how many digits that target number has
        int lengthOfDigit = 1; // 0 - 9 has 1 digit
        long numOfNumbersHasSameLenOfDigit = 9; // start from 0 - 9
        while (n > lengthOfDigit * numOfNumbersHasSameLenOfDigit) {
            n -= lengthOfDigit * numOfNumbersHasSameLenOfDigit;
            numOfNumbersHasSameLenOfDigit *= 10; // 10 - 99 has 90 numbers. 100 - 999 has 900 numbers
            lengthOfDigit++;
        }

        // get what is the target number
        int numberPos = n / lengthOfDigit;
        long number = 1;
        for (int i = 1; i < lengthOfDigit; i++) {
            number *= 10;
        }
        number = number + numberPos - 1; // 因为我们是从第一个数开始加的， 1 + 8 - 1才是第八个数

        // get the digit from the number
        int index = n % lengthOfDigit;
        if (index == 0) {
            // return the last digit of number
            return (int)number % 10;
        } else {
            number += 1;
            long base = 10;
            long base2 = 1;
            long tmp = 1;
            while (tmp < lengthOfDigit - index + 1) {
                base *= 10;
                base2 *= 10;
                tmp++;
            }

            long removeBefore = number % base;
            long result = removeBefore / base2;
            return (int)result;
        }
    }

    public static void main(String[] args) {
        NthDigit test = new NthDigit();

        System.out.println(test.findNthDigit(1000000000));
        System.out.println(Integer.MAX_VALUE);
    }
}
