/**
 * Created by shuaiwang on 5/20/17.
 */
public class HIndexII {
    public int hIndex(int[] citations) {
        if (citations.length == 0)
            return 0;
        int start = 0, end = citations.length - 1, N = citations.length;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (citations[mid] >= N - mid) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (citations[start] >= N - start) {
            return N - start;
        } else if (citations[end] >= N - end) {
            return N - end;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        int[] ci = {0};
        HIndexII test = new HIndexII();
        test.hIndex(ci);
    }
}
