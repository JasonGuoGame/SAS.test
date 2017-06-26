package hello.linkedlist;

/**
 * Created by scnyig on 7/18/2016.
 */
public class RemoveDuplicatedNode {
    /*
    * Given 1->1->2, return 1->2.
    * Given 1->1->2->3->3, return 1->2->3.
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode dummy = head;

        while(dummy.next!=null){
            if(dummy.next.value==dummy.value){
                dummy.next=dummy.next.next;
            }else {
                dummy=dummy.next;
            }
        }
        return head;
    }

    /*
    * For example if the linked list is 12->11->12->21->41->43->21,
    * then removeDuplicates() should convert the list to 12->11->21->41->43.
     */
    public static ListNode removeDuplicates(ListNode head) {
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
