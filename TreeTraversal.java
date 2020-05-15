package tree;

public class TreeTraversal {
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
        print(root.left);
        System.out.print(root.data + " ");
        print(root.right);
    }

    public void inOrder(Node node) {
        if (node == null)
            return;

        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    public void postOrder(Node node) {
        if (node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }

    public void preOrder(Node node) {
        if (node == null)
            return;

        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void main(String[] args) {

        TreeTraversal tree = new TreeTraversal();
//        root = new Node(1);
//        root.left = new Node(2);
//        root.right = new Node(3);
//        root.left.left = new Node(4);
//        root.left.right = new Node(5);
        root = new Node(1);
        root.left = new Node(0);
        root.right = new Node(1);
        root.left.left = new Node(0);
        root.left.right = new Node(1);
        root.right.left = new Node(0);
        root.right.right = new Node(1);
        System.out.println("Inorder Traversal");
        tree.inOrder(root);
        System.out.println("PostOrder Traversal");
        tree.postOrder(root);
        System.out.println("PreOrder Traversal");
        tree.preOrder(root);

    }
}
