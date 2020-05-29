/*
*  Minimum Absolute Difference in BST
   Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.
*
*/
package tree.binarySearchTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Absolute_Difference_in_BST {
    static TreeNode root;

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int d) {
            this.val = d;
            left = right = null;
        }
    }

    int diff = 0;
    List<Integer> list = new ArrayList<>();

    public int getMinimumDifference(TreeNode root) {
        if (root == null)
            return 0;
        Stack<TreeNode> stack = new Stack<>();



        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            TreeNode temp = stack.pop();
            list.add(temp.val);

            if( temp.right != null ){
                root = temp.right;
            }
        }

        return getMin();
    }

    public int getMin() {
        Collections.sort(list);
        diff = list.get(1) - list.get(0);
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if(diff > (list.get(j)-list.get(i))) {
                    diff = list.get(j)-list.get(i);
                }
            }
        }
        return diff;
    }

    public static void main(String[] args) {
        Absolute_Difference_in_BST tree = new Absolute_Difference_in_BST();
        root = new TreeNode(236);
        root.right = new TreeNode(701);
        root.left = new TreeNode(104);
       // root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(227);
       // root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(911);
        System.out.println(tree.getMinimumDifference(root));
    }
}
