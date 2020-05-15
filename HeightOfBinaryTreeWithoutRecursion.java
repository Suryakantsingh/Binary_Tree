package tree;

import java.util.Stack;

public class HeightOfBinaryTreeWithoutRecursion {
    static Node root;

    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            this.data = d;
            left = right = null;
        }
    }

    public int heightLeftSubtree(Node root) {
        if (root == null)
            return 0;

        Node temp = root;

        Stack<Node> stack = new Stack<>();

        while (temp.left != null) {
            stack.add(temp.left);
            temp = temp.left;
        }

        int size1 = stack.size();
        stack.removeAllElements();

        while (root.right != null) {
            stack.add(root.right);
            root = root.right;
        }

        int size2 = stack.size();

        if(size1 > size2){
            return size1;
        }else{
            return size2;
        }
    }

    public int heightOfTree(Node root){
        int height = heightLeftSubtree(root);
        return height+1;
    }

    public static void main(String[] args) {

        root = new Node(15);
        root.left = new Node(10);
        root.right = new Node(20);
        root.left.left = new Node(8);
        root.left.right = new Node(12);
        root.right.left = new Node(16);
        root.right.right = new Node(25);

        HeightOfBinaryTreeWithoutRecursion heightOfBinaryTreeWithoutRecursion = new HeightOfBinaryTreeWithoutRecursion();
        System.out.println("Height of tree is: "+heightOfBinaryTreeWithoutRecursion.heightOfTree(root));

    }
}
