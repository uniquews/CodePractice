/**
 * Created by shuaiwang on 6/18/17.
 */
public class ImplementstrStr {

    /**
     * haystack = aaaa...aaaaa
     * needle = aaaa.....aaaab
     * sanem length
     * */
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null)
            return -1;

        if (haystack.length() == 0 && needle.length() == 0)
            return 0;

        int index = -1;
        for (int i = 0; i <= haystack.length() - needle.length(); i++) { //注意这个条件 否则会TLE
            int j = 0;
            while (j < needle.length() && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }

            if (j == needle.length()) {
                index = i;
                break;
            }
        }
        return index;
    }
}
