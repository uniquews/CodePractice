import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuaiwang on 5/9/17.
 */
class TrieNode {
    // Initialize your data structure here.
    public TrieNode[] children;
    public boolean isWord;
    public String str;
    public TrieNode() {
        children = new TrieNode[26];
        isWord = false;
        str = "";
    }
}
public class KEditDistance {
    public class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // Inserts a word into the trie.
        public void insert(String word) {
            TrieNode parent = root;
            for (int i = 0; i < word.length(); i++) {
                int pos = word.charAt(i) - 'a';
                if (parent.children[pos] == null) {  //注意只要当parent[pos]没有 childNoded的时候才需要新建一个child
                    TrieNode child = new TrieNode();
                    parent.children[pos] = child;
                }
                parent = parent.children[pos];
                if (i == word.length() - 1) {
                    parent.isWord = true;
                    parent.str = word;
                }
            }
        }
    }

    public List<String> kDistance(String[] words, String target, int k) {
        // Write your code here
        Trie trieTree = new Trie();
        for (String s : words) {
            trieTree.insert(s);
        }

        List<String> result = new ArrayList<>();
        int[] dp = new int[target.length() + 1]; //相当于Edit Distance里 f[i][j]中的j
        for (int i = 0; i <= target.length(); i++) { // 相当于初始化f[0][j]
            dp[i] = i;
        }
        find(result, trieTree.root, target, k, dp);
        return result;
    }

    private void find(List<String> result, TrieNode node, String target, int k, int[] dp) {
        int n = target.length();
        if (node.isWord && dp[n] <= k) {
            result.add(node.str);
        }

        int[] nextDp = new int[dp.length]; // 相当于f[i][j], 要被下一轮递归用到
        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) {
                nextDp[0] = dp[0] + 1; // 相当于初始化f[i][0],每一个f[i][0]都是i，且一定是f[i - 1][0] + 1
                for (int j = 1; j <= n; j++) {
                    if (target.charAt(j - 1) - 'a' == i) {
                        nextDp[j] = dp[j - 1];
                    } else {
                        // dp[j - 1] 是f[i - 1][j - 1]    dp[j] 是f[i - 1][j] nextDp[j - 1] 是f[i][j - 1];
                        nextDp[j] = Math.min(dp[j - 1] + 1, Math.min(dp[j], nextDp[j - 1]) + 1);
                    }
                }
                find(result, node.children[i], target, k, nextDp);
            }
        }
    }
}
