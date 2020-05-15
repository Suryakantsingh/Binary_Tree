package tree;

public class SearchBinarySearchTree {

    static TreeNode root;
    static class TreeNode{
      int val;
      TreeNode left,right;

      TreeNode(int d){
          this.val = d;
          left = right = null;
      }
    }
    public void print(TreeNode root){
        if(root == null)
            return;
        print(root.left);
        System.out.print(root.val+" ");
        print(root.right);
    }
    public TreeNode search(TreeNode root, int val){
        if(root == null || root.val == val)
            return root;
        if(root.val > val) {
           return search(root.left, val);
        }else{
           return search(root.right, val);
        }

    }
    public static void main(String[] args){
        SearchBinarySearchTree tree = new SearchBinarySearchTree();
        root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        tree.print(root);
        System.out.println(tree.search(root, 1));

    }
}
