package hello.linkedlist;

/**
 * Created by scnyig on 7/19/2016.
 */
public class ReverseList {
    public static ListNode reverseList(ListNode node) {
        if(node == null || node.next == null) {
            return node;
        }

        ListNode current = node;
        ListNode reverseNode = null;
        ListNode next = null;

        while (current != null) {
            next = current.next;

            current.next = reverseNode;
            reverseNode = current;

            current = next;
        }

        return reverseNode;
    }
}
