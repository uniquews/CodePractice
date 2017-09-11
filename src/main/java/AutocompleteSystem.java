import java.util.*;

/**
 * Created by shuaiwang on 9/9/17.
 */
public class AutocompleteSystem {
    class TrieNode {
        public TrieNode[] children;
        public int count;
        public TrieNode() {
            children = new TrieNode[27];
            count = 0;
        }
    }

    class Trie {
        public TrieNode root;
        public Trie() {
            root = new TrieNode();
        }

        public void init(String s, int times) {
            TrieNode current = root;
            for (int i = 0; i < s.length(); i++) {
                current = traverse(s.charAt(i), current);
            }
            current.count = times;
        }

        private TrieNode traverse(char c, TrieNode current) {
            if (c == ' ') {
                if (current.children[26] == null) {
                    current.children[26] = new TrieNode();
                }
                current = current.children[26];
            } else {
                if (current.children[c - 'a'] == null) {
                    current.children[c - 'a'] = new TrieNode();
                }
                current = current.children[c - 'a'];
            }
            return current;
        }

        public TrieNode startWith(TrieNode current, char c, String s, List<Node> result) {
            if (c == '#')
                return current;
            TrieNode nextCurrent = traverse(c, current);
            dfs(nextCurrent, s + c, result);
            if (c == ' ') {
                return current.children[26];
            } else {
                return current.children[c - 'a'];
            }
        }

        private void dfs(TrieNode current, String s, List<Node> result) {
            if (current == null) {
                return;
            }

            if (current.count > 0) {
                result.add(new Node(s, current.count));
            }

            for (int i = 0; i < current.children.length; i++) {
                if (current.children[i] != null) {
                    if (i == 26) {
                        dfs(current.children[i], s + ' ', result);
                    } else {
                        dfs(current.children[i], s + (char)('a' + i), result);
                    }
                }
            }
        }
    }

    class Node {
        public String s;
        public int count;
        public Node(String ss, int cc) {
            s = ss;
            count = cc;
        }
    }

    private Trie trie;
    private TrieNode current;
    private String prefix;
    public AutocompleteSystem(String[] sentences, int[] times) {
        trie = new Trie();
        for (int i = 0; i < sentences.length; i++) {
            trie.init(sentences[i], times[i]);
        }
        current = trie.root;
        prefix = "";
    }

    public List<String> input(char c) {
        List<Node> result = new ArrayList<>();
        current = trie.startWith(current, c, prefix, result);
        if (c == '#') {
            current.count++;
            prefix = "";
            current = trie.root;
        } else {
            prefix += c;
        }

        Queue<Node> q = new PriorityQueue<>((o1, o2) -> {
            if (o1.count != o2.count) {
                return o2.count - o1.count;
            } else {
                return o1.s.compareTo(o2.s);
            }
        });
        q.addAll(result);
        List<String> ff = new ArrayList<>();
        int num = 3;
        while (num > 0 && !q.isEmpty()) {
            ff.add(q.poll().s);
            num--;
        }
        return ff;
    }

    public static void main(String[] args) {
        /**
         * ["AutocompleteSystem","input","input","input","input","input","input","input","input","input","input","input","input","input","input"]
         [[["abc","abbc","a"],[3,3,3]],["b"],["c"],["#"],["b"],["c"],["#"],["a"],["b"],["c"],["#"],["a"],["b"],["c"],["#"]]
         *
         * */

        /**
         *
         * ["AutocompleteSystem","input","input","input","input","input","input","input","input","input","input","input","input"]
         [[["i love you","island","iroman","i love leetcode"],[5,3,2,2]],["i"],[" "],["a"],["#"],["i"],[" "],["a"],["#"],["i"],[" "],["a"],["#"]]
         *
         * */
        String[] s = {"i love you","island","iroman","i love leetcode"};
        int[] times = {5,3,3,2};
        AutocompleteSystem test = new AutocompleteSystem(s, times);
        test.input('i');
        test.input(' ');
        test.input('a');
        test.input('#');
        test.input('i');
        List<String> result = test.input('#');

        System.out.println(result);
    }
}
