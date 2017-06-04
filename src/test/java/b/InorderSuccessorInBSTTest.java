package b;

import org.junit.Test;
import utils.BinaryTreeUtils;
import utils.TreeNode;

import static com.google.common.truth.Truth.assertThat;

/**
 * Created by bohan on 5/14/17.
 */
public class InorderSuccessorInBSTTest {
    @Test
    public void test() {
        TreeNode root = BinaryTreeUtils.deserialize("4,2,5,1,3");
        InorderSuccessorInBST test = new InorderSuccessorInBST();
        assertThat(test.inorderSuccessor(root, new TreeNode(3)).val).isEqualTo(4);
    }

    @Test
    public void test2() {
        TreeNode root = BinaryTreeUtils.deserialize("4,2,5,1,3");
        InorderSuccessorInBST test = new InorderSuccessorInBST();
        assertThat(test.inorderSuccessor(root, new TreeNode(2)).val).isEqualTo(3);
    }

    @Test
    public void test3() {
        TreeNode root = BinaryTreeUtils.deserialize("1");
        InorderSuccessorInBST test = new InorderSuccessorInBST();
        assertThat(test.inorderSuccessor(root, new TreeNode(1))).isNull();
    }
}
