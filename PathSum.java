package tree;

public class PathSum {
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
    int finalValue = 0;
     int maxSum  = 0;

    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;
        finalValue = sum;
        maxSum = root.val;

        int val = checkPath(root,0);
        return result;
    }

    public int checkPath(TreeNode root, int sum ){
        if(root == null)
            return 0;

        sum = sum + root.val;
        if(sum == finalValue )
        {
            result = true;
        }

        if(root.left == null && root.right == null )
            return sum;

        int maxSumleft = checkPath(root.left,sum);

        int maxSumright = checkPath(root.right, sum);

        return maxSumleft+maxSumright;
    }


    public void print(TreeNode root){
        if(root == null)
            return;
        print(root.left);
        System.out.print(root.val+" ");
        print(root.right);
    }
    public static void main(String[] args) {
        root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);
        PathSum tree = new PathSum();
        System.out.println(tree.hasPathSum(root, 22));

    }

}
