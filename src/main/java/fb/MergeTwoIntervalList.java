package fb;

import utils.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MergeTwoIntervalList {
//    public List<Interval> mergeTwoIntervalList(List<Interval> list1, List<Interval> list2) {
//        List<Interval> result = new ArrayList<>();
//        Collections.sort(list1, (a, b) -> a.start - b.start);
//        Collections.sort(list2, (a, b) -> a.start - b.start);
//
//        int size1 = list1 == null ? 0 : list1.size();
//        int size2 = list2 == null ? 0 : list2.size();
//
//        int i = 0;
//        int j = 0;
//        while (i < size1 && j < size2) {
//            Interval tmp1 = list1.get(i);
//            Interval tmp2 = list2.get(j);
//            Interval k;
//
//            if (tmp1.start <= tmp2.start) {
//                k = tmp1;
//                i++;
//            } else {
//                k = tmp2;
//                j++;
//            }
//
//            if (!result.isEmpty() && result.get(result.size() - 1).end >= k.start) {
//                result.get(result.size() - 1).end = Math.max(result.get(result.size() - 1).end, k.end);
//            } else {
//                result.add(k);
//            }
//        }
//
//        while (i < size1) {
//            if (!result.isEmpty() && result.get(result.size() - 1).end >= list1.get(i).start) {
//                result.get(result.size() - 1).end = Math.max(result.get(result.size() - 1).end, list1.get(i).end);
//            } else {
//                result.add(list1.get(i));
//            }
//            i++;
//        }
//
//        while (j < size2) {
//            if (!result.isEmpty() && result.get(result.size() - 1).end >= list2.get(j).start) {
//                result.get(result.size() - 1).end = Math.max(result.get(result.size() - 1).end, list2.get(j).end);
//            } else {
//                result.add(list2.get(j));
//            }
//            j++;
//        }
//        return result;
//    }

    public List<Interval> mergeTwoIntervalList(List<Interval> list1, List<Interval> list2) {
        return merge(mergeSort(list1), mergeSort(list2));
    }

    private List<Interval> mergeSort(List<Interval> list) {
        if (list.isEmpty() || list.size() == 1) {
            return list;
        }

        int mid = (list.size() - 1) / 2;

        List<Interval> tmp1 = new ArrayList<>();
        List<Interval> tmp2 = new ArrayList<>();

        for (int i = 0; i <= mid; i++) {
            tmp1.add(list.get(i));
        }

        for (int i = mid + 1; i < list.size(); i++) {
            tmp2.add(list.get(i));
        }

        tmp1 = mergeSort(tmp1);
        tmp2 = mergeSort(tmp2);

        return mergeTwoIntervalList(tmp1, tmp2);
    }

    private List<Interval> merge(List<Interval> list1, List<Interval> list2) {
        List<Interval> result = new ArrayList<>();

        int size1 = list1 == null ? 0 : list1.size();
        int size2 = list2 == null ? 0 : list2.size();

        int i = 0;
        int j = 0;
        while (i < size1 && j < size2) {
            Interval tmp1 = list1.get(i);
            Interval tmp2 = list2.get(j);
            Interval k;

            if (tmp1.start <= tmp2.start) {
                k = tmp1;
                i++;
            } else {
                k = tmp2;
                j++;
            }

            if (!result.isEmpty() && result.get(result.size() - 1).end >= k.start) {
                result.get(result.size() - 1).end = Math.max(result.get(result.size() - 1).end, k.end);
            } else {
                result.add(k);
            }
        }

        while (i < size1) {
            if (!result.isEmpty() && result.get(result.size() - 1).end >= list1.get(i).start) {
                result.get(result.size() - 1).end = Math.max(result.get(result.size() - 1).end, list1.get(i).end);
            } else {
                result.add(list1.get(i));
            }
            i++;
        }

        while (j < size2) {
            if (!result.isEmpty() && result.get(result.size() - 1).end >= list2.get(j).start) {
                result.get(result.size() - 1).end = Math.max(result.get(result.size() - 1).end, list2.get(j).end);
            } else {
                result.add(list2.get(j));
            }
            j++;
        }
        return result;
    }




    public static void main(String[] args) {
        List<Interval> list1 = Arrays.asList(new Interval(1,3), new Interval(2,6));
        List<Interval> list2 = Arrays.asList(new Interval(8,10), new Interval(15,18));

        MergeTwoIntervalList test = new MergeTwoIntervalList();
        List<Interval> result = test.mergeTwoIntervalList(list1, list2);
        for (Interval i : result) {
            System.out.println(i);
        }
    }
}
