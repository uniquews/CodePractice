import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * Created by shuaiwang on 7/7/17.
 */
public class StringPermutation {
    public boolean stringPermutation(String A, String B) {
        // Write your code here
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        return Arrays.equals(a, b);
    }

    public static void main(String[] args) {
        StringPermutation test = new StringPermutation();
        String A = "abcd";
        String B = "bcad";
        System.out.println(test.stringPermutation(A, B));
    }
}
