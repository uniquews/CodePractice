package fb;

public class CustomSort {

    class Node {
        char c;
        int occur;
        Node(char c) {
            this.c = c;
            this.occur = 0;
        }
    }
    public String sort(String dict, String s) {
        Node[] nodes = new Node[dict.length()];
        int[] indexMap = new int[26];

        for (int i = 0; i < dict.length(); i++) {
            Node n = new Node(dict.charAt(i));
            nodes[i] = n;
            indexMap[dict.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < s.length(); i++) {
            int index = indexMap[s.charAt(i) - 'a'];
            nodes[index].occur++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dict.length(); i++) {
            int times = nodes[i].occur;
            while (times > 0) {
                sb.append(nodes[i].c);
                times--;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        CustomSort test = new CustomSort();
        String dict = "xyzabc";
        String s = "cyxz"; // xyzc
        System.out.println(test.sort(dict, s));
    }
}
