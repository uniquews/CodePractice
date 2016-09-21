package main;

import main.utils.ListNode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by shuaiwang on 9/20/16.
 */
public class MergekSortedLists {


    /*
    *
    * Divide & Conquer
    *
    * */
//    public ListNode mergeKLists(List<ListNode> lists) {
//        // write your code here
//        return lists == null || lists.size() == 0 ? null : mergeHelper(lists, 0, lists.size() - 1);
//
//    }
//
//    private ListNode mergeHelper(List<ListNode> lists, int start, int end) {
//        if (start == end) {
//            return lists.get(start);
//        }
//
//        int mid = start + (end - start) / 2;
//        ListNode leftList = mergeHelper(lists, start, mid);
//        ListNode rightList = mergeHelper(lists, mid + 1, end);
//        return mergeTwoLists(leftList, rightList);
//    }
//
//    private ListNode mergeTwoLists(ListNode leftList, ListNode rightList) {
//        ListNode list1 = leftList;
//        ListNode list2 = rightList;
//
//        ListNode dummy = new ListNode(-1);
//        ListNode p = dummy;
//
//        while (list1 != null && list2 != null) {
//            if (list1.val < list2.val) {
//                p.next = list1;
//                p = p.next;
//                list1 = list1.next;
//            } else {
//                p.next = list2;
//                p = p.next;
//                list2 = list2.next;
//            }
//        }
//
//        if (list1 != null) {
//            p.next = list1;
//        } else {
//            p.next = list2;
//        }
//        return dummy.next;
//    }


    /*
    * Heap
    * */

//    private Comparator<ListNode> ListNodeComparator = new Comparator<ListNode>() {
//        public int compare(ListNode left, ListNode right) {
//            if (left == null) {
//                return 1;
//            } else if (right == null) {
//                return -1;
//            }
//            return left.val - right.val;
//        }
//    };
//    private Comparator<ListNode> ListNodeComparator = new Comparator<ListNode>() {
//        public int compare(ListNode left, ListNode right) {
//            if (left == null) {
//                return 1;
//            } else if (right == null) {
//                return -1;
//            }
//            return left.val - right.val;
//        }
//    };

    // leetcode
    public ListNode mergeKLists(ListNode[] lists) {
        // write your code here
        if (lists == null || lists.length == 0) {
            return null;
        }

        Queue<ListNode> heap = new PriorityQueue<ListNode>(lists.length, (list1, list2) -> {
            return list1.val - list2.val;
        });

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null)
                heap.add(lists[i]);
        }

        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

        while (!heap.isEmpty()) {
            ListNode cur = heap.poll();
            p.next = cur;
            p = p.next;

            if (cur.next != null) {
                heap.add(cur.next);
            }
        }
        return dummy.next;
    }
}
