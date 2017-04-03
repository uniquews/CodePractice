/**
 * Created by shuaiwang on 4/2/17.
 */
public class ReadNCharactersGivenRead4II {
    private int read4(char[] buf) {
        return 4;
    }
    private int numOfCharReadFromOneRead4 = 0; //归零表示要从下一个read4的开头开始往buf里写。不为零表示上一个read4的的char还没有读完
    private int totalNumOfCharByRead4 = 0;
    private char[] buff = new char[4];
    public int read(char[] buf, int n) {
        int ptr = 0;
        while (ptr < n) {
            if (numOfCharReadFromOneRead4 == 0) { //如果上一个read4的char还没有读完，就不Call read4
                totalNumOfCharByRead4 = read4(buff);
            }

            //文件结尾但是n特别大的情况
            if (totalNumOfCharByRead4 == 0) break;

            while (ptr < n && numOfCharReadFromOneRead4 < totalNumOfCharByRead4) {
                buf[ptr++] = buff[numOfCharReadFromOneRead4++];
            }

            // last read4里面的char都被读完了，reset numOfCharReadFromOneRead4为0 开始call 下一次read4
            if (numOfCharReadFromOneRead4 == totalNumOfCharByRead4) numOfCharReadFromOneRead4 = 0;
        }
        return ptr;
    }
}
