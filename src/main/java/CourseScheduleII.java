import java.util.*;

/**
 * Created by shuaiwang on 2/5/17.
 */
public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Write your code here
        int[] result = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();

        HashMap<Integer, Set<Integer>> parents = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            if (parents.containsKey(prerequisites[i][0])) {
                parents.get(prerequisites[i][0]).add(prerequisites[i][1]);
            } else {
                Set<Integer> p = new HashSet<>(Arrays.asList(prerequisites[i][1]));
                parents.put(prerequisites[i][0], p);
            }
        }

        for (int i = 0; i < numCourses; i++) {
            if (!parents.containsKey(i)) {
                queue.add(i);
            }
        }

        int index = 0;
        while (!queue.isEmpty()) {
            Integer current = queue.poll();
            result[index] = current;
            HashSet<Integer> removedKeys = new HashSet<>();
            for (Integer child : parents.keySet()) {
                Set<Integer> parentsList = parents.get(child);
                if (parentsList.contains(current)) {
                    parentsList.remove(current);
                }
                if (parentsList.isEmpty()) {
                    queue.add(child);
                    removedKeys.add(child);
                }
            }
            parents.keySet().removeAll(removedKeys);
            index++;
        }

        if (!parents.isEmpty()) {
            return new int[0];
        }

        return result;
    }

    //10, [[5,8],[3,5],[1,9],[4,5],[0,2],[1,9],[7,8],[4,9]]
    public static void main(String[] args) {
        int number = 10;
        int[][] pre = {{5,8}, {3,5}, {1,9}, {4,5}, {0,2}, {1,9}, {7,8}, {4,9}};
        CourseScheduleII test = new CourseScheduleII();
        test.findOrder(number, pre);
    }
}
