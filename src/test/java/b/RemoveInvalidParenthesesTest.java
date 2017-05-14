package b;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

/**
 * Created by bohan on 5/13/17.
 */
public class RemoveInvalidParenthesesTest {
    @Test
    public void test() {
        RemoveInvalidParentheses test = new RemoveInvalidParentheses();

        assertThat(test.removeInvalidParentheses("()())()")).containsExactly("()()()", "(())()");
    }
}
