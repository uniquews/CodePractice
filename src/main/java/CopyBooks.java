/**
 * Created by shuaiwang on 2/4/17.
 */
public class CopyBooks {
    public int copyBooks(int[] pages, int k) {
        if (pages == null || pages.length == 0) {
            return 0;
        }

        int sum = pages[0];
        int max = pages[0];
        for (int i = 1; i < pages.length; i++) {
            sum += pages[i];
            max = Math.max(max, pages[i]);
        }

        int start = max, end = sum;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (numOfCopier(pages, mid, k) > k) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (numOfCopier(pages, start, k) <= k) { // numOfCopier(pages, start, k) <= k for example [1,2] k = 5
            return start;
        }
        return end;

    }

    private int numOfCopier(int[] pages, int limit, int k) {
        int numOfPagesForOneCopier = pages[0];

        int copier = 1;
        for (int i = 1; i < pages.length; i++) {
            if (numOfPagesForOneCopier + pages[i] > limit) {
                numOfPagesForOneCopier = 0;
                copier++;
            }
            numOfPagesForOneCopier += pages[i];
        }
        return copier;
    }


    public static void main(String[] args) {
        int[] pages = {3,2,4};
        int k = 2;
        CopyBooks test = new CopyBooks();
        System.out.print(test.copyBooks(pages, k));
    }
}
