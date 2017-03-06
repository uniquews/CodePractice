import java.util.HashMap;

/**
 * Created by shuaiwang on 3/5/17.
 */
public class StrobogrammaticNumber {
    public boolean isStrobogrammatic(String num) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(1,1);
        hashMap.put(6,9);
        hashMap.put(9,6);
        hashMap.put(8,8);
        hashMap.put(0,0);


        int start = 0, end = num.length() - 1;
        while (start <= end) {
            int left = num.charAt(start) - '0';
            int right = num.charAt(end) - '0';

            if (Integer.valueOf(right).equals(hashMap.get(left))) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }
}
