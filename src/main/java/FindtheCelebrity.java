/**
 * Created by shuaiwang on 5/14/17.
 */
public class FindtheCelebrity {
    public int findCelebrity(int n) {
        for (int i = 0; i < n; i++) {
            int j = 0;
            for (; j < n; j++) {
                if (i == j) {
                    continue;
                }

                if (knows(i, j) || !knows(j, i)) {
                    break;
                }
            }
            if (j == n) {
                return i;
            }
        }
        return -1;
    }

    // O(n) solution
//    public int findCelebrity(int n) {
//        int result = 0;
//        for (int i = 0; i < n; i++) {
//            if (i != result && knows(result, i)) {
//                result = i;
//            }
//        }
//
//        for (int i = 0; i < n; i++) {
//            if (i != result && (knows(result, i) || !knows(i, result)))
//                return -1;
//        }
//        return result;
//    }

    boolean knows(int a, int b) {
        return true;
    }
}
