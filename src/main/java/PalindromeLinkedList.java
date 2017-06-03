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
    public boolean isPalindrome(ListNode head) {
        // Write your code here
        if (head == null) {
            return true;
        }

        ListNode mid = findMiddle(head);
        ListNode secondHalf = reverse(mid.next);

        while (head != null && secondHalf != null) {
            if (head.val != secondHalf.val) {
                return false;
            }
            head = head.next;
            secondHalf = secondHalf.next;
        }
        return true;
    }

    private ListNode findMiddle(ListNode p) {
        if (p == null) {
            return p;
        }

        ListNode slow = p;
        ListNode fast = p.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode p) {
        if (p == null || p.next == null) {
            return p;
        }

        ListNode prepare = new ListNode(-1);
        prepare.next = p;
        ListNode prev = p;
        ListNode cur = p.next;

        while (cur != null) {
            prev.next = cur.next;
            cur.next = prepare.next;
            prepare.next = cur;
            cur = prev.next;
        }
        return prepare.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(2);
        ListNode d = new ListNode(1);

        a.next = b;
        b.next = c;
        c.next = d;

        PalindromeLinkedList test = new PalindromeLinkedList();
        test.isPalindrome(a);
    }
}
