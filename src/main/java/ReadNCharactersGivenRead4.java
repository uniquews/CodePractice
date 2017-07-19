/**
 * Created by shuaiwang on 4/2/17.
 */

// 这道题有一个没有说明白的暗示，read和read4在read一个固定的文件, 是要往buf写， 而不是往buf里读。
public class ReadNCharactersGivenRead4 {
    private int read4(char[] buf) {
        return 4;
    }


    private int currentRead = 0;
    private char[] bufferFor4 = new char[4];
    private boolean endOfFile = false;

    public int read(char[] buf, int n) {
        while (currentRead < n) {
            int readAtOneTime = read4(buf);
            if (readAtOneTime < 4) {
                endOfFile = true;
            }

            int len = Math.min(readAtOneTime, n - currentRead);
            for (int i = 0; i < len; i++) {
                buf[currentRead + i] = bufferFor4[i];
            }
            if (endOfFile)
                break;
        }
        return currentRead;
    }
}
