import utils.ListNode;

import java.util.Stack;

/**
 * Created by shuaiwang on 9/28/16.
 */
public class AddTwoNumbersII {
//    public ListNode addLists2(ListNode l1, ListNode l2) {
//        // write your code here
//        l1 = reverse(l1);
//        l2 = reverse(l2);
//        return reverse(addTwoLinkedlist(l1, l2));
//    }
//
//    private ListNode reverse(ListNode p) {
//        if (p == null || p.next == null) {
//            return p;
//        }
//
//        ListNode dummy = new ListNode(-1);
//        dummy.next = p;
//        ListNode prepare = dummy;
//        ListNode prev = p;
//        ListNode cur = p.next;
//
//        while (cur != null) {
//            prev.next = cur.next;
//            cur.next = prepare.next;
//            prepare.next = cur;
//            cur = prev.next;
//        }
//        return dummy.next;
//    }
//
//    private ListNode addTwoLinkedlist(ListNode l1, ListNode l2) {
//        ListNode dummy = new ListNode(-1);
//        ListNode prev = dummy;
//
//        int nextPos = 0;
//        while (l1 != null && l2 != null) {
//            int val = l1.val + l2.val + nextPos;
//            ListNode cur = new ListNode(val % 10);
//            nextPos = val / 10;
//            prev.next = cur;
//            prev = cur;
//            l1 = l1.next;
//            l2 = l2.next;
//        }
//
//        while (l1 != null) {
//            int val = l1.val + nextPos;
//            ListNode cur = new ListNode(val % 10);
//            prev.next = cur;
//            prev = cur;
//            nextPos = nextPos / 10;
//            l1 = l1.next;
//        }
//
//        while (l2 != null) {
//            int val = l2.val + nextPos;
//            ListNode cur = new ListNode(val % 10);
//            prev.next = cur;
//            prev = cur;
//            nextPos = nextPos / 10;
//            l2 = l2.next;
//        }
//
//        if (nextPos != 0) {
//            prev.next = new ListNode(nextPos);
//        }
//        return dummy.next;
//    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> stk1 = new Stack<>();
        Stack<ListNode> stk2 = new Stack<>();

        while (l1 != null) {
            stk1.push(l1);
            l1 = l1.next;
        }

        while (l2 != null) {
            stk2.push(l2);
            l2 = l2.next;
        }

        int next = 0;
        ListNode head = new ListNode(-1);
        while (!stk1.isEmpty() || !stk2.isEmpty()) {
            int num1 = stk1.isEmpty() ? 0 : stk1.pop().val;
            int num2 = stk2.isEmpty() ? 0 : stk2.pop().val;
            int cur = (next + num1 + num2) % 10;
            next = (next + num1 + num2) / 10;
            ListNode node = new ListNode(cur);
            node.next = head.next;
            head.next = node;
        }
        if (next != 0) {
            ListNode node = new ListNode(next);
            node.next = head.next;
            head.next = node;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        AddTwoNumbersII test = new AddTwoNumbersII();

        test.addTwoNumbers(a, b);
    }
}
