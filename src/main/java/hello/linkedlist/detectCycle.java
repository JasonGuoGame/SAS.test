package hello.linkedlist;

/**
 * Created by scnyig on 7/4/2017.
 * https://www.zybuluo.com/867976167/note/52199
 */
public class DetectCycle {
    public ListNode detectCycle(ListNode node) {
        ListNode slow = node;
        ListNode fast = node;
        boolean isCycle = false;

        while (fast != null) {
            if(fast.next == null || fast.next.next == null) {
                return null;
            }

            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                isCycle = true;
                break;
            }
        }

        slow = node;
        if(isCycle) {
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
        } else {
            return null;
        }

        return  fast;
    }
}
