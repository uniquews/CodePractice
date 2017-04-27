/**
 * Created by shuaiwang on 4/26/17.
 */
public class SmallestGoodBase {
    public String smallestGoodBase(String n) {
        long num = 0;
        for (char c : n.toCharArray()) {
            num = num * 10 + (c - '0');
        }

        long x = 1;
        for (int i = 64; i >= 1; i--) { // i 表示  1 + k + k^2 + k^3 + ... +k^d 有多少个d
            // 2^64 是1.8446744073709552E19，cover了题目 n的 上限 10^18
            // x << i 是base为2的时候 最后一个数字，2是最小的base，如果最后一个数字自己都比num大，那就不用算了
            System.out.println(x << i);
            if ((x << i) < num) {
                long base = getK(num, i);
                if (base != -1)
                    return String.valueOf(base);
            }
        }
        return String.valueOf(num - 1);
    }

    private long getK(long num, int d) {
        long left = 1, right = (long)Math.pow(num, 1.0 / d) + 1; // 一定要写1.0 如果是1的话，1/3 就不是开3次方，而是0次方了
        while (left + 1 < right) {
            long mid = left + (right - left) / 2;
            long val = getValue(d, mid);
            if (val == num)
                return mid;
            else if (val < num) {
                left = mid;
            } else {
                right = mid;
            }
        }

        if (getValue(d, left) == num)
            return left;
        else if (getValue(d, right) == num)
            return right;

        return -1;
    }

    private long getValue(int d, long mid) {
        long val = 0;
        long current = 1;
        for (int i = 0; i <= d; i++) {
            val += current;
            current *= mid;
        }
        return val;
    }

    public static void main(String[] args) {
        String s = "13";
        SmallestGoodBase test = new SmallestGoodBase();
        System.out.print(test.smallestGoodBase(s));
//        System.out.print((long)Math.pow(13, 1/3) + 1);
    }
}
