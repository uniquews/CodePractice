import utils.TreeNode;

import java.util.ArrayList;

/**
 * Created by shuaiwang on 7/31/16.
 */
public class BinaryTreeLevelOrderTraversal {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // write your code here

        // normal bfs
//        ArrayList result = new ArrayList();
//        Queue<TreeNode> queue = new LinkedList<>();
//
//        if (root == null)
//        {
//
//            return result;
//        }
//
//        queue.offer(root);
//        while (!queue.isEmpty())
//        {
//            ArrayList level = new ArrayList();
//            int size = queue.size();
//            for (int i = 0; i < size; i++)
//            {
//                TreeNode current = queue.poll();
//                level.add(current.val);
//
//                if (current.left != null)
//                {
//                    queue.offer(current.left);
//                }
//
//                if (current.right != null)
//                {
//                    queue.offer(current.right);
//                }
//            }
//            result.add(level);
//        }
//
//        return result;

        //dfs
        ArrayList result = new ArrayList();

        int targetLevel = 0;

        while (true) {
            ArrayList<Integer> level = new ArrayList<>();
            dfs(root, level, 0, targetLevel);
            if (level.isEmpty()) {
                break;
            }

            result.add(level);
            targetLevel++;
        }
        return result;
    }

    private void dfs(TreeNode n, ArrayList<Integer> level, int currentLevel, int targetLevel) {
        if (n == null) {
            return;
        }

        if (currentLevel == targetLevel) {
            level.add(n.val);
            return;
        }

        dfs(n.left, level, currentLevel + 1, targetLevel);
        dfs(n.right, level, currentLevel + 1, targetLevel);
    }
}
