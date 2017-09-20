/**
 * Created by shuaiwang on 4/2/17.
 */
public class ReadNCharactersGivenRead4II {
    private int read4(char[] buf) {
        return 4;
    }
//    private int numOfCharWriteToBuf = 0; //归零表示要从下一个read4的开头开始往buf里写。不为零表示上一个read4的的char还没有读完
//    private int numOfCharReadFromFile = 0;
//    private char[] buff = new char[4];
//    public int read(char[] buf, int n) {
//        int ptr = 0;
//        while (ptr < n) {
//            if (numOfCharWriteToBuf == 0) { //如果上一个read4的char还没有读完，就不Call read4
//                numOfCharReadFromFile = read4(buff);
//                //文件结尾但是n特别大的情况
//                if (numOfCharReadFromFile == 0) break;
//            }
//
//            // 上一次read4到下一次read4之间，一共write到buf里的char个数 与 上一次从file里面读到的char的个数进行比较，
//            // prt是一共read N 的char 个数
//            while (ptr < n && numOfCharWriteToBuf < numOfCharReadFromFile) {
//                buf[ptr++] = buff[numOfCharWriteToBuf++];
//            }
//
//            // last read4里面的char都被读完了，reset numOfCharReadFromOneRead4为0 开始call 下一次read4
//            if (numOfCharWriteToBuf == numOfCharReadFromFile) numOfCharWriteToBuf = 0;
//        }
//        return ptr;
//    }

//    private int leftOverFromRead4 = 0; //归零表示要从下一个read4的开头开始往buf里写。不为零表示上一个read4的的char还没有读完
//    private int oneTimeFromRead4 = 0;
//    private char[] buff = new char[4];
//
//    /**
//     * @param buf Destination buffer
//     * @param n   Maximum number of characters to read
//     * @return    The number of characters read
//     */
//    public int read(char[] buf, int n) {
//        if (n == 0)
//            return 0;
//
//        int current = 0;
//        while (current < n) {
//            if (leftOverFromRead4 == 0) {
//                oneTimeFromRead4 = read4(buff);
//                if (oneTimeFromRead4 == 0)
//                    break;
//            }
//
//            while (current < n && leftOverFromRead4 < oneTimeFromRead4) {
//                buf[current++] = buff[leftOverFromRead4++];
//            }
//            if (leftOverFromRead4 == oneTimeFromRead4) {
//                leftOverFromRead4 = 0;
//            }
//        }
//        return current;
//    }

//    private char[] bufferFor4 = new char[4];
//    private boolean endOfFile = false;
//    private int fromLastRead4 = 0;
//    private int indexBufferFor4 = 0;
//
//    public int read(char[] buf, int n) {
//        int currentRead = 0;
//        while (currentRead < n) {
//            if (fromLastRead4 > 0) {
//                int i = 0;
//                for (; i < fromLastRead4 && currentRead + i < n; i++) {
//                    buf[currentRead + i] = bufferFor4[indexBufferFor4 + i];
//                }
//
//                if (i == fromLastRead4) {
//                    fromLastRead4 = 0;
//                    indexBufferFor4 = 0;
//                } else {
//                    fromLastRead4 -= i;
//                    indexBufferFor4 +=i;
//                }
//                currentRead += i;
//            }
//
//            if (fromLastRead4 == 0 && currentRead < n) {
//                int readAtOneTime = read4(bufferFor4);
//                if (readAtOneTime < 4) {
//                    endOfFile = true;
//                }
//
//                int len;
//                if (readAtOneTime <= n - currentRead) {
//                    len = readAtOneTime;
//                    for (int i = 0; i < len; i++) {
//                        buf[currentRead + i] = bufferFor4[i];
//                    }
//
//                } else {
//                    len = n - currentRead;
//                    for (int i = 0; i < len; i++) {
//                        buf[currentRead + i] = bufferFor4[i];
//                    }
//                    fromLastRead4 = readAtOneTime - len;
//                    indexBufferFor4 += len;
//                }
//
//                currentRead += len;
//                if (endOfFile)
//                    break;
//            }
//
//        }
//        return currentRead;
//    }

    char[] buffer = new char[4];
    int offsetInRead4 = 0;
    int currentRead = 0;
    public int read(char[] buf, int n) {
        int ptr = 0;
        while (ptr < n) {
            if (offsetInRead4 == 0) {
                currentRead = read4(buffer);
                if (currentRead == 0) {
                    return ptr;
                }
            }

            while (ptr < n && offsetInRead4 < currentRead) {
                buf[ptr++] = buffer[offsetInRead4++];
            }

            if (offsetInRead4 == currentRead) {
                offsetInRead4 = 0;
            }
        }
        return ptr;
    }
}
