/**
 * Created by shuaiwang on 5/18/17.
 */

/**
 * 动归方程：
 * f[i][j] 前i个房子以第j中color结尾的最小cost
 *
 * */
public class PaintHouseII {
//    public int minCostII(int[][] costs) {
//        if (costs == null || costs.length == 0) {
//            return 0;
//        }
//        int[][] f = new int[costs.length][costs[0].length];
//
//        for (int i = 0; i < costs.length; i++) {
//            for (int j = 0; j < costs[0].length; j++) {
//                if (i == 0) {
//                    f[0][j] = costs[0][j];
//                    continue;
//                }
//                int last = Integer.MAX_VALUE;
//                for (int m = 0 ; m < costs[0].length; m++) {
//                    if (j != m)
//                        last = Math.min(last, f[i - 1][m]);
//                }
//                f[i][j] = last + costs[i][j];
//            }
//        }
//
//        int result = Integer.MAX_VALUE;
//        for (int i = 0; i < costs[0].length; i++) {
//            result = Math.min(result, f[costs.length - 1][i]);
//        }
//        return result;
//    }


    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        int[][] f = new int[costs.length][costs[0].length];

        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        int prevColor = -1;

        for (int i = 0; i < costs.length; i++) {
            int nextFirstMin = Integer.MAX_VALUE;
            int nextSecondMin = Integer.MAX_VALUE;
            int nextPreColor = -1;
            for (int j = 0; j < costs[0].length; j++) {
                if (i == 0) {
                    f[0][j] = costs[0][j];
                } else {
                    int last;
                    if (j == prevColor) {
                        last = secondMin;
                    } else {
                        last = firstMin;
                    }
                    f[i][j] = last + costs[i][j];
                }

                if (f[i][j] < nextFirstMin) {
                    nextSecondMin = nextFirstMin;
                    nextFirstMin = f[i][j];
                    nextPreColor = j;
                } else if (f[i][j] < nextSecondMin) {
                    nextSecondMin = f[i][j];
                }
            }
            firstMin = nextFirstMin;
            secondMin = nextSecondMin;
            prevColor = nextPreColor;
        }

        return f[costs.length - 1][prevColor];
    }
}
