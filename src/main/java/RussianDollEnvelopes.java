import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by shuaiwang on 2/20/17.
 */
public class RussianDollEnvelopes {

    // dp way, will tle
//    public int maxEnvelopes(int[][] envelopes) {
//        // Write your code here
//        if (envelopes == null || envelopes.length == 0) {
//            return 0;
//        }
//
//        int result = 1;
//        int[] dp = new int[envelopes.length];
//
//        Arrays.sort(envelopes, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                if (o1[0] < o2[0]) {
//                    return -1;
//                } else if (o1[0] > o2[0]) {
//                    return 1;
//                } else {
//                    return o1[1] - o2[1];
//                }
//            }
//        });
//
//        Arrays.fill(dp, 1);
//        for (int i = 1; i < envelopes.length; i++) {
//            for (int j = 0; j < i; j++) {
//                if (envelopes[i][0] > envelopes[j][0] &&
//                        envelopes[i][1] > envelopes[j][1]) {
//                    dp[i] = Math.max(dp[j] + 1, dp[i]);
//                }
//            }
//            result = Math.max(dp[i], result);
//        }
//        return result;
//    }

//
//    public int maxEnvelopes(int[][] envelopes) {
//        // Write your code here
//        if (envelopes == null || envelopes.length == 0) {
//            return 0;
//        }
//
//        sortEnvelopes(envelopes);
//
//        List<Integer> result = longestIncreasingSubSequenceOfHeight(envelopes);
//
//        return result.size();
//    }
//
//    void sortEnvelopes(int[][] envelopes) {
//        Arrays.sort(envelopes, (o1, o2) -> {
//            if (o1[0] < o2[0]) {
//                return -1;
//            } else if (o1[0] > o2[0]) {
//                return 1;
//            } else {
//                return o2[1] - o1[1];
//            }
//        });
//        return;
//    }
//
//    List<Integer> longestIncreasingSubSequenceOfHeight(int[][] envelopes) {
//        List<Integer> result = new ArrayList<>();
//        result.add(envelopes[0][1]);
//        for (int i = 1; i < envelopes.length; ++i) {
//            int start = 0, end = result.size() - 1, current = envelopes[i][1];
//            while (start + 1 < end) {
//                int mid = start + (end - start) / 2;
//                if (result.get(mid) < current) {
//                    start = mid;
//                } else if (result.get(mid) > current) {
//                    end = mid;
//                } else {
//                    end = mid;
//                    break;
//                }
//            }
//
//            if (result.get(end) < current) {
//                result.add(current);
//            } else if (result.get(start) > current) {
//                result.set(start, current);
//            } else if (result.get(start) == current) {
//                result.set(start, current);
//            } else {
//                result.set(end, current);
//            }
//        }
//        return result;
//    }

    public int maxEnvelopes(int[][] envelopes) {
        // Write your code here
        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }

        int result = 1;
        int[] dp = new int[envelopes.length];

        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] < o2[0]) {
                    return -1;
                } else if (o1[0] > o2[0]) {
                    return 1;
                } else {
                    return o2[1] - o1[1];
                }
            }
        });

        Arrays.fill(dp, 1);
        for (int i = 1; i < envelopes.length; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            result = Math.max(dp[i], result);
        }
        return result;
    }

    public static void main(String[] args) {
        //[[5,4],[6,4],[6,7],[2,3]]

        //[[15,8],[2,20],[2,14],[4,17],[8,19],[8,9],[5,7],[11,19],[8,11],[13,11],[2,13],[11,19],[8,11],[13,11],[2,13],[11,19],[16,1],[18,13],[14,17],[18,19]]
//        int[][] input = {{5,4}, {6,4}, {6,7}, {2,3}};
//        int[][] input = {{1,2}, {2,3}, {3,4}, {3,5}, {4,5}, {5,5}, {5,6}, {6,7}, {7,8}};
//        int[][] input = {{15,8}, {2,20}, {2,14}, {4,17}, {8,19}, {8,9}, {5,7}, {11,19}, {8,11}
//                , {13,11}, {2,13}, {11,19}, {8,11}, {13,11}, {2,13}, {11,19}, {16,1}, {18,13}, {14,17}, {18,19}};

        int[][] input = {{14, 31}, {12, 2}, {29, 16}, {24, 23}, {48, 31}, {17, 11}, {41, 8}, {48, 3}, {36, 14}, {19, 8}, {49, 47}, {36, 5}, {12, 4}, {11, 35}, {39, 16}, {8, 39}, {15, 29}, {39, 6}, {14, 29}, {34, 46}, {19, 8}, {23, 37}, {43, 36}, {22, 28}, {48, 24}, {49, 49}, {35, 16}, {13, 19}, {43, 11}, {46, 21}, {46, 42}, {17, 28}, {3, 15}, {25, 19}, {44, 48}, {8, 4}, {33, 44}, {14, 25}, {7, 10}};

        //[1,2],[2,3],[3,4],[3,5],[4,5],[5,5],[5,6],[6,7],[7,8]
        RussianDollEnvelopes test = new RussianDollEnvelopes();

        System.out.print(test.maxEnvelopes(input));
    }
}
