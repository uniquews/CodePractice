/**
 * Created by shuaiwang on 5/22/17.
 */
public class SearchinABigSortedArray {
    class ArrayReader {
       // get the number at index, return -1 if not exists.
       public int get(int index) {
           return -1;
       }
    }

    public int searchBigSortedArray(ArrayReader reader, int target) {
        // write your code here
        int index = 1;
        while (reader.get(index) < target)
        {
            index = index * 2;
        }

        int start = 0;
        int end = index;

        while (start + 1 < end)
        {
            int mid = start + (end - start) / 2;
            if (reader.get(mid) >= target)
            {
                end = mid;
            }
            else
            {
                start = mid;
            }
        }

        if (reader.get(start) == target)
        {
            return start;
        }
        else if (reader.get(end) == target)
        {
            return end;
        }
        else
        {
            return -1;
        }
    }
}
