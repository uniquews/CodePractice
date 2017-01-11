/**
 * Created by shuaiwang on 1/10/17.
 */

// Java Doc about Bit Manipulation http://docs.oracle.com/javase/tutorial/java/nutsandbolts/op3.html
public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int diff = x ^ y;
        int count = 0;
        for (int i = 1; i <= 32; i++) {
            count += (diff >> i) & 1;
        }
        return count;
    }
}
