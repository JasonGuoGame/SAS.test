package hello.tree;

/**
 * Created by scnyig on 7/21/2017.
 * http://www.lintcode.com/zh-cn/problem/convert-bst-to-greater-tree/
 */
public class ConvertBSTToGT {
    private int sum = 0;
    public BinaryTree.TreeNode convert(BinaryTree.TreeNode treeNode) {
        helper(treeNode);
        return treeNode;
    }

    public void helper(BinaryTree.TreeNode root) {
        if(root == null) {
            return;
        }
        if(root.right != null) {
            helper(root.right);
        }

        sum += root.value;
        root.value = sum;

        if (root.left != null) {
            helper(root.left);
        }
    }
}
