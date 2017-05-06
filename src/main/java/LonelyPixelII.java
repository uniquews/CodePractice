import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by shuaiwang on 5/5/17.
 */
public class LonelyPixelII {
    public int findBlackPixel(char[][] picture, int N) {
        int[] row = new int[picture.length];
        int[] col = new int[picture[0].length];

        List<int[]> potential = new ArrayList<>();
        HashMap<Integer, String> rowToStr = new HashMap<>();
        for (int i = 0; i < picture.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < picture[0].length; j++) {
                if (picture[i][j] == 'B') {
                    row[i]++;
                    col[j]++;
                }
                sb.append(picture[i][j]);
            }
            rowToStr.put(i, sb.toString());
        }

        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[0].length; j++) {
                if (picture[i][j] == 'B' && row[i] == N && col[j] == N) {
                    potential.add(new int[]{i,j});
                }
            }
        }

        int result = 0;
        for (int[] p : potential) {
            int c = p[1];
            String pattern = "";
            boolean isAllSame = true;
            for (int i = 0; i < picture.length; i++) {
                if (picture[i][c] == 'B') {
                    if (pattern.equals("")) {
                        pattern = rowToStr.get(i);
                        continue;
                    } else {
                        if (!rowToStr.get(i).equals(pattern)) {
                            isAllSame = false;
                            break;
                        }
                    }
                }
            }

            if (isAllSame) {
                result++;
            }
        }
        return result;
    }
}
