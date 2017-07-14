package hello.tree;

/**
 * Created by scnyig on 7/14/2017.
 */
public class HeightFromTree {
    static int h = 0;
    public int minHeight(BinaryTree.TreeNode node) {
        if(node == null) {
            return 0;
        }

        return getMin(node);
    }

    public static int getMin(BinaryTree.TreeNode node) {
        if (node == null) {
            return Integer.MAX_VALUE;
        }

        if (node.left == null && node.right == null) {
            return 1;
        }

        return Math.min(getMin(node.left), getMin(node.right)) + 1;
    }

    public int maxHeight(BinaryTree.TreeNode root) {
        if(root == null) {
            return 0;
        }

        travlse(root, 1);

        return h;
    }

    public static void travlse(BinaryTree.TreeNode node, int level) {
        if(node.left == null && node.right == null) {
            h = Math.max(h, level);
        }

        if (node.left != null) {
            travlse(node.left, level + 1);
        }

        if(node.right != null) {
            travlse(node.right, level + 1);
        }
    }
}
