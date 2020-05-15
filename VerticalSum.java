package tree;

import java.util.TreeMap;

public class VerticalSum {

    static Node root;

    VerticalSum(){ this.root = null; }
    VerticalSum(Node n){ this.root = n;}

    static class Node {
        int key;
        Node left, right;

        public int key() {
            return key;
        }

        public Node left() {
            return left;
        }

        public Node right() {
            return right;
        }

        Node(int key) {
            this.key = key;
            left = null;
            right = null;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }

    }

    public void print(Node root) {
        if (root == null)
            return;

        print(root.left);
        System.out.print(root.key + " ");
        print(root.right);
    }



    public void verticalSum() {
        verticalSumM(root);
    }

    public void verticalSumM(Node root) {
        if (root == null)
            return;

        TreeMap<Integer, Integer> hM = new TreeMap<Integer, Integer>();
        verticalSumUtil(root, 0, hM);

        if(hM != null)
            System.out.println(hM.entrySet());

    }

    public void verticalSumUtil(Node root, int hD, TreeMap<Integer, Integer> hM) {

        if (root == null)
            return;
        verticalSumUtil(root.left(), hD - 1, hM);

        int prevSum = (hM.get(hD) == null) ? 0 : hM.get(hD);
        hM.put(hD, prevSum + root.key());
        verticalSumUtil(root.right(), hD + 1, hM);

    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.setLeft(new Node(2));
        root.setRight(new Node(3));
        root.left().setLeft(new Node(4));
        root.left().setRight(new Node(5));
        root.right().setLeft(new Node(6));
        root.right().setRight(new Node(7));
        VerticalSum tree = new VerticalSum(root);
        tree.verticalSum();
        tree.print(root);
    }
}
