import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by shuaiwang on 8/7/16.
 */
public class BinaryTreeLevelOrderTraversalII {
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        // write your code here
        ArrayList result = new ArrayList();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) {

            return result;
        }

        queue.offer(root);
        while (!queue.isEmpty()) {
            ArrayList level = new ArrayList();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                level.add(current.val);

                if (current.left != null) {
                    queue.offer(current.left);
                }

                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            result.add(0, level);
        }

        return result; // Collections.reverse(result);

    }


}
