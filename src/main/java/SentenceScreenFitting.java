/**
 * Created by shuaiwang on 2/25/17.
 */
public class SentenceScreenFitting {
    //brute force
//    public int wordsTyping(String[] sentence, int rows, int cols) {
//        int count = rows * cols;
//
//        int i = 0;
//        int j = 0;
//        int result = 0;
//        while (j < count) {
//            int c  = j % cols;
//            int remain = cols - c;
//            if (sentence[i].length() < remain) {
//                j = j + sentence[i].length() + 1;
//                i++;
//            } else if (sentence[i].length() == remain) {
//                j = j + sentence[i].length();
//                i++;
//            } else {
//                j = remain + j;
//            }
//
//            if (i == sentence.length) {
//                result++;
//                i = 0;
//            }
//        }
//        return result;
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
