public class PalindromicSubstrings {
    int total = 0;
    public int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            helper(s, i, i);
            helper(s, i, i + 1);
        }
        return total;
    }

    private void helper(String s, int l, int r) {
        int count = 0;
        while (l >= 0 && r < s.length()) {
            if (s.charAt(l) == s.charAt(r)) {
                count++;
                l--;
                r++;
            } else {
                break;
            }
        }
        total += count;
    }
}
