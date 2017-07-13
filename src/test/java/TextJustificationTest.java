import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by shuaiwang on 5/21/17.
 */
public class TextJustificationTest {
    @Test
    public void test() {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        TextJustification test = new TextJustification();
        System.out.print(test.fullJustify(words, 16));
    }

    @Test
    public void test1() {
        String[] words = {"What","must","be","shall","be."};
        TextJustification test = new TextJustification();
        System.out.print(test.fullJustify(words, 12));
    }

    @Test
    public void test2() {
        String[] words = {"Here","is","an","example","of","text","justification."};
        TextJustification test = new TextJustification();
        System.out.print(test.fullJustify(words, 16));
    }

    @Test
    public void test3() {
        String[] words = {"My","momma","always","said,","\"Life","was","like","a","box","of","chocolates.","You","never","know","what","you're","gonna","get."};
        TextJustification test = new TextJustification();
        System.out.print(test.fullJustify(words, 20));
    }
}
