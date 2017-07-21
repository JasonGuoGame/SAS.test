package hello.tree;

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
}
