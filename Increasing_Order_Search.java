package tree;

import java.util.ArrayList;
import java.util.Stack;

public class Increasing_Order_Search {
    static TreeNode root;
    static TreeNode root1;

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int d) {
            val = d;
            left = right = null;
        }
    }

    public TreeNode increasingBST(TreeNode root) {

        if (root == null)
            return null;
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode temp = null;
        while ( root != null || !stack.isEmpty() ) {

            while ( root != null ){
                stack.push( root );
                root = root.left;
            }

             temp = stack.pop();
             list.add(temp.val);

            if( temp.right != null ) {
                root = temp.right;
            }
        }
        System.out.println(list.toString());
        TreeNode temp1 = new TreeNode(list.get(0));
        TreeNode temp2 = temp1;
        for(int i = 1;i< list.size();i++){
            temp2.right = new TreeNode(list.get(i));
            temp2 = temp1.right;
        }
        return temp1;
    }

    public static void main(String[] args) {

        root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);

        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(7);
        root.right.right.right = new TreeNode(9);
        Increasing_Order_Search increasingBST = new Increasing_Order_Search();
        System.out.println(increasingBST.increasingBST(root));
    }
}
