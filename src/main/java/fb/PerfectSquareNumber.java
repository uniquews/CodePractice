package fb;

public class PerfectSquareNumber {

    //二分法
//    public boolean isPerfectSquare(int n) {
//        if (n == 0) {
//            return true;
//        }
//
//        if (n < 0) {
//            return false;
//        }
//
//        int start = 1;
//        int end = n;
//        while (start + 1 < end) {
//            int mid = start + (end - start) / 2;
//            if (n % mid == 0 && mid == n / mid) {
//                return true;
//            }
//            if (mid < n / mid) {
//                start = mid;
//            } else {
//                end = mid;
//            }
//        }
//
//        if (n % start == 0 && n / start == start) {
//            return true;
//        }
//
//        if (n % end == 0 && n / end == end) {
//            return true;
//        }
//        return false;
//    }

    // 数学法  n = 1 + 3 + 5 + 7 + ... + 2n + 1
    public boolean isPerfectSquare(int n) {
        int base = 1;
        while (n > 0) {
            n -= base;
            base += 2;
        }
        return n == 0;
    }

    public static void main(String[] args) {
        PerfectSquareNumber test = new PerfectSquareNumber();
        int n = 64;
        System.out.println(test.isPerfectSquare(n));
    }
}
