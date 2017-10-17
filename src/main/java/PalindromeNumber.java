public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x<0 || (x!=0 && x%10==0)) {
            return false;
        }
        int rev = 0;
        while (x > rev){
            rev = rev*10 + x%10;
            x = x/10;
        }
        return (x==rev || x==rev/10);
    }

//    public boolean isPalindrome(int x) {
//        if (x < 0) {
//            return false;
//        }
//
//        if (x < 10) {
//            return true;
//        }
//
//        int result = 0;
//        int pivot = x;
//        while (x > 0) {
//            result = result * 10 + x % 10;
//            x = x / 10;
//        }
//        return  pivot == result;
//    }

    //  错误方法
//    public boolean isPalindrome(int x) {
//        if (x < 0) {
//            return false;
//        }
//
//        if (x < 10) {
//            return true;
//        }
//
//        int base = 1;
//        while (base * 10 <= x) {
//            base *= 10;
//        }
//
//        while (x >= 10) {
//            int start = x / base;
//            int tmp = x % base; //这个方法不对， 1021 会把0抹掉
//            int end = x % 10;
//            if (start != end) {
//                return false;
//            }
//            x = tmp / 10;
//        }
//        return true;
//    }

    public static void main(String[] args) {
//        int x = 1021;
        int x = 232;
        PalindromeNumber test = new PalindromeNumber();
        System.out.println(test.isPalindrome(x));
    }
}
