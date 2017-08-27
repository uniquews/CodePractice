import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by shuaiwang on 8/26/17.
 */
public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] occur = new int[26];
        int[] valid = new int[26];

        for (char c : tasks) {
            occur[c - 'A']++;
        }

        int count = 0, index = 0;
        while (count < tasks.length) {
            int nextTask = getNextValid(occur, valid, index);
            if (nextTask != -1) {
                count++;
                valid[nextTask] = index + n + 1;
                occur[nextTask]--;
            }
            index++;
        }
        return index;
    }

    private int getNextValid(int[] occur, int[] valid, int index) {
        int maxOccur = 0, result = -1;
        for (int i = 0; i < 26; i++) {
            if (maxOccur < occur[i] && valid[i] <= index) {
                maxOccur = occur[i];
                result = i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TaskScheduler test = new TaskScheduler();
        char[] tasks = {'A','A','A','B','B','B'};
        System.out.print(test.leastInterval(tasks, 2));
    }
}
