import java.util.Arrays;

/**
 * Created by shuaiwang on 12/12/16.
 */
public class NutsAndBoltsProblem {
    public static  class NBComparator {
        int cmp(String nut, String bolt) {
            int result = nut.compareToIgnoreCase(bolt);
            if (result < 0 )
                return -1;
            else if (result == 0)
                return 0;
            else
                return 1;
        }
    }

    public void sortNutsAndBolts(String[] nuts, String[] bolts, NBComparator compare) {
        // write your code here
        sort(nuts, bolts, 0, nuts.length - 1, compare);
    }

    private void sort(String[] nuts, String[] bolts, int start, int end, NBComparator comparator) {
        if (start >= end) {
            return;
        }

        // pick the first one in bolts
        String pivotInBolts = bolts[start];

        // Scan nuts array, find the matched one
        int pivotInNutsIndex = scanInNuts(pivotInBolts, nuts, comparator);
        String pivotInNuts = nuts[pivotInNutsIndex];

        // swap it with last one in nuts
        int partitionedIndex = partitionInNuts(nuts, pivotInBolts, pivotInNutsIndex, start, end, comparator);
        partitionInBolts(bolts, pivotInNuts, 0, start, end, comparator);

        sort(nuts, bolts, start, partitionedIndex - 1, comparator);
        sort(nuts, bolts, partitionedIndex + 1, end, comparator);
    }

    private int scanInNuts(String pivotInBolt, String[] nuts, NBComparator comparator) {
        for (int i = 0; i < nuts.length; i++) {
            if (comparator.cmp(pivotInBolt, nuts[i]) == 0) {
                return i;
            }
        }
        return -1;
    }

    private void swap(String[] array, int start, int end) {
        String tmp = array[end];
        array[end] = array[start];
        array[start] = tmp;
    }

    private int partitionInNuts(String[] nuts, String pivotInBolts, int pivotInNutsIndex, int start, int end, NBComparator comparator) {
        swap(nuts, pivotInNutsIndex, end);

        int left = start - 1;
        for (int right = start; right < end; right++) {
            if (comparator.cmp(nuts[right], pivotInBolts) == -1) {
                left++;
                swap(nuts, left, right);
            }
        }
        swap(nuts, left + 1, end);
        return left + 1;
    }

    private void partitionInBolts(String[] bolts, String pivotInNuts, int pivotInBoltsIndex, int start, int end, NBComparator comparator) {
        swap(bolts, pivotInBoltsIndex, end);

        int left = start - 1;
        for (int right = start; right < end; right++) {
            if (comparator.cmp(pivotInNuts, bolts[right]) == 1) {
                left++;
                swap(bolts, left, right);
            }
        }
        swap(bolts, left + 1, end);
    }

    public static void main(String[] args) {
        NutsAndBoltsProblem test = new NutsAndBoltsProblem();
        String[] nuts = {"ab","bc","dd","gg"};
        String[] bolts = {"AB","GG","DD","BC"};

        NBComparator nbc = new NBComparator();

        test.sortNutsAndBolts(nuts, bolts, nbc);

        System.out.print(Arrays.toString(nuts));
        System.out.print(Arrays.toString(bolts));
    }
}
