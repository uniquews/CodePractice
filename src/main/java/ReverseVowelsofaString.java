import java.util.HashSet;

/**
 * Created by shuaiwang on 3/12/17.
 */
public class ReverseVowelsofaString {

    // stringbuilder is slower than char array, string builder will tle
    public String reverseVowels(String s) {
        HashSet<Character> hashSet = new HashSet<>();
        hashSet.add('a');
        hashSet.add('e');
        hashSet.add('i');
        hashSet.add('o');
        hashSet.add('u');
        hashSet.add('A');
        hashSet.add('E');
        hashSet.add('I');
        hashSet.add('O');
        hashSet.add('U');

        char[] input = s.toCharArray();

        int start = 0, end = s.length() - 1;
        while (start < end) {
            while (start < end && !hashSet.contains(input[start])) {
                start++;
            }

            while (end > start && !hashSet.contains(input[end])) {
                end--;
            }

            char tmp = input[start];
            input[start] = input[end];
            input[end] = tmp;
            start++;
            end--;
        }
        return new String(input);
    }

    public static void main(String[] args) {
        ReverseVowelsofaString test = new ReverseVowelsofaString();
        String s = "leetcode";
        System.out.println(test.reverseVowels(s));
        System.out.println(s);
    }
}
