/**
 * Created by shuaiwang on 1/24/17.
 */
public class FindPermutation {
    // 从1,2,3...n 初始化遇到连续的D 就reverse
    public int[] findPermutation(String s) {
        int[] result = new int[s.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            result[i] = i + 1;
        }

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'D') {
                int start = i;
                while (i + 1 < s.length() && s.charAt(i + 1) == 'D') {
                    i++;
                }
                reverse(result, start, i + 1);
            }
        }
        return result;
    }

    private void reverse(int[] result, int i, int j) {
        while (i < j) {
            int tmp = result[i];
            result[i] = result[j];
            result[j] = tmp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        String s = "DDIIDI";
        FindPermutation test = new FindPermutation();
        test.findPermutation(s);
    }
}
