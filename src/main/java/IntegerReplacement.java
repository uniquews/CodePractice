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
    public int integerReplacement(int n) {
        int times = 0;
        long num = n;
        while (num > 1) {
            if (num % 2 == 0) {
                num = num / 2;
            } else if ((num + 1) % 4 == 0 && num != 3){
                num++;
            } else {
                num--;
            }
            times++;
        }
        return times;
    }
}
