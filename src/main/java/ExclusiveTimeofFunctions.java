import java.util.List;
import java.util.Stack;

/**
 * Created by shuaiwang on 8/26/17.
 */
public class ExclusiveTimeofFunctions {
//    class Node {
//        public int task;
//        public int startTime;
//        public Node (int t, int s) {
//            task = t;
//            startTime = s;
//        }
//    }
//    public int[] exclusiveTime(int n, List<String> logs) {
//        int[] result = new int[n];
//        Stack<Node> stk = new Stack<>();
//        for (int i = 0; i < logs.size(); i++) {
//            String[] log = logs.get(i).split(":");
//            int currentTask = Integer.valueOf(log[0]);
//            String flag = log[1];
//            int currentTime = Integer.valueOf(log[2]);
//
//            if (flag.equals("start")) {
//                if (!stk.isEmpty()) {
//                    result[stk.peek().task] += currentTime - stk.peek().startTime;
//                }
//                Node node = new Node(currentTask, currentTime);
//                stk.push(node);
//            } else {
//                Node startNode = stk.pop();
//                result[startNode.task] += currentTime - startNode.startTime + 1;
//                if (!stk.isEmpty()) {
//                    stk.peek().startTime = currentTime + 1;
//                }
//            }
//        }
//        return result;
//    }

    class Node {
        public int task;
        public int startTime;
        public Node(int t, int s) {
            task = t;
            startTime = s;
        }
    }
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Stack<Node> stk = new Stack<>();
        for (int i = 0; i < logs.size(); i++) {
            String[] current = logs.get(i).split(":");
            int task = Integer.valueOf(current[0]);
            String flag = current[1];
            int time = Integer.valueOf(current[2]);
            if (flag.equals("start")) {
                if (!stk.isEmpty()) {
                    result[stk.peek().task] += time - stk.peek().startTime;
                }
                stk.push(new Node(task, time));
            } else {
                Node node = stk.pop();
                result[task] += time - node.startTime + 1;
                if (!stk.isEmpty()) {
                    stk.peek().startTime = time + 1;
                }
            }
        }
        return result;
    }

}
