import utils.ListNode;

/**
 * Created by shuaiwang on 9/29/16.
 */
public class LinkedListCycle {
    /**
     * 双指针的方法：
     L1 无环部分的长度，L2是从环开始到相遇点的长度，环的长度为C，
     Slow 走了 L1 + L2 + m*C
     Fast 走了L1 + L2 + n*C
     已经fast走了slow的2倍距离 =>
     slow = (n - m) * C
     fast = 2 * (n - m) * C
     假设整个链表的长度是N 最好情况是slow走了不到一个cycle
     fast 走了一个cycle然后就立刻遇上了slow，此时两个指针都走了最短的距离相遇，所以是best case
     那么slow走了 N + L2  fast走了L1 + L2 => (N - C) + L2
     Slow * 2 = fast 推出链表应该是N = 2C 带入之前的式子
     n = 1, m = 0 slow走了N/2 fast走了N  所以一共走了1.5N
     *
     * */
//    public boolean hasCycle(ListNode head) {
//        // write your code here
//        if (head == null || head.next == null) {
//            return false;
//        }
//
//        ListNode slow = head;
//        ListNode fast = head.next;
//
//        while (fast != null && fast.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//
//            if (slow == fast) {
//                return true;
//            }
//        }
//
//        return false;
//    }

    // best case O(1N) 某种极端情况下，fast移到linklist的结尾的时候，正好碰到了slow， slow并不走，只是一个 ancor
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        ListNode slow = head;
        ListNode fast = head;

        int step = 1;

        while (fast != null) {
            int inc = 0;
            while (inc < step && fast != null) {
                fast = fast.next;
                inc++;
                if (slow.equals(fast)) {
                    return true;
                }
            }
            slow = fast;
            step++;
        }
        return false;
    }
}
