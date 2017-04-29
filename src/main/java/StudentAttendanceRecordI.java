/**
 * Created by shuaiwang on 4/27/17.
 */
public class StudentAttendanceRecordI {
    public boolean checkRecord(String s) {
        int numOfA = 0, numOfL = 0, maxLenOfL = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                numOfL++;
                maxLenOfL = Math.max(maxLenOfL, numOfL);
            } else {
                if (s.charAt(i) == 'A') {
                    numOfA++;
                }
                numOfL = 0;
            }

        }
        return numOfA <= 1 && maxLenOfL <= 2;
    }
}
