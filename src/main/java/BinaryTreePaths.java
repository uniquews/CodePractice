import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuaiwang on 2/5/17.
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        // Write your code here
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        divideAndConquor(root, sb, result);
        return result;
    }

    private void divideAndConquor(TreeNode n, StringBuilder sb, List<String> list) {
        if (n == null) {
            return;
        }

        if (n.left == null && n.right == null) {
            sb.append(n.val);
            list.add(sb.toString());
            return;
        }

        StringBuilder sb2 = new StringBuilder(sb);
        sb2.append(n.val).append("->");
        divideAndConquor(n.left, sb2, list);

        StringBuilder sb3 = new StringBuilder(sb);
        sb3.append(n.val).append("->");
        divideAndConquor(n.right, sb3, list);
        return;
    }
}
