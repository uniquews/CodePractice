/**
 * Created by shuaiwang on 1/16/17.
 */
public class ShortestWordDistanceIII {
    public int shortestWordDistance(String[] words, String word1, String word2) {

        int index1 = -1, index2 = -1, gap = Integer.MAX_VALUE;
        int lastIndex1, lastIndex2 = -1;
        while (index1 < words.length && index2 < words.length) {
            lastIndex1 = index1;
            index1 = moveIndex(words, word1, index1, index2, lastIndex2);
            lastIndex2 = index2;
            index2 = moveIndex(words, word2, index2, index1, lastIndex1);

            if (index1 <= words.length - 1 && index2 <= words.length - 1) {
                gap = Math.min(gap, Math.abs(index1 - index2));
            }
        }
        return gap;
    }

    private int moveIndex(String[] words, String word1, int index1, int index2, int lastIndex2) {
        if (index1 > lastIndex2) {
            return index1;
        }

        index1++;
        while (index1 < words.length) {
            if (words[index1].equals(word1) && index1 != index2) {
                return index1;
            }
            index1++;
        }

        return index1;
    }



    public static void main(String[] args) {
        String[] words = {"a", "a", "c", "b"};
        String word1 = "a";
        String word2 = "b";
        ShortestWordDistanceIII test = new ShortestWordDistanceIII();
        System.out.print(test.shortestWordDistance(words, word1, word2));
    }
}
