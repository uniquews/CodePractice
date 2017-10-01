import utils.ListNode;

/**
 * Created by shuaiwang on 9/28/16.
 */
public class PalindromeLinkedList {

    /**
     * O(1) space solution
     *
     * reverse之后原Linkedlist会变
     * */
//    public boolean isPalindrome(ListNode head) {
//        // Write your code here
//        if (head == null) {
//            return true;
//        }
//
//        ListNode mid = findMiddle(head);
//        ListNode secondHalf = reverse(mid.next);
//
//        while (head != null && secondHalf != null) {
//            if (head.val != secondHalf.val) {
//                return false;
//            }
//            head = head.next;
//            secondHalf = secondHalf.next;
//        }
//        return true;
//    }
//
//    private ListNode findMiddle(ListNode p) {
//        if (p == null) {
//            return p;
//        }
//
//        ListNode slow = p;
//        ListNode fast = p.next;
//
//        while (fast != null && fast.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//        return slow;
//    }
//
//    private ListNode reverse(ListNode p) {
//        if (p == null || p.next == null) {
//            return p;
//        }
//
//        ListNode prepare = new ListNode(-1);
//        prepare.next = p;
//        ListNode prev = p;
//        ListNode cur = p.next;
//
//        while (cur != null) {
//            prev.next = cur.next;
//            cur.next = prepare.next;
//            prepare.next = cur;
//            cur = prev.next;
//        }
//        return prepare.next;
//    }
//
//    public boolean isPalindrome(ListNode head) {
//        if (head == null || head.next == null) {
//            return true;
//        }
//
//        ListNode mid = findMiddle(head);
//        ListNode secondHalf = reverse(mid.next);
//
//        while (secondHalf != null) {
//            if (head.val != secondHalf.val) {
//                return false;
//            }
//            head = head.next;
//            secondHalf = secondHalf.next;
//        }
//        return true;
//    }
//
//    private ListNode findMiddle(ListNode head) {
//        ListNode slow = head;
//        ListNode fast = head.next;
//        while (fast != null && fast.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//        return slow;
//    }
//
//    private ListNode reverse(ListNode head) {
//        ListNode dummy = new ListNode(-1);
//        dummy.next = head;
//        ListNode prev = head;
//        ListNode current = head.next;
//        while (current != null) {
//            prev.next = current.next;
//            current.next = dummy.next;
//            dummy.next = current;
//            current = prev.next;
//        }
//        return dummy.next;
//    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) { // 这个head.next很容易忽略
            return true;
        }

        ListNode mid = findMiddle(head);
        ListNode sec = reverse(mid.next);
        while (sec != null) {
            if (head.val != sec.val) {
                return false;
            }
            head = head.next;
            sec = sec.next;
        }
        return true;
    }

    private ListNode findMiddle(ListNode n) {
        ListNode slow = n;
        ListNode fast = n.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private ListNode reverse(ListNode n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = n;
        ListNode prepare = dummy;
        ListNode prev = n;
        ListNode cur = n.next;

        while (cur != null) {
            prev.next = cur.next;
            cur.next = prepare.next;
            prepare.next = cur;
            cur = prev.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(4);
        ListNode c = new ListNode(-1);
        ListNode d = new ListNode(-1);
        ListNode e = new ListNode(4);
        ListNode f = new ListNode(1);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;

        PalindromeLinkedList test = new PalindromeLinkedList();
        test.isPalindrome(a);
    }
}
