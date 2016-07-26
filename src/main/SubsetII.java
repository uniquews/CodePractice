package main;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by shuaiwang on 7/25/16.
 */
public class SubsetII {

    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (S == null || S.size() == 0)
        {
            return result;
        }

        Collections.sort(S);
        helper(S, result, list, 0);
        return result;
    }

    private void helper(ArrayList<Integer> S, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, int pos)
    {
        result.add(new ArrayList<Integer>(list));

        for (int i = pos; i < S.size(); i++)
        {
            list.add(S.get(i));
            helper(S, result, list, i + 1);
            list.remove(list.size() - 1);

            while (i < S.size() - 1 && S.get(i) == S.get(i + 1))
            {
                i++;
            }
        }
    }
}
