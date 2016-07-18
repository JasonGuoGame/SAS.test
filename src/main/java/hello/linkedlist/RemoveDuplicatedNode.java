package hello.linkedlist;

/**
 * Created by scnyig on 7/18/2016.
 */
public class RemoveDuplicatedNode {
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        ListNode curr = head;
        while (curr != null) {
            ListNode inner = curr;
            while (inner.next != null) {
                if (inner.next.value == curr.value) {
                    inner.next = inner.next.next;
                } else {
                    inner = inner.next;
                }
            }
            curr = curr.next;
        }

        return head;
    }
}
