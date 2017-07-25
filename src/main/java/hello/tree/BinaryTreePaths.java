package hello.tree;

import hello.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by scnyig on 7/21/2017.
 */
public class BinaryTreePaths {
    private List<List<Integer>> lists = new ArrayList<List<Integer>>();
    private List<Integer> path =  new ArrayList<Integer>();
    private int sum;

    public List<List<Integer>> binaryTreePathSum(BinaryTree.TreeNode root, int target) {
        sum = 0;
        helper(root, target);
        return lists;
    }

    private void helper(BinaryTree.TreeNode root, int target) {
        // Write your code here`
        if (root == null) {
            return;
        }

        sum += root.value;
        path.add(root.value);

        if (root.left == null && root.right == null && sum == target) {
            // compare sum & target
            // add 的是path的reference
            List<Integer> l = new ArrayList<Integer>();
            for (int i = 0; i < path.size(); i++) {
                l.add(path.get(i));
            }
            lists.add(l);
        }
        helper(root.left, target);
        helper(root.right, target);
        //从叶子节点返回了，当然要把之前加上的值减了，重新加入新的节点的值
        sum -= path.get(path.size() - 1);
        path.remove(path.size() - 1);
    }

    /**
     * intersection of two link list
     * http://wiki.jikexueyuan.com/project/for-offer/question-thirty-seven.html
     * get the length of two link list, initial the longest link list to equal to short linked list. loop the short and longest linked list to the same node
     */
    public int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    public ListNode getSameNode(ListNode l1, ListNode l2) {
        int l1Length = getLength(l1);
        int l2Length = getLength(l2);
        int diff = l1Length - l2Length;
        ListNode longestNode;
        ListNode shortNode;
        if(diff < 0) {
            longestNode = l2;
            shortNode = l1;
            diff = l2Length - l1Length;
        } else {
            longestNode = l1;
            shortNode = l2;
        }
        for (int i = 0; i < diff; i++) {
            longestNode = longestNode.next;
        }

        while (shortNode != null && longestNode != null && longestNode != shortNode) {
            shortNode = shortNode.next;
            longestNode = longestNode.next;
        }

        return longestNode;
    }
}
