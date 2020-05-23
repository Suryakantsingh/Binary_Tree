/**
* Iterative Preorder Traversal
/
package tree.binaryTree;

import java.util.Stack;

public class Iterative_Preorder {
    static TreeNode root;

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int d) {
            this.val = d;
            left = right = null;
        }
    }

    public void print_Preorder(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            System.out.print(temp.val+" ");

            if(temp.right != null)
                stack.add(temp.right);

            if(temp.left != null )
                stack.add(temp.left);
        }
    }

    public static void main(String[] args) {
        root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(2);
        Iterative_Preorder tree = new Iterative_Preorder();
        tree.print_Preorder(root);

    }
}
