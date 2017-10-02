package fb;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CourseSchedule {
    public int courseSchedule(int[][] course, int n) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < course.length; i++) {
            map.put(course[i][0], new HashSet<>());
            map.put(course[i][1], new HashSet<>());
        }
        for (int i = 0; i < course.length; i++) {
            Set<Integer> pre = map.get(course[i][0]);
            pre.add(course[i][1]);
            map.put(course[i][0], pre);
        }
        return helper(map, visited, n);
    }

    private int helper(Map<Integer, Set<Integer>> map, Set<Integer> visited, int n) {
        if (visited.contains(n)) {
            return 0;
        }
        visited.add(n);
        if (map.get(n).isEmpty()) {
            return 1;
        }

        Set<Integer> pre = map.get(n);
        int result = 1;
        for (Integer p : pre) {
            result += helper(map, visited, p);
        }
        return result;
    }

    public static void main(String[] args) {
//        int[][] course = {{1,0},{2,0},{3,1},{3,2}};
        int[][] course = {{3,0},{4,3},{2,1},{4,2},{2,3},{5,4}};
        CourseSchedule test = new CourseSchedule();
        System.out.println(test.courseSchedule(course, 5));
    }
}
