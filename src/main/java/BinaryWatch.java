import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuaiwang on 3/19/17.
 */
public class BinaryWatch {
//    public List<String> readBinaryWatch(int num) {
//        List<String> result = new ArrayList<>();
//
//        for (int i = 0; i <= num && i <= 4; i++) {
//            List<Integer> hours = new ArrayList<>();
//            dfs(4, 0, 0, i, 0, hours, true);
//
//            List<Integer> minutes = new ArrayList<>();
//            int j = num - i;
//            dfs(6, 0, 0, j, 0, minutes, false);
//
//            combineHourAndMinute(result, hours, minutes);
//        }
//        return result;
//    }
//
//    private void dfs(int totalPoints, int position, int layer,
//                     int totalNumSelectedPoints, int sum, List<Integer> list, boolean isHours) {
//        if (layer == totalNumSelectedPoints) {
//            if (isHours && sum < 12) //没有大于12的小时
//                list.add(sum);
//            else if (!isHours && sum < 60) //没有大于60的分钟
//                list.add(sum);
//            return;
//        }
//
//        for (int i = position; i < totalPoints; i++) {
//            int current = 1 << i;
//            dfs(totalPoints, i + 1, layer + 1, totalNumSelectedPoints, sum + current, list, isHours);
//        }
//    }
//
//    // 小时的范围是 [0-11]，  分钟的范围是[0-59]
//    private void combineHourAndMinute(List<String> result, List<Integer> hours, List<Integer> minutes) {
//        // 1. 小时不能有leading zero
//        // 2. 分钟必须有leading zero
//        for (int i = 0; i < hours.size(); i++) {
//            for (int j = 0; j < minutes.size(); j++) {
//                int currentHour = hours.get(i);
//                int currentMinute = minutes.get(j);
//
//                String hour = String.valueOf(currentHour);
//                String minute;
//                if (currentMinute < 10) {
//                    StringBuilder sb = new StringBuilder();
//                    sb.append("0").append(String.valueOf(currentMinute));
//                    minute = sb.toString();
//                } else {
//                    minute = String.valueOf(currentMinute);
//                }
//                result.add(hour + ":" + minute);
//            }
//        }
//    }

    public List<String> readBinaryWatch(int num) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i <= num; i++) {
            List<Integer> hours = new ArrayList<>();
            List<Integer> minutes = new ArrayList<>();

            dfs(i, 0, 0, 4, 0, hours);
            dfs(num - i, 0, 0, 8, 0, minutes);

            for (int j = 0; j < hours.size(); j++) {
                if (hours.get(j) >= 12)
                    continue;
                for (int k = 0; k < minutes.size(); k++) {
                    if (minutes.get(k) >= 60)
                        continue;
                    if (minutes.get(k) < 10) {
                        result.add(hours.get(j) + ":0" + minutes.get(k));
                    } else {
                        result.add(hours.get(j) + ":" + minutes.get(k));
                    }
                }
            }
        }
        return result;
    }

    private void dfs(int total, int numOfUse, int index, int len, int sum, List<Integer> result) {
        if (total == numOfUse) {
            result.add(sum);
            return;
        }

        for (int i = index; i < len; i++) {
            int nextSum = (1 << i) + sum;
            dfs(total, numOfUse + 1, i + 1, len, nextSum, result);
        }
    }

    public static void main(String[] args) {
        BinaryWatch test = new BinaryWatch();
        test.readBinaryWatch(2);
    }
}
