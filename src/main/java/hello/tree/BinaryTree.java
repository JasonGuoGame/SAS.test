package hello.tree;

import java.util.ArrayDeque;

/**
 * Created by scnyig on 6/3/2016.
 * ArrayDeque不是线程安全的。
 * ArrayDeque不可以存取null元素，因为系统根据某个位置是否为null来判断元素的存在。
 * 当作为栈使用时，性能比Stack好；当作为队列使用时，性能比LinkedList好。
 */
public class BinaryTree {
    static class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value){
            this.value=value;
        }
    }

    TreeNode root;

    public BinaryTree(int[] array){
        root=makeBinaryTreeByArray(array,1);
    }

    /**
     *                  13
     *                 /  \
     *               65    5
     *              /  \    \
     *             97  25   37
     *            /    /\   /
     *           22   4 28 32
     */
    public static void main(String[] args) {
        int[] arr={0,13,65,5,97,25,0,37,22,0,4,28,0,0,32,0};
        BinaryTree tree=new BinaryTree(arr);
        preOrder(tree.root);
        System.out.println("================================");
        inOrder(tree.root);
        System.out.println("================================");
        postOrder(tree.root);
//        tree.depthOrderTraversal();
//        tree.levelOrderTraversal();
    }

    /**
     * 采用递归的方式创建一颗二叉树
     * 传入的是二叉树的数组表示法
     * 构造后是二叉树的二叉链表表示法
     */
    public static TreeNode makeBinaryTreeByArray(int[] array,int index){
        if(index<array.length){
            int value=array[index];
            if(value!=0){
                TreeNode t=new TreeNode(value);
                array[index]=0;
                t.left=makeBinaryTreeByArray(array,index*2);
                t.right=makeBinaryTreeByArray(array,index*2+1);
                return t;
            }
        }
        return null;
    }

    /**
     * 深度优先遍历，相当于先根遍历
     * 采用非递归实现
     * 需要辅助数据结构：栈
     */
    public void depthOrderTraversal(){
        if(root==null){
            System.out.println("empty tree");
            return;
        }
        ArrayDeque<TreeNode> stack=new ArrayDeque<TreeNode>();
        stack.push(root);
        while(stack.isEmpty()==false){
            TreeNode node=stack.pop();
            System.out.print(node.value+"    ");
            if(node.right!=null){
                stack.push(node.right);
            }
            if(node.left!=null){
                stack.push(node.left);
            }
        }
        System.out.print("\n");
    }
    /**
     * 广度优先遍历
     * 采用非递归实现
     * 需要辅助数据结构：队列
     */
    public void levelOrderTraversal(){
        if(root==null){
            System.out.println("empty tree");
            return;
        }
        ArrayDeque<TreeNode> queue=new ArrayDeque<TreeNode>();
        queue.add(root);
        while(queue.isEmpty()==false){
            TreeNode node=queue.remove();
            System.out.print(node.value+"    ");
            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }
        }
        System.out.print("\n");
    }

    /*
    * 深度优先遍历分为，前序，中序，后续
    * recursive
     */
    public static void preOrder(TreeNode root) {
        if(root == null) {
            System.out.println("empty");
        }
        System.out.println(root.value);
        if (root.left != null)
            preOrder(root.left);
        if (root.right != null)
            preOrder(root.right);
    }

    public static void inOrder(TreeNode root) {
        if(root ==null) {
            System.out.println("empty");
        }

        if(root.left != null) {

            inOrder(root.left);
        }
        System.out.println(root.value);
        if(root.right != null) {
            inOrder(root.right);
        }
    }

    public static void postOrder(TreeNode root) {
        if(root ==null) {
            System.out.println("empty");
        }

        if(root.left != null) {

            inOrder(root.left);
        }

        if(root.right != null) {
            inOrder(root.right);
        }

        System.out.println(root.value);
    }
}
