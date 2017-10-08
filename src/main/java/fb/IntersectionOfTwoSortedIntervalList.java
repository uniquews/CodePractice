package fb;

import utils.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfTwoSortedIntervalList {
    /**
     *
     * 只需要记录merge 过后的interval list里  最后一个end的 值， 因为我们只会用到这个
     * */
    public List<Interval> getIntersection(List<Interval> list1, List<Interval> list2) {
        int lastOfMergedInterval = -1;
        List<Interval> result = new ArrayList<>();

        int i = 0;
        int j = 0;

        int size1 = list1 == null ? 0 : list1.size();
        int size2 = list2 == null ? 0 : list2.size();

        while (i < size1 && j < size2) {
            Interval tmp = list1.get(i).start <= list2.get(j).start ? list1.get(i++) : list2.get(j++);
            lastOfMergedInterval = helper(tmp, lastOfMergedInterval, result);
        }

        while (i < size1) {
            Interval tmp = list1.get(i++);
            lastOfMergedInterval = helper(tmp, lastOfMergedInterval, result);
        }

        while (j < size2) {
            Interval tmp = list2.get(j++);
            lastOfMergedInterval = helper(tmp, lastOfMergedInterval, result);
        }
        return result;
    }

    private int helper(Interval tmp, int last, List<Interval> result) {
        if (last == -1) {
            return tmp.end;
        } else {
            if (tmp.start < last) {
                Interval overlap = new Interval(tmp.start, Math.min(last, tmp.end));
                result.add(overlap);
                return Math.max(last, tmp.end);
            } else {
                return tmp.end;
            }
        }
    }

    public static void main(String[] args) {
        IntersectionOfTwoSortedIntervalList test = new IntersectionOfTwoSortedIntervalList();
        List<Interval> list1 = Arrays.asList(new Interval(1,2), new Interval(5,7));
        List<Interval> list2 = Arrays.asList(new Interval(5,6));

        List<Interval> result = test.getIntersection(list1, list2);
        for (Interval i : result) {
            System.out.println(i);
        }

    }
}
