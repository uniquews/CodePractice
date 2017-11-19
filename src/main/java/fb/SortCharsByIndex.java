package fb;

public class SortCharsByIndex {
    public void sortChar(int[] nums, char[] letters) {
        int index = 0;
        char c = letters[index];
        int targetIndex = nums[index];

        int count = 0;
        while (count < nums.length) {
            if (targetIndex == index) {
                index++;
            } else {
                char nextC = letters[targetIndex];
                letters[targetIndex] = c;
                c = nextC;
                index = targetIndex;
                targetIndex = nums[index];
            }
            count++;
        }
    }

    public static void main(String[] args) {
//        int[] nums = {3,2,4,1,5,0};
//        char[] letters = {'D','C','E','B','F','A'};
        int[] nums = {0,1,2,3,4};
        char[] letters = {'D','C','E','B','F','A'};
        SortCharsByIndex test = new SortCharsByIndex();
        test.sortChar(nums, letters);
        for (int i = 0; i < letters.length; i++) {
            System.out.println(letters[i]);
        }
    }
}
