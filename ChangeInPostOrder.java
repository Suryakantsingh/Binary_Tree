package tree;

public class ChangeInPostOrder {
    static Node root;
//Not 100 clear because of recursion
    static class Node {

        int data;
        Node left, right;

        Node(int d) {
            this.data = d;
            left = right = null;
        }
    }

    static int preIndex = 0;

    public void printPost(int[] in, int[] pre, int start, int end) {

        if (start > end)
            return;

        int inIndex = search(in, start, end, pre[preIndex++]);

        printPost(in, pre, start, inIndex - 1);

        printPost(in, pre, inIndex + 1, end);

        System.out.print(in[inIndex] + " ");


    }

    public int search(int[] inOrder, int start, int end, int data) {
        int i = 0;
        for (i = start; i < end; i++) {
            if (inOrder[i] == data) {
                return i;
            }
        }
        return i;
    }

    public static void main(String[] args) {

        ChangeInPostOrder tree = new ChangeInPostOrder();
        int[] in = {4, 2, 5, 1, 3, 6};
        int[] pre = {1, 2, 4, 5, 3, 6};
        int len = in.length;
        tree.printPost(in, pre, 0, len - 1);

    }
}
