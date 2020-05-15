package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LevelOrderTraversalAfterTwoLevel {
    static TreeNode root;

    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int d) {
            this.data = d;
            left = right = null;
        }
    }
    public void levelOrder(TreeNode root) {
        if (root == null)
            return;
        boolean flag = false;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        int count = 0 ;

        while (!queue.isEmpty()) {

            int length = queue.size();
            if(length == 1){
                System.out.print(root.data+" ");
                count++;
            }

            Stack<Integer> stack = new Stack<>();
            while (length > 0 ){
                if( !flag){
                    TreeNode temp = queue.poll();


                    if(temp.left != null) {
                        System.out.print(temp.left.data+" ");
                        queue.add(temp.left);
                    }

                    if(temp.right != null) {
                        System.out.print(temp.right.data+" ");
                        queue.add(temp.right);
                    }

                }else {
                        TreeNode temp = queue.poll();
                        if (temp.left != null) {
                            queue.add(temp.left);
                            stack.push(temp.left.data);
                        }

                        if (temp.right != null) {
                            queue.add(temp.right);
                            stack.push(temp.right.data);
                        }

                }
                length--;
            }
            if(!stack.isEmpty()){
                while (!stack.isEmpty()){
                    System.out.print(stack.pop()+" ");
                }
            }
            count=count+1;
            if(count % 2 == 0){
                if(!flag) {
                    flag = true;
                }else {
                    flag = false;
                }
            }
        }

    }
    public static void main(String[] args) {
        LevelOrderTraversalAfterTwoLevel tree = new LevelOrderTraversalAfterTwoLevel();
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.left.left.right.left = new TreeNode(16);

        root.left.right.left = new TreeNode(3);
        root.left.right.right  = new TreeNode(1);
        root.left.right.right.left = new TreeNode(17);
        root.left.right.right.right = new TreeNode(18);

        root.right.left.left = new TreeNode(4);
        root.right.left.right = new TreeNode(2);
        root.right.left.right.right = new TreeNode(19);

        root.right.right.left = new TreeNode(7);
        root.right.right.right = new TreeNode(2);

        tree.levelOrder(root);

    }
}
