/**
 * Created by shuaiwang on 1/29/17.
 */

// The idea is to multiply 3 all the times until you can't fo it
public class IntegerBreak {
    public int integerBreak(int n) {
        if(n == 2) return 1;
        if(n == 3) return 2;
        int product = 1;
        while(n > 4){
            product *= 3;
            n -= 3;
        }
        product *= n;

        return product; // production = 3 * 3 * # *... * last number which could be [2,3,4]
    }
}
