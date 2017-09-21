import java.util.Stack;

public class VerifyPreorderSequenceInBinarySearchTree {
    public boolean verifyPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return true;
        }
        Stack<Integer> stk = new Stack<>();
        int low = -1;
        for (int n : preorder) {
            if (low > n) {
                return false;
            }

            //每次看到右子树，就要把左子树和根都pop出来。把low设置成根，判断右子树后面的是不是都比左子树和根大。
            // 不能只判断第一层，应该是每次遇到右子树都要做这样的判断。[1,3,4,2] 第一次low=1  第二次low=3
            while (!stk.isEmpty() && n > stk.peek()) {
                low = stk.pop();
            }
            stk.push(n);
        }
        return true;
    }
}
