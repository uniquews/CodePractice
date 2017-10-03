/**
 * Created by shuaiwang on 2/25/17.
 */
public class SentenceScreenFitting {
    //brute force
//    public int wordsTyping(String[] sentence, int rows, int cols) {
//        int r = 0;
//        int i = 0;
//        int cur = 0;
//        int count = 0;
//
//        while (r < rows) {
//            while (cur + sentence[i].length() <= cols) {
//                cur += sentence[i].length();
//                i++;
//                if (cur < cols) {
//                    cur++;
//                }
//
//                if (i == sentence.length) {
//                    count++;
//                    i = 0;
//                }
//            }
//            cur = 0;
//            r++;
//        }
//        return count;
//    }


    /**
     * start means the index in String s, which will be added to first position of current row
     * */
    public int wordsTyping(String[] sentence, int rows, int cols) {
        String s = String.join(" ", sentence) + " "; // append " " at the end for appending next group of sentence
        int start = 0, len = s.length();

        for (int i = 0; i < rows; i++) {
            start += cols;
            if (s.charAt(start % len) == ' ') {
                start++;
            } else {
                while (start > 0 && s.charAt((start - 1) % len) != ' ') {
                    start--;
                }
            }
        }
        return start / len;
    }

    public static void main(String[] args) {
        SentenceScreenFitting test = new SentenceScreenFitting();
        String[] input = {"hello","world"};
        int row = 2;
        int col = 8;
        System.out.print(test.wordsTyping(input, row, col));
    }
}
