import java.util.Arrays;

/**
 * Created by shuaiwang on 3/28/17.
 */

/*
* 用int的后26位来表示26个字母，若为1， 说明该位置的字母出现过。每一个单词都可以用一个Int表示，
* 当两个单词的int表示&的结果为0时，则说明没有重复的字母
*
* */
public class MaximumProductOfWordLengths {
    public int maxProduct(String[] words) {
        int[] mask = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            int numberOfWord = 0;
            for (int j = 0; j < words[i].length(); j++) {
                numberOfWord = numberOfWord | 1 << (words[i].charAt(j) - 'a');
            }
            mask[i] = numberOfWord;
        }

        int max = 0;
        for (int i = 0; i < mask.length; i++) {
            for (int j = i + 1; j < mask.length; j++) {
                if ((mask[i] & mask[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }
}
