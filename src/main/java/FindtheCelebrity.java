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

//    public int findCelebrity(int n) {
//        int candidate = 0;
//        for (int i = 1; i < n; i++) {
//            if (knows(candidate, i)) {
//                candidate = i;
//            }
//        }
//
//        for (int i = 0; i < n; i++) {
//            if (candidate == i)
//                continue;
//            if (knows(candidate, i) || !knows(i, candidate)) {
//                return -1;
//            }
//        }
//        return candidate;
//    }

    boolean knows(int a, int b) {
        return true;
    }
}
