import java.util.*;

/**
 * Created by shuaiwang on 5/5/17.
 */
public class LonelyPixelII {
    public class Solution {
        public int findBlackPixel(char[][] picture, int N) {
            int[] row = new int[picture.length];
            int[] col = new int[picture[0].length];

            Map<Integer, List<Integer>> colToRow = new HashMap<>();
            for (int i = 0; i < picture.length; i++) {
                for (int j = 0; j < picture[0].length; j++) {
                    if (picture[i][j] == 'B') {
                        row[i]++;
                        col[j]++;

                        if (colToRow.containsKey(j)) {
                            colToRow.get(j).add(i);
                        } else {
                            colToRow.put(j, new ArrayList<>(Arrays.asList(i)));
                        }
                    }
                }
            }

            int result = 0;
            for (int i = 0; i < picture.length; i++) {
                for (int j = 0; j < picture[0].length; j++) {
                    if (picture[i][j] == 'B' && row[i] == N && col[j] == N && isAllRowSame(colToRow.get(j), picture)) {
                        result++;
                    }
                }
            }
            return result;
        }

        private boolean isAllRowSame(List<Integer> l, char[][] picture) {
            char[] firstRow = picture[l.get(0)];

            for (int i = 1; i < l.size(); i++) {
                if (!Arrays.equals(firstRow, picture[l.get(i)]))
                    return false;
            }
            return true;
        }
    }

}
