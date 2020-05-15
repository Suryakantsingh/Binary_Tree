package tree;

public class NthInorderTraversal {
    static TreeNode root;

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int d) {
            val = d;
            left = right = null;
        }
    }
    int count = 0;
    int result = 0;

    public int search(TreeNode root, int number){
        if(root == null)
            return 0;

        search(root.left, number);
        count++;
        if(count == number){
            result = root.val;
            return result;
        }
        search(root.right,number);
        return result;
    }
    public static void main(String[] args){
        NthInorderTraversal tree = new NthInorderTraversal();
        root = new TreeNode(7);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(5);
        System.out.println(tree.search(root,3));
    }
}
