import java.util.HashMap;

/**
 * Created by shuaiwang on 1/12/17.
 */
public class Logger {
    /** Initialize your data structure here. */
    HashMap<String, Integer> hashMap;
    public Logger() {
        hashMap = new HashMap<>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (hashMap.containsKey(message)) {
            int previousTime = hashMap.get(message);
            int gap = timestamp - previousTime;
            if (gap < 10) {
                return false;
            } else {
                hashMap.put(message, timestamp);
                return true;
            }
        } else {
            hashMap.put(message, timestamp);
            return true;
        }
    }
}
