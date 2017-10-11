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
            int n = data[i];
            if (count == 0) {
                if ((n >>> 7) == 0b0) {
                    count = 0;
                } else if ((n >>> 5) == 0b110) {
                    count = 1;
                } else if ((n >>> 4) == 0b1110) {
                    count = 2;
                } else if ((n >>> 3) == 0b11110) {
                    count = 3;
                } else {
                    return false;
                }
            } else {
                if ((n >>> 6) == 0b10) {
                    count--;
                } else {
                    return false;
                }
            }
        }
        return count == 0;
    }

    public static void main(String[] args) {
        UTF8Validation test = new UTF8Validation();
        int[] data = {240,162,138,147,145};
        for (int i = 0; i < data.length; i++) {
            System.out.println(Integer.toBinaryString(data[i]));
        }
        test.validUtf8(data);
    }
}
