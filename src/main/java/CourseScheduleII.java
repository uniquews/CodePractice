import java.util.*;

/**
 * Created by shuaiwang on 2/5/17.
 */
public class CourseScheduleII {
//    public int[] findOrder(int numCourses, int[][] prerequisites) {
//        Map<Integer, Set<Integer>> graph = new HashMap<>();
//        Map<Integer, Integer> degree = new HashMap<>();
//
//        for (int i = 0; i < numCourses; i++) {
//            degree.put(i, 0);
//            Set<Integer> p = new HashSet<>();
//            graph.put(i, p);
//        }
//
//        for (int i = 0; i < prerequisites.length; i++) {
//            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
//            degree.put(prerequisites[i][0], degree.get(prerequisites[i][0]) + 1);
//        }
//
//        Queue<Integer> queue = new LinkedList<>();
//        for (int i = 0; i < numCourses; i++) {
//            if (degree.get(i) == 0) {
//                queue.add(i);
//            }
//        }
//
//        int index = 0;
//        int count = 0;
//        int[] result = new int[numCourses];
//        while (!queue.isEmpty()) {
//            int course = queue.poll();
//            result[index++] = course;
//            count++;
//            Set<Integer> after = graph.get(course);
//            for (Integer c : after) {
//                degree.put(c, degree.get(c) - 1);
//                if (degree.get(c) == 0)
//                    queue.add(c);
//            }
//        }
//
//        if (count == numCourses)
//            return result;
//        else
//            return new int[0];
//    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> degree = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        String s = new String();
        s.substring(0,0);
        sb.substring(0,0);

        for (int i = 0; i < numCourses; i++) {
            degree.put(i, 0);
            List<Integer> p = new ArrayList<>();
            graph.put(i, p);
        }

        for (int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
            degree.put(prerequisites[i][0], degree.get(prerequisites[i][0]) + 1);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (degree.get(i) == 0) {
                queue.add(i);
            }
        }

        int index = 0;
        int count = 0;
        int[] result = new int[numCourses];
        while (!queue.isEmpty()) {
            int course = queue.poll();
            result[index++] = course;
            count++;
            List<Integer> after = graph.get(course);
            for (Integer c : after) {
                degree.put(c, degree.get(c) - 1);
                if (degree.get(c) == 0)
                    queue.add(c);
            }
        }

        if (count == numCourses)
            return result;
        else
            return new int[0];
    }

    //10, [[5,8],[3,5],[1,9],[4,5],[0,2],[1,9],[7,8],[4,9]]
    public static void main(String[] args) {
        int number = 10;
//        int number = 2;
        int[][] pre = {{5,8}, {3,5}, {1,9}, {4,5}, {0,2}, {1,9}, {7,8}, {4,9}};
//        int[][] pre = {{1,0}, {0,1}};

        CourseScheduleII test = new CourseScheduleII();
        test.findOrder(number, pre);
    }
}
