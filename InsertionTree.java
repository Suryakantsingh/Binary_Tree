package tree;

import java.util.LinkedList;
import java.util.Queue;

public class InsertionTree {
    static Node root;
    static Node temp;

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int d) {
            this.data = d;
            this.left = null;
            this.right = null;
        }
    }

    public void inorder(Node temp) {

        if (temp == null)
            return;

        inorder(temp.left);
        System.out.print(temp.data + " ");
        inorder(temp.right);

    }

    public void insertion(Node temp, int key) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(temp);
        while (!queue.isEmpty()){
            temp = queue.peek();
            queue.remove();
            if(temp.left == null){
                temp.left = new Node(key);
                break;
            }else{
                queue.add(temp.left);
            }

            if(temp.right == null){
                temp.right = new Node(key);
                break;
            }else{
                queue.add(temp.right);
            }
        }

    }

    public static void main(String[] args) {

        root = new Node(10);
        root.left = new Node(11);
        root.left.left = new Node(7);
        root.right = new Node(9);
        root.right.left = new Node(15);
        root.right.right = new Node(8);
        InsertionTree insertionTree = new InsertionTree();
        insertionTree.inorder(root);
        insertionTree.insertion(root,12);
        System.out.println();
        insertionTree.inorder(root);
    }
}
