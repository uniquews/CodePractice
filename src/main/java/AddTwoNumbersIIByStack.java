import utils.ListNode;

import java.util.Stack;

/**
 * Created by shuaiwang on 1/24/17.
 */
public class AddTwoNumbersIIByStack {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stk1 = new Stack<>();
        Stack<Integer> stk2 = new Stack<>();

        while (l1 != null) {
            stk1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            stk2.push(l2.val);
            l2 = l2.next;
        }

        int remain = 0;
        ListNode dummy = new ListNode(-1);
        while (!stk1.isEmpty() || !stk2.isEmpty()) {
            int tmp = remain;
            if (!stk1.isEmpty())
                tmp += stk1.pop();
            if (!stk2.isEmpty())
                tmp += stk2.pop();
            ListNode current = new ListNode(tmp % 10);
            remain = tmp / 10;
            current.next = dummy.next;
            dummy.next = current;
        }

        if (remain != 0) {
            ListNode head = new ListNode(remain);
            dummy.next = head;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        AddTwoNumbersIIByStack test = new AddTwoNumbersIIByStack();
        ListNode a = new ListNode(5);
        ListNode b = new ListNode(5);
        test.addTwoNumbers(a,b);
    }
}
