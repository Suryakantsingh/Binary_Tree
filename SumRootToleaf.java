package tree;

import java.util.*;

public class SumRootToleaf {
    static TreeNode root;

    static class TreeNode {

        int data;
        TreeNode left, right;

        TreeNode(int d) {
            this.data = d;
            left = right = null;
        }
    }

    public int sumRootToLeaf(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        int sum = 0;
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            sum = temp.data;
            System.out.print(sum + " ");
            queue.add(temp.left);
            queue.add(temp.right);

        }
        return sum;
    }

    public int sumRootToLeafUsingDFS(TreeNode root) {

        return sumRootToLeafCal(root, 0);
    }

    public int sumRootToLeafCal(TreeNode root, int sum) {
        if (root == null)
            return 0;

        sum = sum*2 + root.data;

        if(root.left == null && root.right == null )
            return sum;

        int leftSum = sumRootToLeafCal(root.left,sum);
        int rightSum = sumRootToLeafCal(root.right,sum);
       return leftSum+rightSum;
    }

    public static void main(String[] args) {
        SumRootToleaf sumRootToleaf = new SumRootToleaf();
        sumRootToleaf.root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);
        System.out.println(sumRootToleaf.sumRootToLeafUsingDFS(root));
    }

}
