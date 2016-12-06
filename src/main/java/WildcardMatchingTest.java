/**
 * Created by shuaiwang on 9/12/16.
 */
public class WildcardMatchingTest {
    public static void main(String[] args) {

        WildcardMatching test = new WildcardMatching();

        String s = "aa";
        String p = "*";

        System.out.println(test.isMatch(s, p));

//        TreeNode result = test.deserialize(test.serialize(a));
//        System.out.println(test.serialize(result));
    }
}
