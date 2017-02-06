import java.util.*;

/**
 * Created by shuaiwang on 2/5/17.
 */
public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Write your code here
        int[] result = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();

        HashMap<Integer, List<Integer>> parents = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            if (parents.containsKey(prerequisites[i][0])) {
                List p = parents.get(prerequisites[i][0]);
                p.add(prerequisites[i][1]);
                parents.put(prerequisites[i][0], p);
            } else {
                List<Integer> p = new LinkedList<>(Arrays.asList(prerequisites[i][1]));
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
            Iterator<Integer> iter = parents.keySet().iterator();
            while (iter.hasNext()) {
                List parentsList = parents.get(iter.next());
                if (parentsList.contains(current)) {
                    parentsList.remove(current);
                }
                if (parentsList.isEmpty()) {
                    queue.add(iter.next());
                    parents.remove(current);
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
