package tree;

public class MergeTwoBinaryTree {

    static TreeNode root1;
    static TreeNode root2;
    static TreeNode root3;

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int d) {
            val = d;
            left = right = null;
        }
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        if (t1 == null)
            return t2;

        if (t2 == null)
            return t1;
        t1.val = t1.val+t2.val;
       t1.left =  mergeTrees(t1.left,t2.left);
       t1.right =  mergeTrees(t1.right,t2.right);
      return t1;
    }




    public static void main(String[] args) {
        root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(5);

        root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);
        root2.left.right = new TreeNode(4);
        root2.right.right = new TreeNode(7);
        MergeTwoBinaryTree tree = new MergeTwoBinaryTree();
        System.out.println(tree.mergeTrees(root1, root2));

    }
}
