/**
 * Created by shuaiwang on 1/13/17.
 */
public class CountingBits {

    // Way 1
    public int[] countBits(int num) {
        int[] result = new int[num];
        for (int i = 0; i <= num; i++) {
            result[0] = count(i);
        }
        return result;
    }

    public int count(int num) {
        int result = 0;
        for (int i = 1; i <= 33; i++) {
            result += (num >> i) & 1;
        }
        return result;
    }



    public static void main(String[] args) {
        int test = 1;
        CountingBits t = new CountingBits();
        t.count(test);
    }
}
