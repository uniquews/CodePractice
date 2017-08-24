/**
 * Created by shuaiwang on 4/2/17.
 */

// 这道题有一个没有说明白的暗示，read和read4在read一个固定的文件, 是要往buf写， 而不是往buf里读。
public class ReadNCharactersGivenRead4 {
    private int read4(char[] buf) {
        return 4;
    }


//    private int currentRead = 0;
//    private char[] bufferFor4 = new char[4];
//    private boolean endOfFile = false;
//
//    public int read(char[] buf, int n) {
//        while (currentRead < n) {
//            int readAtOneTime = read4(bufferFor4);
//            if (readAtOneTime < 4) {
//                endOfFile = true;
//            }
//
//            int len = Math.min(readAtOneTime, n - currentRead);
//            for (int i = 0; i < len; i++) {
//                buf[currentRead + i] = bufferFor4[i];
//            }
//            currentRead += len;
//            if (endOfFile)
//                break;
//
//        }
//        return currentRead;
//    }

    private char[] buff = new char[4];
    private int numOfCharReadFromFile = 0;
    public int read(char[] buf, int n) {
        if (n == 0)
            return 0;
        int current = 0;
        while (numOfCharReadFromFile < n) {
            current = read4(buff);
            int len = Math.min(current, n - numOfCharReadFromFile);
            for (int i = 0; i < len; i++) {
                buf[numOfCharReadFromFile + i] = buff[i];
            }

            numOfCharReadFromFile += len; // 容易错

            if (current < 4)
                break;
        }
        return numOfCharReadFromFile;
    }
}
