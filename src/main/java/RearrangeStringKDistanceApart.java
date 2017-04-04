/**
 * Created by shuaiwang on 4/2/17.
 */

/**
 * count 数组表示每个char出现的次数
 * valid 数组表示每个char下一次出现的valid的位置
 * findValidMax 数组是从头扫描count数组一遍，但是由于count数组的size是固定的26，所以是常数时间。
 * 贪心的思路是：每次选取remaining count 最大的， 且当前位置是valid的字符
 *
 * 反证法证明一下这道题为什么贪心是对的
 * 假设每次选取remaining count是最大的且是当前输入下的唯一的正确解。只要证明如果我们不遵循这个规则
 * 就一定不能得到唯一的正确解，则就能证明这个贪心是对的
 *
 * 假设一种极端情况，只有一个正解。有一个char c出现了n次，string s的总长度正好是n * k = len
 * 如果在中间某一步在每k次的位置放的不是n 那么有两个c之间的位置会大于k, 这样排下来总长度会大于len
 * 与条件矛盾，所以在极端情况也也只能用这种贪心的方法找到最优解
 *
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
