import java.util.*;

/**
 * Created by shuaiwang on 4/13/17.
 */
public class PhoneDirectory {
    //返回的顺序不固定，题目也没说明
//    /** Initialize your data structure here
//     @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
//
//    private HashSet<Integer> used;
//    private Queue<Integer> notUsed;
//    public PhoneDirectory(int maxNumbers) {
//        used = new HashSet<>();
//        notUsed = new LinkedList<>();
//
//        for (int i = 0; i < maxNumbers; i++) {
//            notUsed.add(i);
//        }
//    }
//
//    /** Provide a number which is not assigned to anyone.
//     @return - Return an available number. Return -1 if none is available. */
//    public int get() {
//        if (notUsed.isEmpty()) {
//            return -1;
//        }
//        int result = notUsed.poll();
//        used.add(result);
//        return result;
//    }
//
//    /** Check if a number is available or not. */
//    public boolean check(int number) {
//        return !used.contains(number);
//    }
//
//    /** Recycle or release a number. */
//    public void release(int number) {
//        if (used.contains(number)) {
//            used.remove(number);
//            notUsed.add(number);
//        }
//    }

    private Set<Integer> used;
    private Queue<Integer> notUsed;
    public PhoneDirectory(int maxNumbers) {
        used = new HashSet<>();
        notUsed = new LinkedList<>();
        for (int i = 0; i < maxNumbers; i++) {
            notUsed.add(i);
        }
    }

    /** Provide a number which is not assigned to anyone.
     @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if (notUsed.isEmpty())
            return -1;
        int result = notUsed.poll();
        used.add(result);
        return result;
    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
        return !used.contains(number);
    }

    /** Recycle or release a number. */
    public void release(int number) {
        if (used.contains(number)) {
            used.remove(number);
            notUsed.add(number);
        }
    }

}
