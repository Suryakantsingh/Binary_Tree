package tree;

public class CheckTwoTreeIdentical {


   static class Node {
        int data;
        Node left, right;

        Node(int d) {
            this.data = d;
            left = null;
            right = null;
        }

    }

    public boolean isIdentical(Node root1,Node root2){

       boolean result = false;
       if(root1 == null && root2 == null)
           return true;



      // isIdentical(root1.left ,root2.left);
      // isIdentical(root1.right,root2.right);
       return ((root1.data == root2.data)&&(root1 != null && root2 != null)&&isIdentical(root1.left ,root2.left) && isIdentical(root1.right,root2.right));

    }

    public static void main(String[] args) {

        Node root1 = new Node(15);
        root1.left = new Node(10);
        root1.right = new Node(20);
        root1.left.left = new Node(8);
        root1.left.right = new Node(12);
        root1.right.left = new Node(16);
        root1.right.right = new Node(25);

        Node root2 = new Node(15);
        root2.left = new Node(10);
        root2.right = new Node(20);
        root2.left.left = new Node(8);
        root2.left.right = new Node(12);
        root2.right.left = new Node(16);
        root2.right.right = new Node(25);

        CheckTwoTreeIdentical tree = new CheckTwoTreeIdentical();
        if( tree.isIdentical(root1,root2) == true){
            System.out.println("Indentical");
        }else{
            System.out.println("Not identical");
        }

    }
}
