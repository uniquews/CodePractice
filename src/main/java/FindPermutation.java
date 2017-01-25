/**
 * Created by shuaiwang on 1/24/17.
 */
public class FindPermutation {
    public int[] findPermutation(String s) {
        int len = s.length();
        int[] result = new int[len + 1];
        for (int i = 0; i <= len; i++) {
            result[i] = i + 1;
        }

        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == 'D') {
                int start = i;
                while (i < len && s.charAt(i) == 'D') {
                    i++;
                }
                reverse(result, start, i);
            }
        }
        return result;
    }

    private void reverse(int[] result, int start, int end) {
        while (start < end) {
            int tmp = result[start];
            result[start] = result[end];
            result[end] = tmp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        String s = "DDIIDI";
        FindPermutation test = new FindPermutation();
        test.findPermutation(s);
    }
}
