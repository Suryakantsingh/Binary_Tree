package tree.binaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseLevelOrderTraversal {
    static TreeNode root;

    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int d) {
            this.data = d;
            left = right = null;
        }
    }

    public void levelOrder(TreeNode root) {
        if (root == null)
            return;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        int count = 0;
        Stack<Integer> stack = new Stack<>();

        while (!queue.isEmpty()) {

            int length = queue.size();

            while (length > 0) {

                    TreeNode temp = queue.poll();
                    stack.push(temp.data);

                    if (temp.right != null) {
                        queue.add(temp.right);

                    }

                    if (temp.left != null) {
                        queue.add(temp.left);

                    }

                    length--;
                }

            }


            while (!stack.isEmpty()) {
                System.out.print(stack.pop() + " ");
            }

    }

    public static void main(String[] args) {

        ReverseLevelOrderTraversal tree = new ReverseLevelOrderTraversal();
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

//        root.right.left = new TreeNode(6);
//        root.right.right = new TreeNode(7);
//
//        root.left.left.left = new TreeNode(8);
//        root.left.left.right = new TreeNode(9);
//        root.left.left.right.left = new TreeNode(16);
//
//        root.left.right.left = new TreeNode(3);
//        root.left.right.right = new TreeNode(1);
//        root.left.right.right.left = new TreeNode(17);
//        root.left.right.right.right = new TreeNode(18);
//
//        root.right.left.left = new TreeNode(4);
//        root.right.left.right = new TreeNode(2);
//        root.right.left.right.right = new TreeNode(19);
//
//        root.right.right.left = new TreeNode(7);
//        root.right.right.right = new TreeNode(2);

        tree.levelOrder(root);

    }
}
