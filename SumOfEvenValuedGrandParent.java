package tree;

public class SumOfEvenValuedGrandParent {

    static TreeNode root;

    static class TreeNode {

        int val;
        TreeNode left, right;

        TreeNode(int d) {
            this.val = d;
            left = right = null;
        }
    }
    int sum = 0 ;
    public int sumEvenGrandparent(TreeNode root) {

         return 0;
         }

    public int sumLeftRigh(TreeNode root, int sum){
       return 0;
    }

    public void print(TreeNode root) {
        if(root == null)
            return;
        System.out.print(root.val + " ");
        print(root.left);
        print(root.right);
    }

    public static void main(String[] args) {

        root = new TreeNode(6);
        root.left = new TreeNode(7);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(3);
        root.left.left.left = new TreeNode(9);
        root.left.right.left = new TreeNode(1);
        root.left.right.right = new TreeNode(1);
        root.right.right.right = new TreeNode(3);
        SumOfEvenValuedGrandParent tree = new SumOfEvenValuedGrandParent();
        tree.print(root);


    }
}
