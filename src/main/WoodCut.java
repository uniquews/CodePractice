package main;

/**
 * Created by shuaiwang on 7/24/16.
 */
public class WoodCut {
    public int woodCut(int[] L, int k) {
        // write your code here
        int max = 0;
        for (int i = 0; i < L.length; i++)
        {
            max = Math.max(max, L[i]);
        }

        // We can't use start = 0 as
        // you could use L[i] / start in future while there is no valid length for fairly big k.
        int start = 1;
        int end = max;
        while (start + 1 < end)
        {
            int mid = start + (end - start) / 2;
            if (count(L, mid) >= k)
            {
                start = mid;
            }
            else
            {
                end = mid;
            }
        }

        if (count(L, end) >= k)
        {
            return end;
        }
        else if (count(L, start) >= k)
        {

            return start;
        }
        else
        {
            return 0;
        }
    }

    private int count(int[] L, int length)
    {
        int numOfCut = 0;
        for (int i = 0; i < L.length; i++)
        {
            numOfCut += L[i] / length;
        }
        return numOfCut;
    }
}
