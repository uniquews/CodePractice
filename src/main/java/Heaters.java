import java.util.Arrays;

/**
 * Created by shuaiwang on 4/23/17.
 */
public class Heaters {
//    public int findRadius(int[] houses, int[] heaters) {
//        Arrays.sort(houses);
//        Arrays.sort(heaters);
//
//        int j = 0, result = 0;
//        for (int i = 0; i < houses.length; i++) {
//            int currentHouse = houses[i];
//            while (j + 1 < heaters.length && Math.abs(currentHouse - heaters[j + 1]) < Math.abs(currentHouse - heaters[j])) {
//                j++;
//            }
//            result = Math.max(result, Math.abs(heaters[j] - currentHouse));
//        }
//        return result;
//    }

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int radius = 0;
        for (int house : houses) {
            int index = Arrays.binarySearch(heaters, house); // 第一个大于等于house的index，所以比较距离的时候要和index - 1比
            if (index < 0) {
                index = -(index + 1);
            }
            int dist1 = index == 0 ? Integer.MAX_VALUE : Math.abs(house - heaters[index - 1]);
            int dist2 = index == heaters.length ? Integer.MAX_VALUE : Math.abs(house - heaters[index]);

            radius = Math.max(radius, Math.min(dist1, dist2)); // 保证最大的radius 是最后的结果，否则覆盖不到
        }
        return radius;
    }

    public static void main(String[] args) {
//        Heaters test = new Heaters();
//        System.out.print(test.findRadius(a, b));

        int[] a = {1,2,3};
        System.out.print(Arrays.binarySearch(a, 0));
    }

}
