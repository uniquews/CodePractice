import utils.NestedInteger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuaiwang on 1/16/17.
 */
public class NestedListWeightSumII  {


    // Way 1: DFS
    /**
     *
     * ex: [1, [2], [[3]]]
     *
     * round 1 valueFromCurrentLevel([1, [2], [[3]]], 0)
     * startFromCurrentLevel = 1 + ?;  // ? means what will my children return back to me.
     *                                 // ? has to be weighted result, which already includes
     *                                 // my ancestor and myself
     *
     * round 2 valueFromCurrentLevel([2, [3]], 1)
     * startFromCurrentLevel = 1 + 2 + ?
     *
     * round 3 valueFromCurrentLevel(3, 1 + 2)
     * startFromCurrentLevel = 1 + 2 + 3 + ?
     *
     * round 4 valueFromCurrentLevel(null, 1 + 2 + 2)
     * we return 0 because this level doesn't exist at all so we dont need to get any value from here
     *
     * return back to round 3
     * startFromCurrentLevel = 1 + 2 + 3 + 0
     *
     * return back to round 2
     * startFromCurrentLevel = 1 + 2 + (1 + 2 + 3)
     *
     * return back to round 1
     * startFromCurrentLevel = 1 + (1 + 2 + 1 + 2 + 3)
     *
     *
     *
     * */
//    public int depthSumInverse(List<NestedInteger> nestedList) {
//        return valueFromCurrentLevel(nestedList, 0);
//    }
//
//    private int valueFromCurrentLevel(List<NestedInteger> n, int fromPreviousLevel) {
//        List<NestedInteger> nextLevel = new ArrayList<>();
//
//        int startFromCurrentLevel = fromPreviousLevel;
//        for (int i = 0; i < n.size(); i++) {
//            if (n.get(i).isInteger()) {
//                startFromCurrentLevel += n.get(i).getInteger();
//            } else {
//                nextLevel.addAll(n.get(i).getList());
//            }
//        }
//
//        if (n.isEmpty()) {
//            return 0;
//        }
//
//       startFromCurrentLevel += valueFromCurrentLevel(nextLevel, startFromCurrentLevel);
//       return startFromCurrentLevel;
//    }





    // Way 2 BFS

    /**
     *
     * One more level, the numbers in sumOfUnweightedNum wll be added one more time
     *
     * sumOfUnweightedNum += nestedList.get(i).getInteger(); will determine when the number
     *                       will be added. For example. [1, [2,3], [[4, 5],[6]] ]
     *                       4,5,6 will be added one level late than 2,3
     *                       so 4,5,6 will be added one time less than 2,3
     *
     * */
    public int depthSumInverse(List<NestedInteger> nestedList) {

        int result = 0, sumOfUnweightedNum = 0;
        while (!nestedList.isEmpty()) {
            List<NestedInteger> nextLevel = nestedList;
            for (int i = 0; i < nestedList.size(); i++) {
                if (nestedList.get(i).isInteger()) {
                    sumOfUnweightedNum += nestedList.get(i).getInteger();
                } else {
                    nextLevel.addAll(nestedList.get(i).getList());
                }
            }
            result += sumOfUnweightedNum;
            nestedList = nextLevel;
        }
        return result;
    }


}
