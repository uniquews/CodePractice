/**
 * Created by shuaiwang on 3/12/17.
 */
public class SmallestRectangleEnclosingBlackPixels {
//    public int minArea(char[][] image, int x, int y) {
//        int columnLower = findBoundary(0, y, image, false, false); // column and lower bound
//        int columnUpper = findBoundary(y, image[0].length - 1, image, false, true);
//        int rowLower = findBoundary(0, x, image, true, false);
//        int rowUpper = findBoundary(x, image.length - 1, image, true, true);
//
//        return (rowUpper - rowLower + 1) * (columnUpper - columnLower + 1);
//    }
//
//    private int findBoundary(int start, int end, char[][] image, boolean isRow, boolean findUpperBoud) {
//        while (start + 1 < end) {
//            int mid = start + (end - start) / 2;
//            if (isBlackPixel(image, isRow, mid)) { // 1
//                if (findUpperBoud) {
//                    start = mid;
//                } else {
//                    end = mid;
//                }
//            } else {
//                if (findUpperBoud) {
//                    end = mid;
//                } else {
//                    start = mid;
//                }
//            }
//        }
//
//        if (findUpperBoud) {
//            if(isBlackPixel(image, isRow, end)) {
//                return end;
//            } else {
//                return start;
//            }
//        } else {
//            if (isBlackPixel(image, isRow, start)) {
//                return start;
//            } else {
//                return end;
//            }
//        }
//    }
//
//    private boolean isBlackPixel(char[][] image, boolean isRow, int position) {
//        if (isRow) {
//            for (int i = 0; i < image[0].length; i++) {
//                if (image[position][i] == '1') {
//                    return true;
//                }
//            }
//        } else {
//            for (int i = 0; i < image.length; i++) {
//                if (image[i][position] == '1') {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

    public int minArea(char[][] image, int x, int y) {
        int findRowUpper = binarySearch(image, x, image.length - 1, true, true);
        int findRowLower = binarySearch(image, 0, x, false, true);
        int findColUpper = binarySearch(image, y, image[0].length - 1, true, false);
        int findColLower = binarySearch(image, 0, y, false, false);

        return (Math.abs(findRowUpper - findRowLower) + 1) * (Math.abs(findColUpper - findColLower) + 1);
    }

    private int binarySearch(char[][] image, int x, int y, boolean isUpper, boolean isRow) {
        int start = x;
        int end = y;

        if (isUpper) {
            while (start + 1 < end) {
                int mid = start + (end - start) / 2;
                if (checkOne(image, mid, isRow)) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
            if (checkOne(image, end, isRow))
                return end;
            else
                return start;

        } else {
            while (start + 1 < end) {
                int mid = start + (end - start) / 2;
                if (checkOne(image, mid, isRow)) {
                    end = mid;
                } else {
                    start = mid;
                }
            }
            if (checkOne(image, start, isRow))
                return start;
            else
                return end;
        }
    }

    private boolean checkOne(char[][] image, int index, boolean isRow) {
        if (isRow) {
            for (int i = 0; i < image[0].length; i++) {
                if (image[index][i] == '1') {
                    return true;
                }
            }
        } else {
            for (int i = 0; i < image.length; i++) {
                if (image[i][index] == '1') {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] image = {{'0', '0', '1', '0'}, {'0', '1', '1', '0'}, {'0', '1', '0', '0'}};
        SmallestRectangleEnclosingBlackPixels test = new SmallestRectangleEnclosingBlackPixels();
        System.out.println(test.minArea(image, 0, 2));
    }
}
