package hello.linkedlist;

/**
 * Created by scnyig on 7/25/2017.
 */
public class AddTwoSums {
    /**
     * https://leetcode.com/problems/add-two-numbers/#/solution
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoSums(ListNode l1, ListNode l2) {
        ListNode p1 = l1, p2 = l2, dummy = new ListNode(0);
        int carry = 0;
        int sum = 0;
        ListNode current = dummy;

        while (p1 != null || p2 != null) {
            int x = p1 != null ? p1.value : 0;
            int y = p2 != null ? p2.value : 0;
            sum = carry + x + y;
            current.next = new ListNode(sum%10);
            carry = sum/10;
            current = current.next;
            p1 = p1.next != null ? p1.next : null;
            p2 = p2.next != null ? p2.next : null;
        }

        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return dummy.next;
    }
}
