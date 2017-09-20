import utils.ListNode;

public class MultiplyLinkedList {
    public ListNode multiply(ListNode a, ListNode b) {
        if (a.val == 0 || b.val == 0) {
            return new ListNode(0);
        }
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        ListNode cur = dummy;

        while (a != null) {
            ListNode bNode = b;
            while (bNode != null) {
                int n = a.val * bNode.val;
                if (cur.next != null) {
                    cur.next.val += n;
                } else {
                    ListNode node = new ListNode(n);
                    cur.next = node;
                }
                cur = cur.next;
                bNode = bNode.next;
            }
            cur = head.next;
            head = head.next;
            a = a.next;
        }

        cur = dummy;
        int carry = 0;
        while (cur.next != null) {
            int tmp = cur.next.val + carry;
            cur.next.val = tmp % 10;
            carry = tmp / 10;
            cur = cur.next;
        }

        if (carry != 0) {
            cur.next = new ListNode(carry);
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        MultiplyLinkedList test = new MultiplyLinkedList();
        ListNode a = new ListNode(9);
        ListNode b = new ListNode(9);
        ListNode c = new ListNode(9);

        ListNode d = new ListNode(9);
        ListNode e = new ListNode(9);

        a.next = b;
        b.next = c;

        d.next = e;

        ListNode result = test.multiply(a, d);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }


    }
}
