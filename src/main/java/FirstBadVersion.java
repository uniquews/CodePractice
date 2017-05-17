/**
 * Created by shuaiwang on 5/14/17.
 */
public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int start = 1, end = n;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (isBadVersion(start)) {
            return start;
        }
        return end;
    }

    boolean isBadVersion(int version) {
        return true;
    }
}
