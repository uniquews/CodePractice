/**
 * Created by shuaiwang on 10/17/16.
 */
public class HashFunction {

    // Solution 2

    /**
     * f(n) = (a * 33^2 + b * 33 + c) % k
     * => ((a * 33^2 + b * 33) % k + c % k) % k
     * => ((33 * (a * 33 + b)) % k + c % k) % k
     * => (((33 % k) * (a * 33 + b) % k) % k + c % k) % k
     * => (((33 % k) * f(n - 1)) % k + c % k) % k
     * => (((33 % k) * f(n - 1)) + c ) % k
     */
    public int hashCode(char[] key, int k) {
        // write your code here
        long result = 0;
        for (int i = 0; i < key.length; i++) {
//            result = (((33 % k) * result) % k + key[i] % k) % k;
            result = ((33 % k) * result + key[i]) % k;
        }
        return (int) result;
    }
}
