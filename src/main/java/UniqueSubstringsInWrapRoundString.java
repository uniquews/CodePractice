public class UniqueSubstringsInWrapRoundString {
    public int findSubstringInWraproundString(String p) {
        int[] dp = new int[26];
        int pos = 0;
        for (int i = 0; i < p.length(); i++) {
            if (i > 0 && (p.charAt(i) - p.charAt(i - 1) == 1 || p.charAt(i) == 'a' && p.charAt(i - 1) == 'z')) {
                pos++;
            } else {
                pos = 1;
            }
            dp[p.charAt(i) - 'a'] = Math.max(dp[p.charAt(i) - 'a'], pos);
        }
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            ans += dp[i];
        }
        return ans;
    }
}
