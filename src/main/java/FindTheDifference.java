/**
 * Created by shuaiwang on 3/18/17.
 */
public class FindTheDifference {
    //思路： 用t中所有的char 去抵消s中所有的char，剩下的就是结果
    public char findTheDifference(String s, String t) {
        int asciiCharDelta = (int)t.charAt(t.length() - 1);
        for (int i = 0; i < s.length(); i++) {
            asciiCharDelta -= (int)s.charAt(i);
            asciiCharDelta += (int)t.charAt(i);
        }
        return (char) asciiCharDelta;
    }
}
