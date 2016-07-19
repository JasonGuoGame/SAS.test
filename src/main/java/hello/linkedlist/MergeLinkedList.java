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
}
