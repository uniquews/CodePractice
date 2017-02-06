import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by shuaiwang on 2/5/17.
 */
public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Write your code here
        int[] result = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();

        Map<Integer, List<Integer>> parents = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            if (parents.containsKey(prerequisite[0])) {
                List<Integer> p = parents.get(prerequisite[0]);
                p.add(prerequisite[1]);
                parents.put(prerequisite[0], p);
            } else {
                List<Integer> p = new LinkedList<>(Arrays.asList(prerequisite[1]));
                parents.put(prerequisite[0], p);
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
            for (Integer key : parents.keySet()) {
                List<Integer> parentsList = parents.get(key);
                if (parentsList.contains(current)) {
                    parentsList.remove(current);
                }
                if (parentsList.isEmpty()) {
                    queue.add(key);
                }
            }
            index++;
        }

        if (!parents.isEmpty()) {
            return new int[numCourses];
        }

        return result;
    }

    public static void main(String[] args) {
        int number = 4;
        int[][] pre = {{1,0}, {2,0}, {3,1}, {3,2}};
        CourseScheduleII test = new CourseScheduleII();
        test.findOrder(number, pre);
    }
}
