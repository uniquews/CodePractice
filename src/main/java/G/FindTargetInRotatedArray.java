package G;

public class FindTargetInRotatedArray {

    /**
     * 第一轮面试官的口音有点听不懂，交流有点障碍，不过题目还算是比较简单的。给一个环形排序好的array，
     * 找到要找的数字t的index。题目其实就跟lc 33差不多。但我刚开始跟他说我的想法的时候，他否决我的然后叫我先找到最小值的index，
     * 再之后找t的index。binary search我写得比较慢，不过最后是写完了，出来后发现自己有个bug没cover到一个base case。
     * */
    public int findTarget(int[] nums, int target) {
        int minIndex = findMinInRoated(nums);
        int start = minIndex;
        int end = minIndex + nums.length - 1;
        int len = nums.length;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid % len] == target) {
                return mid;
            } else if (nums[mid % len] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[start % len] == target) {
            return start % len;
        } else {
            return end % len;
        }
    }

    private int findMinInRoated(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int start = 0;
        int end = nums.length - 1;

        while (start + 1 < end) {
            if (nums[start] < nums[end]) {
                return nums[start];
            }
            int mid = start + (end - start) / 2;
            if (nums[start] < nums[mid]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[start] < nums[end]) {
            return start;
        } else {
            return end;
        }
    }

    public static void main(String[] args) {
        int[] a = {3,4,5,1,2};
        FindTargetInRotatedArray test = new FindTargetInRotatedArray();
        System.out.println(test.findTarget(a, 5));
    }
}
