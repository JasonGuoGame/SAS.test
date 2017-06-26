package hello.linkedlist;

/**
 * Created by scnyig on 7/19/2016.
 */
public class MergeLinkedList {
    public static ListNode mergeLinkedList(ListNode head1, ListNode head2) {
        ListNode head;
        ListNode current;
        if(head1 == null && head2 == null) {
            return null;
        }
        if (head1 == null) {
            return head2;
        }

        if (head2 == null) {
            return head1;
        }

        if(head1.value < head2.value) {
            head = head1;
            current = head;
            head1 = head1.next;
        } else {
            head = head2;
            current = head2;
            head2 = head2.next;
        }

        while (head1 != null && head2 != null) {
            if(head1.value < head2.value) {
                current.next = head1;
                current = head1;
                head1 = head1.next;
            } else {
                current.next = head2;
                current = head2;
                head1 = head2.next;
            }
        }

        if(head1 != null) {
            current.next = head1;
        }

        if(head2 != null) {
            current.next = head2;
        }

        return  head;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode merged = dummy;
        while(l1 != null || l2!= null){
            if(l1!= null && l2!= null && l1.value <= l2.value){
                ListNode cur = new ListNode(l1.value);
                merged.next = cur;
                l1 = l1.next;
            }
            else if(l1!= null && l2!= null && l1.value > l2.value){
                ListNode cur = new ListNode(l2.value);
                merged.next = cur;
                l2 = l2.next;
            }
            else if(l1 == null && l2 != null){
                ListNode cur = new ListNode(l2.value);
                merged.next = cur;
                l2 = l2.next;
            }
            else if(l2 == null && l1 != null){
                ListNode cur = new ListNode(l1.value);
                merged.next = cur;
                l1 = l1.next;
            }
            merged = merged.next;
        }
        return dummy.next;
    }
}
