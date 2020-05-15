package tree;

import java.util.Vector;

public class CountPossibleBinaryTree {
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

    public void preOrder(Node root) {

        if (root == null)
            return;
        System.out.print(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }

    public Vector<Node> getTree(int[] in, int start, int end) {

        Vector<Node> trees = new Vector<Node>();

        if(start > end){
            trees.add(null);
            return trees;
        }

      return trees;
    }

    public static void main(String[] args) {
        CountPossibleBinaryTree countPossibleBinaryTree = new CountPossibleBinaryTree();
        int[] inOrder = {4, 5, 7};
        int len = inOrder.length;


    }
}
