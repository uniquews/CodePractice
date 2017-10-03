package fb;

import java.util.HashMap;
import java.util.Map;

/**
 # Tasks: 1, 1, 2, 1
 # Recovery interval (cooldown): 2
 # Output: 7  (order is 1 _ _ 1 2 _ 1)
 # Example 2

 # Tasks: 1, 2, 3, 1, 2, 3
 # Recovery interval (cooldown): 3
 # Output: 7  (order is 1 2 3 _ 1 2 3)

 # Example 3

 # Tasks: 1, 2, 3 ,4, 5, 6, 2, 4, 6, 1, 2, 4
 # Recovery interval (cooldown): 6
 # Output: 18  (1 2 3 4 5 6 _ _ 2 _ 4 _ 6 1 _ 2 _ 4).
 * */
public class TaskSchedulerSort {
    public int taskSchedule(char[] tasks, int k) {
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < tasks.length; i++) {
            if (!map.containsKey(tasks[i]) || map.get(tasks[i]) <= sb.length()) {
                map.put(tasks[i], sb.length() + k + 1);
                sb.append(tasks[i]);
            } else {
                sb.append('_');
                i--;
            }
        }
        return sb.length();
    }

    public static void main(String[] args) {
        TaskSchedulerSort test = new TaskSchedulerSort();
//        char[] a = {'1', '1', '2', '1'};
//        int k = 2;
//        char[] a = {'1', '2', '3', '1', '2', '3'};
//        int k = 3;
        char[] a = {'1', '2', '3' ,'4', '5', '6', '2', '4', '6', '1', '2', '4'};
        int k = 6;
        System.out.print(test.taskSchedule(a, k));
    }
}
