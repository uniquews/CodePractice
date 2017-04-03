/**
 * Created by shuaiwang on 4/2/17.
 */
public class RearrangeStringKDistanceApart {
    public String rearrangeString(String s, int k) {
        int[] count = new int[26];
        int[] valid = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int c = findValidMax(count, valid, i);

            if (c == - 1) return "";

            count[c]--;
            valid[c] = i + k;
            sb.append((char)('a' + c));
        }
        return sb.toString();
    }

    private int findValidMax(int[] count, int[] valid, int index) {
        int max = Integer.MIN_VALUE;
        int indexOfMax = -1;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0 && count[i] > max && valid[i] <= index) {
                max = count[i];
                indexOfMax = i;
            }
        }
        return indexOfMax;
    }
}
