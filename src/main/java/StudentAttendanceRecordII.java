/**
 * Created by shuaiwang on 4/27/17.
 */
public class StudentAttendanceRecordII {
    public int checkRecord(int n) {
        long[][] f = new long[2][3];
        f[0][0] = 1;
        f[0][1] = 1;
        f[1][0] = 1;
        for (int i = 1; i < n; i++) {
            long[][] next = new long[2][3];

            next[0][0] = getSum(f[0]) % 1000000007;
            next[1][0] = (getSum(f[0]) + getSum(f[1])) % 1000000007;
            next[0][1] = f[0][0];
            next[1][1] = f[1][0];
            next[1][2] = f[1][1];
            next[0][2] = f[0][1];
            f = next;
        }
        return (int)((getSum(f[0]) + getSum(f[1])) % 1000000007);
    }

    private long getSum(long[] arr) {
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int n = 2;
        StudentAttendanceRecordII test = new StudentAttendanceRecordII();
        System.out.print(test.checkRecord(n));
    }
}
