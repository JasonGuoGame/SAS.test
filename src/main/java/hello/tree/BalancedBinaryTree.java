package hello.tree;

import java.util.Map;

/**
 * Created by scnyig on 7/28/2017.
 */
public class BalancedBinaryTree {
    class ResultType{
        public boolean isBanlance;
        public int maxHeight;

        ResultType(boolean isBanlance, int maxHeight) {
            this.isBanlance = isBanlance;
            this.maxHeight = maxHeight;
        }
    }

    public ResultType isBanlanceBinaryTree(BinaryTree.TreeNode root) {
        if (root == null) {
            return new ResultType(true, 0);
        }

        ResultType left = isBanlanceBinaryTree(root.left);
        ResultType right = isBanlanceBinaryTree(root.right);

        if(!left.isBanlance || !right.isBanlance) {
            return new ResultType(false, -1);
        }
        if(Math.abs(left.maxHeight - right.maxHeight) > 1) {
            return new ResultType(false, -1);
        }

        return new ResultType(true, Math.max(left.maxHeight, right.maxHeight) +1);
    }
}
