package hello.linkedlist;

/**
 * Created by scnyig on 8/24/2016.
 * https://xuan.gitbooks.io/leetcode/content/zh-cn/linked_list/swap_nodes_in_pairs.html
 */
public class SwapNodes {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode after = head.next;
        head.next = swapPairs(after.next);
        after.next = head;

        return after;
    }
}
