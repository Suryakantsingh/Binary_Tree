package tree;

import java.util.Stack;

public class InorderWithoutStackWithoutRecursion {

    Stack<Node> stack = new Stack<Node>();
    static Node root;

    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            this.data = d;
            left = null;
            right = null;
        }

    }

    public void print(Node root) {

        if (root == null)
            return;

        while (root != null || stack.size() > 0) {

            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.pop();
            System.out.print(root.data + " ");
            root = root.right;
        }

    }



    public static void main(String[] args) {

        InorderWithoutStackWithoutRecursion tree = new InorderWithoutStackWithoutRecursion();
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        tree.print(root);
    }
}
