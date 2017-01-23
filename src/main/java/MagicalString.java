/**
 * Created by shuaiwang on 1/22/17.
 */
public class MagicalString {
    public int magicalString(int n) {
        if (n == 0) {
            return 0;
        }
        if (n <= 3) {
            return 1;
        }
        int[] result = new int[n];
        result[0] = 1;
        result[1] = 2;
        result[2] = 2;
        int numOfOne = 1;

        int groupIndex = result[2];
        int currentIndex = 3;
        while (currentIndex < n) {
            if (result[groupIndex] == 1) {
                if (result[currentIndex - 1] == 1) {
                    result[currentIndex] = 2;
                } else {
                    result[currentIndex] = 1;
                    numOfOne++;
                }
                groupIndex++;
                currentIndex++;
            } else { // groupIndex == 2
                if (result[currentIndex - 1] == 1) {
                    result[currentIndex] = 2;
                    if (currentIndex + 1 < n)
                        result[currentIndex + 1] = 2;
                } else {
                    result[currentIndex] = 1;
                    numOfOne++;
                    if (currentIndex + 1 < n) {
                        result[currentIndex + 1] = 1;
                        numOfOne++;
                    }
                }
                groupIndex++;
                currentIndex += 2;
            }
        }
        return numOfOne;
    }

    public static void main(String[] args) {
        MagicalString test = new MagicalString();
        System.out.print(test.magicalString(19));
    }
}
