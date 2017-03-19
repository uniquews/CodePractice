import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuaiwang on 3/19/17.
 */
public class BinaryWatch {
    public List<String> readBinaryWatch(int num) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i <= num && i <= 4; i++) {
            List<Integer> hours = new ArrayList<>();
            dfs(4, 0, 0, i, 0, hours, true);

            List<Integer> minutes = new ArrayList<>();
            int j = num - i;
            dfs(6, 0, 0, j, 0, minutes, false);

            combineHourAndMinute(result, hours, minutes);
        }
        return result;
    }

    private void dfs(int totalPoints, int position, int layer,
                     int totalNumSelectedPoints, int sum, List<Integer> list, boolean isHours) {
        if (layer == totalNumSelectedPoints) {
            if (isHours && sum < 12) //没有大于12的小时
                list.add(sum);
            else if (!isHours && sum <= 60) //没有大于60的分钟
                list.add(sum);
            return;
        }

        for (int i = position; i < totalPoints; i++) {
            int current = 1 << i;
            dfs(totalPoints, i + 1, layer + 1, totalNumSelectedPoints, sum + current, list, isHours);
        }
    }

    private void combineHourAndMinute(List<String> result, List<Integer> hours, List<Integer> minutes) {
        // 1. 小时不能有leading zero
        // 2. 分钟必须有leading zero
        // 3. 分钟等于60的时候要自动归零，小时加1，如果小时超过了12，就不加到result中
        for (int i = 0; i < hours.size(); i++) {
            for (int j = 0; j < minutes.size(); j++) {
                int currentHour = hours.get(i);
                int currentMinute = minutes.get(j);

                if (currentMinute == 60) {
                    currentMinute = 0;
                    currentHour += 1;
                }

                if (currentHour >= 12) {
                    continue;
                }

                String hour = String.valueOf(currentHour);
                String minute;
                if (currentMinute < 10) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("0").append(String.valueOf(currentMinute));
                    minute = sb.toString();
                } else {
                    minute = String.valueOf(currentMinute);
                }
                result.add(hour + ":" + minute);
            }
        }
    }

    public static void main(String[] args) {
        BinaryWatch test = new BinaryWatch();
        test.readBinaryWatch(1);
    }
}
