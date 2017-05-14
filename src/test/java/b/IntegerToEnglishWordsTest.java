package b;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

/**
 * Created by bohan on 5/13/17.
 */
public class IntegerToEnglishWordsTest {
    @Test
    public void test() {
        IntegerToEnglishWords test = new IntegerToEnglishWords();
        assertThat(test.numberToWords(12345)).isEqualTo("Twelve Thousand Three Hundred Forty Five");
    }

    @Test
    public void test2() {
        IntegerToEnglishWords test = new IntegerToEnglishWords();
        assertThat(test.numberToWords(1234567))
                .isEqualTo("One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven");
    }

    @Test
    public void test3() {
        IntegerToEnglishWords test = new IntegerToEnglishWords();
        assertThat(test.numberToWords(1000000))
                .isEqualTo("One Million");
    }
}
