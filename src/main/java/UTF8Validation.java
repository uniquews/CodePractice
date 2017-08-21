/**
 * Created by shuaiwang on 3/5/17.
 */
public class UTF8Validation {
//    public boolean validUtf8(int[] data) {
//        int count = 0;
//        for (int i = 0; i < data.length; i++) {
//            if (count == 0) {
//                if (data[i] >> 5 == 0b110) {
//                    count = 1;
//                } else if (data[i] >> 4 == 0b1110) {
//                    count = 2;
//                } else if (data[i] >> 3 == 0b11110) {
//                    count = 3;
//                } else if (data[i] >> 7 == 0b1) {
//                    return false;
//                }
//            } else {
//                if (data[i] >> 6 == 0b10) {
//                    count--;
//                } else {
//                    return false;
//                }
//            }
//        }
//        return count == 0;
//    }
    public boolean validUtf8(int[] data) {
        int count = 0;
        for (int i = 0; i < data.length; i++) {
            if (count == 0) {
                if (data[i] >>> 5 == 0b110) {
                    count = 1;
                } else if (data[i] >>> 4 == 0b1110) {
                    count = 2;
                } else if (data[i] >>> 3 == 0b11110) {
                    count = 3;
                } else if (data[i] >>> 7 != 0b0) {
                    return false;
                }
            } else {
                if (count > 0 && data[i] >>> 6 == 0b10) {
                    count--;
                } else {
                    return false;
                }
            }
        }
        return count == 0;
    }
}
