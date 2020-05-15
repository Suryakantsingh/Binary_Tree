package tree;

import sun.reflect.generics.tree.Tree;

import java.util.Stack;

public class PreorderT0Normal {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            left = right = null;
        }
    }

    public TreeNode bstFromPreorder(int[] preorder) {

        if(preorder.length == 0 || preorder.length == 1){
            TreeNode root = new TreeNode(preorder[0]);
            return root;
        }
        int size = preorder.length;

        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        for(int i = 1 ; i< size ; i++){

            TreeNode temp = null;

            while(!stack.isEmpty() && preorder[i] > stack.peek().val){
                temp = stack.pop();
            }

            if(temp != null){
                temp.right = new TreeNode(preorder[i]);
                 stack.push(temp.right);
            }else{
                temp = stack.peek();
                temp.left = new TreeNode(preorder[i]);
                stack.push(temp.left);
            }
        }
       return root;
    }
    public void print(TreeNode root){
        print(root.left);
        System.out.print(root.val);
        print(root.right);
    }
    public static void main(String[] args) {
        PreorderT0Normal preorderToNormal = new PreorderT0Normal();
        int[] pre = {8,5,1,7,10,12};
        TreeNode root = preorderToNormal.bstFromPreorder(pre);
        preorderToNormal.print(root);

    }
}
