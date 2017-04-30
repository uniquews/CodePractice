package b;

/**
 * Created by bohan on 4/27/17.
 */
public class StudentAttendanceRecordII {
    public int checkRecord(int n) {
        long[][] f = new long[2][3];
        f[0][0] = 1;
        f[0][1] = 1;
        f[1][0] = 1;

        for (int i = 1; i < n; i++) {
            long[][] nextF = new long[2][3];
            nextF[0][0] = (f[0][0] + f[0][1] + f[0][2]) % 1000000007;
            nextF[0][1] = f[0][0];
            nextF[0][2] = f[0][1];
            nextF[1][0] = sum(f);
            nextF[1][1] = f[1][0];
            nextF[1][2] = f[1][1];
            f = nextF;
        }
        return (int) sum(f);
    }

    private long sum(long[][] f) {
        return (f[0][0] + f[0][1] + f[0][2] + f[1][0] + f[1][1] + f[1][2]) % 1000000007;
    }
}
