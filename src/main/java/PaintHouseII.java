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
        if (costs == null || costs.length == 0 || costs[0] == null || costs[0].length == 0)
            return 0;
        int k = costs[0].length;
        int[][] f = new int[costs.length][k];


        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        int min1Color = -1;

        for (int i = 0; i < costs.length; i++) {
            int nextMin1 = Integer.MAX_VALUE;
            int nextMin2 = Integer.MAX_VALUE;
            int nextMin1Color = -1;

            for (int j = 0; j < k; j++) {
                if (i == 0) {
                    f[0][j] = costs[0][j];
                    if (f[0][j] < nextMin1) {
                        nextMin2 = nextMin1;
                        nextMin1 = f[0][j];
                        nextMin1Color = j;
                    } else if (f[0][j] >= nextMin1 && f[0][j] < nextMin2) {
                        nextMin2 = f[0][j];
                    }
                    continue;
                }

                if (j == min1Color) {
                    f[i][j] = min2 + costs[i][j];
                } else {
                    f[i][j] = min1 + costs[i][j];
                }

                if (f[i][j] < nextMin1) {
                    nextMin2 = nextMin1;
                    nextMin1 = f[i][j];
                    nextMin1Color = j;
                } else if (f[i][j] >= nextMin1 && f[i][j] < nextMin2) {
                    nextMin2 = f[i][j];
                }
            }

            min1 = nextMin1;
            min2 = nextMin2;
            min1Color = nextMin1Color;
        }
        return min1;
    }

    public static void main(String[] args) {
        // [[1,5,3],[2,9,4]]
        int[][] costs = {{1,5,3}, {2,9,4}};
        PaintHouseII test = new PaintHouseII();
        test.minCostII(costs);
    }

}
