package hello.leetcode;

/**
 * Created by scnyig on 6/1/2016.
 */
public class LinkedList {
    //Merge two sorted linked lists and return it as a new list. T
        // Definition for singly-linked list.
        static class ListNode {
            int val;
            ListNode next;

            ListNode(int x) {
                val = x;
            }
        }

        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null || l2 == null) {
                return l1 != null ? l1 : l2;
            }
            ListNode head = new ListNode(-1);
            ListNode cur = head;
            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    cur.next = l1;
                    cur = cur.next;
                    l1 = l1.next;
                } else {
                    cur.next = l2;
                    cur = cur.next;
                    l2 = l2.next;
                }
            }
            cur.next = l1 != null ? l1 : l2;

            return head.next;
        }
}
