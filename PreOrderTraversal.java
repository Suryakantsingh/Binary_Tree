package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversal {

    static TreeNode root;

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int d) {
            this.val = d;
            left = right = null;
        }
    }

    public List<Integer> preOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();

        if (root == null)
            return list;

        while (root != null || !stack.isEmpty()) {

            while (root != null) {
                stack.push(root);
                list.add(root.val);
                root = root.left;
            }

            root = stack.pop();
            root = root.right;

        }
        return list;
    }

    public List<Integer> inOrder(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();

        if (root == null)
            return list;

        while (root != null || !stack.isEmpty()) {

            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }

    public List<Integer> postOrder( TreeNode root ) {

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        List<Integer> list = new ArrayList<>();
        TreeNode head = root;
        if(root == null)
            return list;

        stack1.push(root);

        while(!stack1.isEmpty()){

             root = stack1.pop();
             stack2.push(root);

            if(root.left != null)
                stack1.push(root.left);

            if(root.right != null)
                 stack1.push(root.right);

        }
        while(!stack2.isEmpty()){
            list.add(stack2.pop().val);
        }

      return list;
    }

    public static void main(String[] args) {

        PreOrderTraversal tree = new PreOrderTraversal();
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
       // System.out.println(" PreOrder Traversal " + tree.preOrder(root));
       // System.out.println(" InOrder Traversal " + tree.inOrder(root));
        System.out.println(" PostOrder "+tree.postOrder(root));
    }
}
