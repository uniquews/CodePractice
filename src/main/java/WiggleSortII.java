/**
 * Created by shuaiwang on 1/14/17.
 */
public class WiggleSortII {
    public void wiggleSort(int[] nums) {
        int k = (nums.length + 1) / 2;
        int median = nums[findKthNumber(nums, 0, nums.length - 1, k)];
        int[] tmp = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            tmp[i] = nums[i];
        }
        threeWayPartition(tmp, median);
        fillOutDate(nums, tmp);
    }

    private void fillOutDate(int[] nums, int[] tmp) {
        int left = 0;
        int right = tmp.length - 1;

        int lastEvenIndex = (nums.length % 2 == 0) ? (nums.length - 2) : nums.length - 1;
        int firstOddIndex = 1;

        while (left < right) {
            nums[lastEvenIndex] = tmp[left];
            lastEvenIndex -= 2;
            left++;

            nums[firstOddIndex] = tmp[right];
            firstOddIndex += 2;
            right--;
        }

        if (left == right) {
            nums[0] = tmp[left];
        }
    }

    private void threeWayPartition(int[] nums, int median) { // sort color
        int left = 0;
        int cur = 0;
        int right = nums.length - 1;

        while (cur <= right) {
            if (nums[cur] < median) {
                swap(nums, cur, left);
                left++;
                cur++;
            } else if (nums[cur] == median) {
                cur++;
            } else {
                swap(nums, cur, right);
                right--;
            }
        }
    }

    private int findKthNumber(int[] nums, int start, int end, int k) {
        int index = partition(nums, start, end);
        if (index + 1 == k) {
            return index;
        } else if (index < k) {
            return findKthNumber(nums, index + 1, end, k);
        } else {
            return findKthNumber(nums, start, index - 1, k);
        }
    }


    private int partition(int[] nums, int start, int end) {
        int leftTail = start;
        int pivot = nums[end];

        for (int i = start; i <= end - 1; i++) {
            if (nums[i] <= pivot) {
                swap(nums, i, leftTail);
                leftTail++;
            }
        }

        swap(nums, leftTail, end);
        return leftTail;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
//        int[] a = {4,5,5,6};
        int[] a = {1,2,1,2,1,2,1};
        WiggleSortII test = new WiggleSortII();
        test.wiggleSort(a);
        System.out.print(a);
    }
}
