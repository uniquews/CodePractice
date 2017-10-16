package fb;

public class ReadByLine {
    private int read4(char[] buf) {
        return 4;
    }

    int currentRead = 0;
    int offsetRead = 0;
    public int readByLine(char[] buf) {
        char[] buffer = new char[4];
        int ptr = 0;
        while (true) {
            if (offsetRead == 0) {
                currentRead = read4(buffer);
                if (currentRead == 0) {
                    return ptr;
                }
            }

            while (offsetRead < currentRead) {
                buf[ptr++] = buffer[offsetRead++];
                if (buffer[offsetRead - 1] == '\n') {
                    return ptr;
                }
            }

            if (offsetRead == currentRead) {
                offsetRead = 0;
            }
        }
    }

    int currentRead4 = 0;
    int offset = 0;
    char[] buffer = new char[4];
    StringBuilder sb;

    String readLine() {
        sb = new StringBuilder();
        while (true) {
            if (currentRead4 == 0) {
                currentRead4 = read4(buffer);
                offset = 0;
                if (currentRead4 == 0) {
                    break;
                }
            }

            while (offset < currentRead4 && buffer[offset] != '\n') {
                sb.append(buffer[offset++]);
            }

            if (offset == currentRead4) {
                currentRead4 = 0;
            } else {
                offset++;
                break; // 遇到 \n了 offset 没有走到最后 break
            }
        }
        return sb.toString();
    }
}
