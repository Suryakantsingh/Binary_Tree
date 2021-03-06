/*
Perfect Binary Tree Specific Level Order Traversal
GeeksforGeeks ----> Traversal ----> 18. Perfect Binary Tree Specific Level Order Traversal
output of below program : 1 2 3 4 7 5 6 8 15 9 14 10 13 11 12 16 31 17 30 18 29 19 28 20 27 21 26 22 25 23 24 
*/
package tree.binaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PerfectBinaryTreeSpecificLevelOrder {

    static TreeNode root;
    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int d) {
            this.data = d;
            left = right = null;
        }
    }
    public void levelOrder(TreeNode root){
        if (root == null)
            return;

        System.out.print(root.data+" ");
        Queue<TreeNode> leftQueue = new LinkedList<TreeNode>();
        Queue<TreeNode> rightQueue = new LinkedList<TreeNode>();
        leftQueue.add(root.left);
        rightQueue.add(root.right);

        while (!leftQueue.isEmpty() || !rightQueue.isEmpty()) {

            int lengthLeft = leftQueue.size();
            int lengthRight = rightQueue.size();

            while (lengthLeft > 0 || lengthRight > 0) {

                TreeNode temp = null;
                TreeNode temp1 = null;
                if (lengthLeft > 0) {
                    temp = leftQueue.poll();
                    System.out.print(temp.data + " ");
                }

                if (lengthRight > 0) {
                    temp1 = rightQueue.poll();
                    System.out.print(temp1.data + " ");
                }


                if (temp.left != null) {
                    leftQueue.add(temp.left);

                }

                if (temp.right != null) {
                    leftQueue.add(temp.right);

                }
                if (temp1.right != null) {
                    rightQueue.add(temp1.right);

                }

                if (temp1.left != null) {
                    rightQueue.add(temp1.left);

                }

                lengthLeft--;
                lengthRight--;
            }
        }

    }


    public static void main(String[] args) {

        PerfectBinaryTreeSpecificLevelOrder tree = new PerfectBinaryTreeSpecificLevelOrder();
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);

        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(11);

        root.right.left.left = new TreeNode(12);
        root.right.left.right = new TreeNode(13);

        root.right.right.left = new TreeNode(14);
        root.right.right.right = new TreeNode(15);

        root.left.left.left.left = new TreeNode(16);
        root.left.left.left.right = new TreeNode(17);

        root.left.left.right.left = new TreeNode(18);
        root.left.left.right.right = new TreeNode(19);

        root.left.right.left.left = new TreeNode(20);
        root.left.right.left.right = new TreeNode(21);

        root.left.right.right.left = new TreeNode(22);
        root.left.right.right.right = new TreeNode(23);

        root.right.left.left.left = new TreeNode(24);
        root.right.left.left.right = new TreeNode(25);

        root.right.left.right.left = new TreeNode(26);
        root.right.left.right.right = new TreeNode(27);

        root.right.right.left.left = new TreeNode(28);
        root.right.right.left.right = new TreeNode(29);

        root.right.right.right.left = new TreeNode(30);
        root.right.right.right.right = new TreeNode(31);

        tree.levelOrder(root);

    }
  }
