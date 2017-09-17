import java.util.*;

/**
 * Created by shuaiwang on 5/13/17.
 */
public class RemoveInvalidParentheses {
//    public List<String> removeInvalidParentheses(String s) {
//        List<String> result = new ArrayList<>();
//        Set<String> visited = new HashSet<>();
//        Queue<String> q = new LinkedList<>();
//
//        q.add(s);
//        visited.add(s);
//        while (!q.isEmpty()) {
//            int size = q.size();
//            boolean found = false;
//            while (size > 0) {
//                String current = q.poll();
//                if (isValid(current)) {
//                    result.add(current);
//                    found = true;
//                }
//                for (int i = 0; i < current.length(); i++) {
//                    String next = current.substring(0, i) + current.substring(i + 1);
//                    if (!visited.contains(next)) {
//                        q.add(next);
//                        visited.add(next);
//                    }
//                }
//                size--;
//            }
//            if (found) {
//                break;
//            }
//        }
//        return result;
//    }
//
//    private boolean isValid(String s) {
//        int count = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if (Character.isLetter(s.charAt(i))) {
//                continue;
//            }
//            if (s.charAt(i) == '(') {
//                count++;
//            } else {
//                count--;
//            }
//            if (count < 0) {
//                return false;
//            }
//        }
//        return count == 0;
//    }


    /**
     *
     * j == last_j || s.charAt(j - 1) != par[1] 表示哪一位该被删除
     * 因为上一次删除之后j + 1位变成j last_j 记录了这个j  所以当j  (其实是上一次的j + 1) = last_j 时要删除
     * 然而在同一层中，当j位是) 但是j - 1位也是）时，则不删，因为这样会generate 重复的dfs搜索
     *
     * index i之前的部分都是valid的，因为我们碰到不valid的就dfs了
     *
     * int j = last_j 而不是等于0  因为等于0也会生成重复：
     *
     * 比如将 ((k() reverse之后变成了
     *
     * 假设我们让j = 0
     * )(k((
     * 递归过程是：
     * i = 3，j = 1， 删除j位的( => )k((
     * dfs i从3开始，又不valid了，新的dfs j = 0，移动到 j = 2时删除( => )k(
     * dfs之后发现valid 将(k)加入结果集，退出 回到 )k((
     * j 继续增加到 j = 3 因为 j = 1 是第一个满足s.charAt(j) == par[1] && (j == last_j || s.charAt(j - 1) != par[1]), 所以避免了删除最后一个( 回到 => )(k((
     * 此时i = 3， j = 1 j增加到3可以删除 => )(k(
     * 由于j = 0 所以j增加到1的时候， 把 (删除了，=> )k(
     * dfs之后发现valid讲(k)又加入结果集，因此有重复
     *
     *
     * 如果我们每一次让j = last_j
     * i = 3，j = 1， 删除j位的( => )k((
     * j从1开始 （因为前面的都valid）j = 2时删除( => )k(
     * dfs加入结果集(k)
     *
     * s.charAt(j) == par[1] && (j == last_j || s.charAt(j - 1) != par[1]) 跳过最后一个( 回到 )k((
     * j 走到末尾，直接return 回 )(k((
     * 此时i = 3， j = 1 j增加到3可以删除 => )(k(
     * i = 3, j = 3 删除末尾的(  得到)(k
     *
     *
     *
     * */
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        remove(s, ans, 0, 0, new char[]{'(', ')'});
        return ans;
    }

    public void remove(String s, List<String> ans, int last_i, int last_j,  char[] par) {
        for (int stack = 0, i = last_i; i < s.length(); ++i) {
            if (s.charAt(i) == par[0]) stack++;
            if (s.charAt(i) == par[1]) stack--;
            if (stack >= 0) continue;
            for (int j = last_j; j <= i; ++j)
                if (s.charAt(j) == par[1] && (j == last_j || s.charAt(j - 1) != par[1]))
                    remove(s.substring(0, j) + s.substring(j + 1, s.length()), ans, i, j, par);
            return;
        }
        String reversed = new StringBuilder(s).reverse().toString();
        if (par[0] == '(') // finished left to right  // 如果此时已经是() 也不会被add， 要等reverse被遍历后才会被add
            remove(reversed, ans, 0, 0, new char[]{')', '('});
        else // finished right to left
            ans.add(reversed);
    }

    public static void main(String[] args) {
//        String a = "()())()"; // j == last_j || s.charAt(j - 1) != par[1]
//        String a = "((k()"; // for (int j = last_j; j <= i; ++j)
        String a = "())";
        RemoveInvalidParentheses test = new RemoveInvalidParentheses();
        test.removeInvalidParentheses(a);
    }
}
