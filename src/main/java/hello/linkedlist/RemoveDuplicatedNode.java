package hello.linkedlist;

/**
 * Created by scnyig on 7/18/2016.
 */
public class RemoveDuplicatedNode {
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
}
