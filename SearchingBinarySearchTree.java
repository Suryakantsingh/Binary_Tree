package tree;

import array.SearchInRotatedArray;

public class SearchingBinarySearchTree {
   static Node root;

    static class Node {
        int key;
        Node left;
        Node right;

        Node(int d) {
            this.key = d;
            left = right = null;
        }
    }

    public Node Search(Node root,int key){

        if(root == null || root.key == key)
            return root;

        if(root.key > key){
           return Search(root.left,key);
        }

        return Search(root.right,key);
    }

    public void print(Node root){
        if(root != null){
            print(root.left);
            System.out.print(root.key+" ");
            print(root.right);
        }
    }
    public Node insertRec(Node root,int key){
        if(root == null){
            root = new Node(key);
            return root;
        }

        if(root.key < key){
           root.right =  insertRec(root.right, key);
        }

        if(root.key > key){
            root.left = insertRec(root.left,key);
        }

        return root;
    }

    public void insert(int key){
        root = insertRec(root,key);
    }

    public static void main(String[] args) {


        SearchingBinarySearchTree search = new SearchingBinarySearchTree();

        System.out.println();
        search.insert(8);
        search.insert(3);
        search.insert(10);
        search.insert(1);
        search.insert(6);
        search.insert(4);
        search.insert(7);
        search.insert(14);
        search.insert(13);
        search.print(root);
        System.out.println(search.Search(root,6));
    }
}
