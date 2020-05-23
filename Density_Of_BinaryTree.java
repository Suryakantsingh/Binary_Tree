/*
* Density of Binary Tree in One Traversal
*/
package tree.binaryTree;

import sun.reflect.generics.tree.Tree;

public class Density_Of_BinaryTree {
    static TreeNode root;

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int d) {
            this.val = d;
            left = right = null;
        }
    }
    int height = 0;
    int count = 0;
    int element = 0;

    public float densityCalculate(TreeNode root){
       if( root == null )
           return 0;

       height(root.left);
        int left = height;
       height(root.right);
       int right = height - left ;
       if(left > right){
           height = left+1;
       }else{
           height = right+1;
       }
       element++;
       float density =(float) element / height;
       return density;
    }

    public int height ( TreeNode root) {
        if( root == null )
            return 0;
        height++;
        element++;
        height(root.left);
        height(root.right);
        return height;
    }

    public static void main(String[] args){
        Density_Of_BinaryTree tree = new Density_Of_BinaryTree();
        root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);
        System.out.println(tree.densityCalculate(root));
    }
}
