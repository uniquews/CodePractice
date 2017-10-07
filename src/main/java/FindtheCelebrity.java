/**
 * Created by shuaiwang on 5/14/17.
 */
public class FindtheCelebrity {
    public int findCelebrity(int n) {
        int candidate = 0;
        for (int i = 1; i < n; i++) {
            if (knows(candidate, i)) {
                candidate = i;
            }
        }

        for (int i = 0; i < candidate; i++) {
            if (!(knows(i, candidate) && !knows(candidate, i))) {
                return -1;
            }
        }

        for (int i = candidate + 1; i < n; i++) {
            if (!knows(i, candidate)) {
                return -1;
            }
        }

        return candidate;
    }

    boolean knows(int a, int b) {
        return true;
    }
}
