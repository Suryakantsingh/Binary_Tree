/*
Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
Example 1:
Input:
    3
   / \
  9  20
    /  \
   15   7
Output: [3, 14.5, 11]
Explanation:
The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
*/
package tree.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsBinaryTree {
    static TreeNode root;

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int d) {
            this.val = d;
            left = right = null;
        }
    }

    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null)
            return null;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        List<Double> list = new ArrayList<Double>();
        while (!queue.isEmpty()) {

            int length = queue.size();
            double sum = 0;
            int count = 0;

            while (length > 0) {

                TreeNode temp = queue.poll();
                sum = sum + temp.val;
                count++;

                if( temp.left != null )
                    queue.add(temp.left);

                if( temp.right != null )
                    queue.add(temp.right);

                length--;
            }
            double avg = sum/count;
            list.add(avg);
        }
        return list;
    }

    public static void main(String[] args) {
        AverageOfLevelsBinaryTree tree = new AverageOfLevelsBinaryTree();
        root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(tree.averageOfLevels(root));
    }

}
