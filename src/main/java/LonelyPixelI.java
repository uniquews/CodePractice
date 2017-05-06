/**
 * Created by shuaiwang on 5/5/17.
 */
public class LonelyPixelI {
    public int findLonelyPixel(char[][] picture) {
        int[] row = new int[picture.length];
        int[] col = new int[picture[0].length];

        int result = 0;
        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[0].length; j++) {
                if (picture[i][j] == 'B') {
                    row[i]++;
                    col[j]++;
                }
            }
        }

        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[0].length; j++) {
                if (picture[i][j] == 'B' && row[i] == 1 && col[j] == 1) {
                    result++;
                }
            }
        }
        return result;
    }
}
