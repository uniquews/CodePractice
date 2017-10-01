import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by shuaiwang on 5/21/17.
 */
public class TextJustification {

    /**
     *
     * 如果一行只有一个单词，要用空格补齐
     *
     * 每一行要先放第一个单词
     * */
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        List<String> line = new ArrayList<>();

        int sumLenOfWords = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() + sumLenOfWords + line.size() <= maxWidth) {
                sumLenOfWords += words[i].length();
                line.add(words[i]);
            } else {
                getEachLine(result, line, maxWidth, sumLenOfWords);
                line.clear();
                line.add(words[i]);
                sumLenOfWords = words[i].length();
            }
        }
        getLastLine(result, line, maxWidth);
        return result;
    }

    private void getEachLine(List<String> result, List<String> line, int maxWidth, int sumLenOfWords) {
        int spaces = maxWidth - sumLenOfWords;
        StringBuilder sb = new StringBuilder();
        sb.append(line.get(0));

        for (int i = 1; i < line.size(); i++) {
            int count = spaces % (line.size() - i) == 0 ? spaces / (line.size() - i) : spaces / (line.size() - i) + 1;
            sb.append(appendSpaces(line.get(i), count));
            spaces -= count;
        }

        while (spaces > 0) {
            sb.append(" ");
            spaces--;
        }
        result.add(sb.toString());
    }

    private String appendSpaces(String s, int count) {
        while (count > 0) {
            s = " " + s;
            count--;
        }
        return s;
    }

    private void getLastLine(List<String> result, List<String> line, int maxWidth) {
        StringBuilder sb = new StringBuilder();
        int sum = line.get(0).length();
        sb.append(line.get(0));
        for (int i = 1; i < line.size(); i++) {
            sb.append(" ").append(line.get(i));
            sum += line.get(i).length();
            sum++;
        }

        while (sum < maxWidth) {
            sb.append(" ");
            sum++;
        }
        result.add(sb.toString());
    }

    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        TextJustification test = new TextJustification();
        test.fullJustify(words, 16);
    }

}
