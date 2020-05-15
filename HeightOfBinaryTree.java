package tree;

public class HeightOfBinaryTree {
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

    int leftChildHeight = 0;

    int rightChildHeight = 0;

    public int height(Node root) {

        if (root == null)
            return 0;


        int left = leftSubtree(root.left);
        int right = rightSubtree(root.right);

        int result = 0 ;
        if (left < right) {
            result = right;
        } else {
            result = left;
        }

        return result + 1;
    }

    public int leftSubtree(Node root) {

        if(root == null)
            return 0;

        leftChildHeight++;
        leftSubtree(root.left);
        return leftChildHeight;
    }

    public int rightSubtree(Node root) {

        if(root == null)
            return 0;

        rightChildHeight++;
        rightSubtree(root.right);
        return rightChildHeight;
    }

    public void print(Node root) {

        if (root == null)
            return;

        print(root.left);
        System.out.print(root.data + " ");
        print(root.right);
    }

    public static void main(String[] args) {

        root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(1);
        root.left.left = new Node(3);
        root.left.right = new Node(1);
        root.left.right.left = new Node(5);
       // root.right.right = new Node(25);

        HeightOfBinaryTree heightOfBinaryTree = new HeightOfBinaryTree();
        heightOfBinaryTree.print(root);

        System.out.println();
        System.out.print(heightOfBinaryTree.height(root));

    }
}
