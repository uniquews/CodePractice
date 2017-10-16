package fb;

public class RemoveAcharacterFromAstringToMakePalindrome {
    public boolean form(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }

        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                return isPa(s, start + 1, end) || isPa(s, start, end - 1);
            }
        }
        return true;
    }

    private boolean isPa(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            } else {
                start++;
                end--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        RemoveAcharacterFromAstringToMakePalindrome test = new RemoveAcharacterFromAstringToMakePalindrome();
//        String s = "abcba";
//        String s = "abcbea";
        String s = "abecbea";
        System.out.println(test.form(s));
    }
}
