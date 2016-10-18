package main;

/**
 * Created by shuaiwang on 10/17/16.
 */
public class HashFunction {
    public int hashCode(char[] key,int HASH_SIZE) {
        // write your code here
        long base = 1;
        int result = 0;
        for (int i = key.length - 1; i >= 0; i--) {
            int cur = (int)key[i];
            result += caculateCurrent(cur, base, HASH_SIZE); // subResult = num * base % HASH_SIZE
            result = result % HASH_SIZE; // (subResult_1 + subResult_2) % HASH_SIZE
            base = calculateBase(base, 33, HASH_SIZE); // base1 = 33%HASH base2=33%HASH*33%HASH base3=33%HASH*33%HASH*33%HASH
        }
        return result;
    }

    private long calculateBase(long base, long num, int HASH_SIZE) {
        long tmp = base * num % HASH_SIZE;
        return tmp;
    }

    private int caculateCurrent(long num, long base33, int HASH_SIZE) {
        long tmp = num * base33 % HASH_SIZE;
        return (int)tmp;
    }
}
