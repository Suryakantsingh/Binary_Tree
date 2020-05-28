/*
Construct String from Binary Tree
*/
package tree.binaryTree;

public class String_From_Binary_Tree {
    static TreeNode root;

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int d) {
            this.val = d;
            left = right = null;
        }
    }
    String str = "";
    public String tree2str(TreeNode t) {
              if(t==null)
                return "";
            if(t.left==null && t.right==null)
                return t.val+"";
            if(t.right==null)
                return t.val+"("+tree2str(t.left)+")";
            return t.val+"("+tree2str(t.left)+")("+tree2str(t.right)+")";
        }
        public static void main(String[] args){
               String_From_Binary_Tree tree = new String_From_Binary_Tree();
               root = new TreeNode(1);
               root.left = new TreeNode(2);
               root.right = new TreeNode(3);
               root.left.right = new TreeNode(4);
               System.out.println(tree.tree2str(root));
        }
}
