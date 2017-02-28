import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by shuaiwang on 2/26/17.
 */
public class ValidWordSquare {
    public boolean validWordSquare(List<String> words) {
        for (int i = 0; i < words.size(); i++) {
            String comp1 = words.get(i);
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < words.size(); j++) {
                if (i < words.get(j).length()) {
                    sb.append(words.get(j).charAt(i));
                }
            }

            if (!comp1.equals(sb.toString())) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<String> input = new ArrayList<>(Arrays.asList("abcd","bnrt","crmy","dtye"));
        ValidWordSquare test = new ValidWordSquare();
        test.validWordSquare(input);

    }
}
