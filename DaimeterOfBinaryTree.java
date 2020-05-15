package tree;

import java.util.Stack;

public class DaimeterOfBinaryTree {
    static Node root;

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int d) {
            this.data = d;
            left = null;
            right = null;
        }
    }

    public void inorder(Node root) {

        if (root == null)
            return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);

    }
    int diameter = 0;
    public int diameter(Node root) {
       return height(root);
    }


    public int height(Node root){
        if(root == null)
            return 0;


       int left = height(root.left);
       int right =  height(root.right);
        diameter = Math.max(left+right, diameter);
        return Math.max(left,right)+1;
    }




    public static void main(String[] args) {
        DaimeterOfBinaryTree binaryTree = new DaimeterOfBinaryTree();
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);
       // binaryTree.inorder(root);
        System.out.print(binaryTree.diameter(root));
    }
}
