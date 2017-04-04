/**
 * Created by shuaiwang on 4/2/17.
 */

// 这道题有一个没有说明白的暗示，read和read4在read一个固定的文件。
public class ReadNCharactersGivenRead4 {
    public class Solution {
        private int read4(char[] buf) {
            return 4;
        }

        public int read(char[] buf, int n) {
            char[] buffer = new char[4];
            boolean endOfFile = false;
            int numberOfRead = 0;

            while (numberOfRead < n && !endOfFile) {
                int currentRead = read4(buffer);
                if (currentRead < 4) {
                    endOfFile = true;
                }
                int length = Math.min(currentRead, n - numberOfRead);
                for (int i = 0; i < length; i++) {
                    buf[numberOfRead + i] = buffer[i];
                }
                numberOfRead += length;
            }
            return numberOfRead;
        }
    }
}
