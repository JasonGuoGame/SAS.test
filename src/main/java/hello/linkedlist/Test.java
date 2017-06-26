package hello.linkedlist;

/**
 * Created by scnyig on 9/1/2016.
 */
public class Test {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(4);
        ListNode head3 = new ListNode(6);
        head1.next = head3;
        ListNode head2 = new ListNode(3);
        ListNode head4 = new ListNode(10);
        head2.next = head4;
        MergeLinkedList ss = new MergeLinkedList();
        ListNode head = ss.mergeLinkedList(head1, head2);
    }

    public static ListNode mergeLinkedList(ListNode h1, ListNode h2) {
        ListNode head;
        ListNode current;

        if (h1 == null && h2 ==null) {
            return null;
        }

        if(h1 == null) {
            return h2;
        }

        if(h2 == null) {
            return h1;
        }

        if(h1.value < h2.value) {
            head = h1;
            current = h1;
            h1 = h1.next;
        } else {
            head = h2;
            current = h2;
            h2 = h2.next;
        }

        while (h1.next != null && h2.next != null) {
            if (h1.value < h2.value) {
                current.next = h1;
                current = h1;
                h1 = h1.next;
            }else {
                current.next = h2;
                current = h2;
                h2 = h2.next;
            }
        }

        if(h1.next !=null) {
            current.next = h1;
        }else {
            current.next = h2;
        }

        return head;
    }
}
