package tree;

import java.util.Stack;

public class UnivaluedBinaryTree {
    static TreeNode root;

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int d) {
            this.val = d;
            left = right = null;
        }
    }
    boolean result = false;
    int value = 0;
    public boolean isUnivalTree(TreeNode root) {
        if(root == null)
             return false;

        value = root.val;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(root != null || !stack.isEmpty()){

            while(root != null){
                stack.push(root);
                root = root.left;
            }
            TreeNode temp = stack.pop();
            if(temp.val != value){
                return false;
            }
            if(temp.right != null)
                root = temp.right;
        }

       return true;
    }

    public void check(TreeNode root){
        if(root == null)
            return;
        if(root.val == value){
            result =  true;
        }else{
            result = false;
            return;
        }
        check(root.left);
        check(root.right);
    }
    public static void main(String[] args) {

        root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(2);

        UnivaluedBinaryTree tree = new UnivaluedBinaryTree();
        System.out.println(tree.isUnivalTree(root));
    }
}
