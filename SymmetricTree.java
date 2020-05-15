package tree;

import java.util.Stack;

public class SymmetricTree {
    static TreeNode root;

    static class TreeNode {

        int val;
        TreeNode left, right;

        TreeNode(int d) {
             val = d;
            left = right = null;
        }
    }
    boolean result = false;

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        TreeNode temp1 = root.left;
        TreeNode temp2 = root.right;
        TreeNode left = nodeRecursion(temp1, temp2);

      return result;
    }

    public TreeNode nodeRecursion(TreeNode root1, TreeNode root2) {

        if (root1 == null && root2 == null)
            return null;

        if(root1.val == root2.val ){
            result = true;

            if((root1.left == null && root2.right != null)||(root1.left != null && root2.right == null)) {
                result = false;
                return null;
            }

            if((root1.right == null && root2.left != null)||(root1.right != null && root2.left == null)) {
                result = false;
                return null;
            }


            if(root1.left != null && root2.right != null && result )
            nodeRecursion(root1.left,root2.right);

            if(root1.right != null && root2.left != null && result )
            nodeRecursion(root1.right,root2.left);


        }else{
            result = false;
            return null;
        }
        return root;
    }

    public static void main(String[] args) {

        root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(6);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(8);
        root.left.right.right = new TreeNode(9);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(4);
        root.right.left.left = new TreeNode(9);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(6);

        SymmetricTree tree = new SymmetricTree();
        System.out.println(tree.isSymmetric(root));
    }

}
