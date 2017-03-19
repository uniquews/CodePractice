import java.util.Arrays;

/**
 * Created by shuaiwang on 3/18/17.
 */
public class HIndex {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }

        Arrays.sort(citations);
        int result = 0;
        for (int i = 0; i <= citations.length; i++) {
            // position: 引用次数为i的paper会位于排好序的paper数组的哪个位置，取 lower bound。
            // position之后的都是citation 大于等于i的papers
            // position之前的都是citations小于i的papers
            // 有了position之后就可以知道比当前引用i大的paper有多少个，引用次数比i小的paper有多少个
            // A scientist has index h if h of his/her N papers have at least h citations each:
            // 从position之后的，至少要有大于等于i的paper，它们的引用次数是大于等于i的。

            int position = findLowerBound(citations, i);
            if (citations.length - position >= i) {
                result = i;
            }
        }
        return result;
    }

    private int findLowerBound(int[] citations, int num) {
        int start = 0, end = citations.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (citations[mid] >= num) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (citations[start] >= num) {
            return start;
        }

        if (citations[end] < num) {
            return end + 1;
        }

        return end;
    }


}
