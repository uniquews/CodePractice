import java.util.Stack;

/**
 * Created by shuaiwang on 2/22/17.
 */
public class LongestAbsoluteFilePath {
    public int lengthLongestPath(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }

        int currentLen = 0;
        int result = 0;
        Stack<Integer> stk = new Stack<>();
        String[] A = input.split("\n");

        for (int i = 0; i < A.length; i++) {
            int level = countTab(A[i]);
            if (stk.size() > level) {
                while (stk.size() > level) {
                    currentLen -= stk.pop();
                }
            }
            if (isFile(A[i])) {
                result = Math.max(result, currentLen + A[i].length() - level);
            } else {
                stk.push(A[i].length() - level + 1);
                currentLen += stk.peek();
            }
        }
        return result;
    }

    private int countTab(String str) {
        return str.lastIndexOf("\t") + 1;
    }

    private boolean isFile(String str) {
        return str.contains(".");
    }

    public static void main(String[] args) {
        LongestAbsoluteFilePath test = new LongestAbsoluteFilePath();
//        String input = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
        String input = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
        System.out.print(test.lengthLongestPath(input));
    }
}
