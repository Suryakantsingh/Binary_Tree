package tree;

public class MaxPathSum {
    static TreeNode root;

    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
            left = right = null;
        }
    }
    int maxSum;
    public int maxPathSum(TreeNode root) {
         maxSum = Integer.MIN_VALUE;
         pathSum(root);
        return maxSum;
    }

    public int pathSum(TreeNode root) {

        if (root == null)
            return 0;

        int leftSum = Math.max(pathSum(root.left), 0);
        int rightSum = Math.max(pathSum(root.right), 0);

        int calSum = Math.max(leftSum, rightSum);

        int sum = root.data + leftSum + rightSum;
        maxSum = Math.max(maxSum,sum);

        return root.data+calSum;
    }

    public static void main(String[] args) {
        root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.left.right = new TreeNode(7);
        MaxPathSum path = new MaxPathSum();
        System.out.println(path.maxPathSum(root));
    }
}
