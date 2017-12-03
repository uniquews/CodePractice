public class MonotoneIncreasingDigits {
    public int monotoneIncreasingDigits(int N) {
        char[] num = String.valueOf(N).toCharArray();

        // find the cliff where num[i - 1] > num[i]
        int i = 1;
        while (i < num.length && num[i - 1] <= num[i]) {
            i++;
        }

        // decrement 1
        while (i > 0 && i < num.length && num[i - 1] > num[i]) { // i < num.length 1234 不加这个会越界
            i--;
            num[i]--;
        }

        i++;
        while (i < num.length ) {
            num[i++] = '9';
        }
        return Integer.valueOf(new String(num));
    }
}
