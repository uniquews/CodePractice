package G;


import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Arrays;

/**
 *
 * 然后就上coding question:输入一个整数 as char array 的方式，例如： 89 -> ['8','9'] or -98 -> ['-', '9', '8'].
 * 输出： 如果是正数就加一，是负数就减一，e.g.89 -> ['9','0'] or -98 -> ['-', '9', '7']， 输出格式 char[]限制条件：1.
 * 输入的array相当大，不能直接将char[] 转成int or long做处理, 否则 overflow。2. assume all the chars are valid.
 * 也就是说：-0000， -01， 011 都不是有效输入
 我就用最土的办法按位处理：1. 正常的case, size 不需要改变的话，很简单，最后一位加一或减一
 2. 如果特殊情况比如：99 -> 100, -100 -> -99, -1 -> -0, etc.
 处理总之特殊情况想的有点复杂
 *
 * */
public class AddOrMinusOne {

    public char[] addOrMinusOne(char[] nums) {
        if (nums[0] == '-') {
            // call minus one
            return minusOne(nums);
        } else {
            // call add one
            return addOne(nums);
        }

    }

    private char[] addOne(char[] nums) {
        char[] tmp = new char[nums.length + 1];
        Arrays.fill(tmp, '0');

        int carry = 1;
        int index = nums.length - 1;
        while (index >= 0 && carry > 0) {
            int n = nums[index] - '0' + carry;
            tmp[index + 1] = (char)((n % 10) + '0');
            carry = n / 10;
            index--;
        }
        while (index >= 0) {
            tmp[index + 1] = nums[index];
            index--;
        }

        if (carry != 0) {
            tmp[0] = (char)(carry % 10 + '0');
        }

        if (tmp[0] == '0') {
            return Arrays.copyOfRange(tmp, 1, tmp.length);
        }
        return tmp;
    }

    private char[] minusOne(char[] nums) {
        char[] tmp = new char[nums.length - 1];
        Arrays.fill(tmp, '0');

        int carry = -1;
        int index = nums.length - 1;
        while (index >= 1 && carry == -1) {
            int n = nums[index] - '0' + carry + 10;
            tmp[index - 1] = (char)(n % 10 + '0');
            carry = n / 10 - 1;
            index--;
        }

        while (index >= 1) {
            tmp[index - 1] = nums[index];
            index--;
        }

        index = 0;
        while (index < tmp.length - 1 && tmp[index] == '0') {
            index++;
        }

        int sizeOfNumber = tmp.length - index;
        char[] result = new char[sizeOfNumber + 1];
        result[0] = '-';

        for (int i = 1; i < result.length; i++) {
            result[i] = tmp[index++];
        }

        return result;
    }

    public static void main(String[] args) {
//        char[] a = {'9', '8'};
//        char[] a = {'9', '9'};
//        char[] a = {'0'};
//        char[] a = {'-', '9', '9'};
//        char[] a = {'-', '1', '0'};
        char[] a = {'-', '1'};
        AddOrMinusOne test = new AddOrMinusOne();
//        char[] result = test.addOne(a);
        char[] result = test.minusOne(a);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);

        }
    }
}
