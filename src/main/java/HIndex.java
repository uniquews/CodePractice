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
    /**
     * 循环所有可能的hIndex， hIndex的范围为1到论文总数。每个人默认的起始hIndex都是0所以没必要从0开始
     * 假设我当前尝试的possibleH是1， 只要至少有一篇论文的citation大于等于1，那么1就是valid citation
     * 因为所有的论文按照citation从小到大排好序了，在所有的论文里，只要citation最大的那篇论文的被引用次数
     * 大于等于1，那么1就成立，也就是 citations[citations.length - possibleH] >= possibleH
     * 同理当possibleH是2，只需要查看倒数第二篇论文的citation是不是大于等于2。
     * */
//    public int hIndex(int[] citations) {
//        if (citations == null || citations.length == 0)
//            return 0;
//        Arrays.sort(citations);
//        int h = 0;
//        for (int i = 1; i <= citations.length; i++) {
//            int possibleH = i;
//            if (citations[citations.length - possibleH] >= possibleH) {
//                h = possibleH;
//            }
//        }
//
//        return h;
//    }

    // O(N)
//    public int hIndex(int[] citations) {
//        if (citations == null || citations.length == 0) {
//            return 0;
//        }
//
//        int totalPaper = citations.length;
//        // bucket数组中的Index表示所有可能的hIndex
//        int[] bucket = new int[totalPaper + 1];
//        for (int i = 0; i < citations.length; i++) {
//            if (citations[i] > totalPaper) {
//                bucket[totalPaper] += 1;
//            } else {
//                bucket[citations[i]] += 1;
//            }
//        }
//
//        int sumOfCitation = 0;
//        int result = 0;
////        for (int i = bucket.length - 1; i > 0; i--) {
////            sumOfCitation += bucket[i];
////            if (sumOfCitation >= i) { // 大于当前论文citation的论文数 大于等于 当前论文的citations
////                result = i;
////                break;
////            }
////        }
//
//        for (int i = 0; i < bucket.length; i++) {
//            sumOfCitation += bucket[i];
//            if (sumOfCitation > totalPaper - i) {
//                result = i;
//            }
//        }
//        return result;
//    }

    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        for (int h = citations.length; h >= 0; h--) {
            if (citations.length - h >= citations[h]) {
                return h;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        HIndex test = new HIndex();
        int[] a = {3, 0, 6, 1, 5};
        test.hIndex(a);
    }

}
