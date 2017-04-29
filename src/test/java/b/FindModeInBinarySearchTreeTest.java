package b;

import org.junit.Test;
import utils.BinaryTreeUtils;
import utils.TreeNode;

import static com.google.common.truth.Truth.assertThat;

/**
 * Created by bohan on 4/29/17.
 */
public class FindModeInBinarySearchTreeTest {
    @Test
    public void test() {
        TreeNode root = BinaryTreeUtils.deserialize("1,#,2,2");
        FindModeInBinarySearchTree test = new FindModeInBinarySearchTree();
        assertThat(test.findMode(root)).isEqualTo(new int[]{2});
    }

    @Test
    public void test2() {
        TreeNode root = BinaryTreeUtils.deserialize(String.valueOf(Integer.MAX_VALUE));
        FindModeInBinarySearchTree test = new FindModeInBinarySearchTree();
        assertThat(test.findMode(root)).isEqualTo(new int[]{Integer.MAX_VALUE});
    }

    @Test
    public void test3() {
        TreeNode root = BinaryTreeUtils.deserialize("1,#,2");
        FindModeInBinarySearchTree test = new FindModeInBinarySearchTree();
        assertThat(test.findMode(root)).isEqualTo(new int[]{1, 2});
    }

    @Test
    public void test4() {
        TreeNode root = BinaryTreeUtils.deserialize("2,1,2");
        FindModeInBinarySearchTree test = new FindModeInBinarySearchTree();
        assertThat(test.findMode(root)).isEqualTo(new int[]{2});
    }
}
