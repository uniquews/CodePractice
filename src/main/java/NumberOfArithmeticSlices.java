import java.util.HashMap;

/**
 * f[i][d] 表示以 i 结尾的公差为d的，长度至少为2的（包含2）等差序列的个数
 * given any j < i， d = A[i] - A[j] f[i][d] += f[j][d] + 1
 *
 * f[j][d]原有的等差序列的个数加上 i, j两个数字形成的等差序列，比如{2,4,6,8,10} f[3][2] = 3
 * 分别是{2,4,6,8} {4,6,8} 和 {6,8} 加上10 之后，由于这个等差序列都还在只是后面多加了一个10，
 * 同时增加了一个等差序列就是{8,10}
 *
 * result每次要增加的是f[i][d]被增加的部分，也就是f[j][d] + 1, 但是增加的这部分中有一个
 * {6,8}长度为2的等差序列，result里要把这个减去，所以是f[j][d]
 *
 * */

public class NumberOfArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int result = 0;
        HashMap<Integer, Integer>[] map = new HashMap[A.length];
        for (int i = 0; i< map.length; i++) {
            map[i] = new HashMap<>();
        }
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                if (Math.abs((long)A[i] - (long)A[j]) > Integer.MAX_VALUE) {
                    continue;
                }
                int d = A[i] - A[j];
                int map_i_d = map[i].getOrDefault(d, 0);
                int map_j_d = map[j].getOrDefault(d, 0);
                map_i_d += map_j_d + 1;
                map[i].put(d, map_i_d);
                result += map_j_d;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = {2,4,6,8,8,10};
        NumberOfArithmeticSlices test = new NumberOfArithmeticSlices();
        System.out.println(test.numberOfArithmeticSlices(A));
    }
}
