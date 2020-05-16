/*
Reverse alternate levels of a perfect binary tree
GeeksforGeeks ----> Binary Tree------> Traversal ---> 20. Reverse alternate levels of a perfect binary tree
Given tree: 
               a
            /     \
           b       c
         /  \     /  \
        d    e    f    g
       / \  / \  / \  / \
       h  i j  k l  m  n  o 

Modified tree:
             a
            /     \
           c       b
         /  \     /  \
        d    e    f    g
       / \  / \  / \  / \
      o  n m  l k  j  i  h 

output : a c b d e f g o n m l k j i h 
*/
package tree.binaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Reverse_Alerternate_Level {
    static TreeNode root;

    static class TreeNode {
        char data;
        TreeNode left, right;

        TreeNode(char d) {
            this.data = d;
            left = right = null;
        }
    }

    public void levelOrder(TreeNode root) {
        if (root == null)
            return;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        System.out.print(root.data + " ");

        boolean flag = false;


        while (!queue.isEmpty()) {
            Stack<Character> stack = new Stack<>();
            int length = queue.size();

            while (length > 0) {

                TreeNode temp = queue.poll();
                if (!flag) {

                    if (temp.left != null) {
                        queue.add(temp.left);
                        stack.push(temp.left.data);
                    }

                    if (temp.right != null) {
                        queue.add(temp.right);
                        stack.push(temp.right.data);

                    }
                } else {

                    if (temp.left != null) {
                        queue.add(temp.left);
                        System.out.print(temp.left.data + " ");
                    }

                    if (temp.right != null) {
                        queue.add(temp.right);
                        System.out.print(temp.right.data + " ");
                    }
                }
                length--;
            }
            while (!stack.isEmpty()) {
                System.out.print(stack.pop() + " ");
            }
            if (flag) {
                flag = false;
            } else {
                flag = true;
            }
        }
    }

    public static void main(String[] args) {

        Reverse_Alerternate_Level tree = new Reverse_Alerternate_Level();
        root = new TreeNode('a');
        root.left = new TreeNode('b');
        root.right = new TreeNode('c');

        root.left.left = new TreeNode('d');
        root.left.right = new TreeNode('e');

        root.right.left = new TreeNode('f');
        root.right.right = new TreeNode('g');

        root.left.left.left = new TreeNode('h');
        root.left.left.right = new TreeNode('i');

        root.left.right.left = new TreeNode('j');
        root.left.right.right = new TreeNode('k');

        root.right.left.left = new TreeNode('l');
        root.right.left.right = new TreeNode('m');

        root.right.right.left = new TreeNode('n');
        root.right.right.right = new TreeNode('o');

        tree.levelOrder(root);
    }
}
