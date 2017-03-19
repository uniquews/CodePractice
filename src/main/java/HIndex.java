import java.util.Arrays;

/**
 * Created by shuaiwang on 3/18/17.
 */
public class HIndex {
    // O(nlogN)
//    public int hIndex(int[] citations) {
//        if (citations == null || citations.length == 0) {
//            return 0;
//        }
//
//        Arrays.sort(citations);
//        int result = 0;
//        for (int i = 0; i <= citations.length; i++) {
//            // position: 引用次数为i的paper会位于排好序的paper数组的哪个位置，取 lower bound。
//            // position之后的都是citation 大于等于i的papers
//            // position之前的都是citations小于i的papers
//            // 有了position之后就可以知道比当前引用i大的paper有多少个，引用次数比i小的paper有多少个
//            // A scientist has index h if h of his/her N papers have at least h citations each:
//            // 从position之后的，至少要有大于等于i的paper，它们的引用次数是大于等于i的。
//            // the other N − h papers have no more than h citations each.
//            // 换言之就是可以有大于等于citations.length - i的paper他们的citations是小于i的
//
//            int position = findLowerBound(citations, i);
//            if (citations.length - position >= i) {
//                result = i;
//            }
//        }
//        return result;
//    }
//
//    private int findLowerBound(int[] citations, int num) {
//        int start = 0, end = citations.length - 1;
//        while (start + 1 < end) {
//            int mid = start + (end - start) / 2;
//            if (citations[mid] >= num) {
//                end = mid;
//            } else {
//                start = mid;
//            }
//        }
//
//        if (citations[start] >= num) {
//            return start;
//        }
//
//        if (citations[end] < num) {
//            return end + 1;
//        }
//
//        return end;
//    }

    // input: [0,3,3,1] output: h = 2
    // 其实没有必要像之前一样那么麻烦，如果把i直接看成是论文数而不是论文的index数，就可以用一下方法
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0)
            return 0;
        int result = 0;
        for (int i = 0; i < citations.length; i++) {
            int possibleH = i;
            //citations[possibleH] 指的是当前这篇论文的引用次数，后面的论文都比它引用次数多。
            //citations.length - possibleH 比当前论文引用次数多的（包含等于）的论文数量
            if (citations.length - possibleH >= citations[possibleH]) {
                result = possibleH;
            }
        }

        //返回的其实是第i篇论文，从i往后所有的论文数量，（后面的论文大于等于第i篇论文的引用数）大于等于
        //第i篇论文的引用数量。
        return result + 1;
    }

    // O(N)
//    public int hIndex(int[] citations) {
//        if (citations == null || citations.length == 0) {
//            return 0;
//        }
//
//        int totalPaper = citations.length;
//        int[] bucket = new int[totalPaper + 1];
//        for (int i = 0; i < citations.length; i++) {
//            if (citations[i] > totalPaper) {
//                bucket[totalPaper] = citations[i];
//            } else {
//                bucket[citations[i]] += 1;
//            }
//        }
//
//        int sumOfCitation = 0;
//        int result = 0;
//        for (int i = bucket.length - 1; i >= 0; i--) {
//            sumOfCitation += bucket[i];
//            if (sumOfCitation >= i) { // 大于当前论文citation的论文数 大于等于 当前论文的citations
//                result = sumOfCitation;
//            }
//        }
//        return result;
//    }

}
