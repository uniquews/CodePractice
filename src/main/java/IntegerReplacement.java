/**
 * Created by shuaiwang on 4/16/17.
 */

/**
 * 这题没什么意思
 *
 * 当n是奇数的时候，如果n + 1是4的倍数且n不是3，总让n = n + 1 （一个数学规律）
 * 如果n + 1不是4的倍数，n = n - 1
 *
 * 注意当n是Integer.Max的时候会越界
 */

public class IntegerReplacement {

    /**
     * 必须要用无符号移位，因为无符号移位在高位会fill zero  而有符号的移位，对于负数会fill 1，因为1是符号位
     * Integer.MIN 向右无符号移位31次是1  向右有符号移位是-1  这样 （n>>>1） & 1 永远是1，n--
     *
     * */
    public int integerReplacement(int n) {
        int count = 0;
        while (n != 1) {
            if ((n & 1) == 0) {
                n >>>= 1; // 不能用n/2 因为 除法是有符号移位
                count++;
            } else {
                if (n == 3 || ((n >>> 1) & 1) == 0) { // n>>>1 倒数第二位
                    n--;
                } else {
                    n++;
                }
                count++;
            }
        }
        return count;
    }
}
