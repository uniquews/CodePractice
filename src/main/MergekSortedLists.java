package main;

import main.utils.ListNode;

import java.util.List;

/**
 * Created by shuaiwang on 9/20/16.
 */
public class MergekSortedLists {
    public ListNode mergeKLists(List<ListNode> lists) {
        // write your code here
        return lists == null || lists.size() == 0 ? null : mergeHelper(lists, 0, lists.size() - 1);

    }

    private ListNode mergeHelper(List<ListNode> lists, int start, int end) {
        if (start == end) {
            return lists.get(start);
        }

        int mid = start + (end - start) / 2;
        ListNode leftList = mergeHelper(lists, start, mid);
        ListNode rightList = mergeHelper(lists, mid + 1, end);
        return mergeTwoLists(leftList, rightList);
    }

    private ListNode mergeTwoLists(ListNode leftList, ListNode rightList) {
        ListNode list1 = leftList;
        ListNode list2 = rightList;

        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                p.next = list1;
                p = p.next;
                list1 = list1.next;
            } else {
                p.next = list2;
                p = p.next;
                list2 = list2.next;
            }
        }

        if (list1 != null) {
            p.next = list1;
        } else {
            p.next = list2;
        }
        return dummy.next;
    }
}
