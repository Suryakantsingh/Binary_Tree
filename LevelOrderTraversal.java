package tree;

import array.LeftColumnAtLeastOne;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    static TreeNode root;

    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int d) {
            this.data = d;
            left = right = null;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> outerList = new ArrayList();
        Queue<TreeNode> queue = new LinkedList();

        if (root == null)
            return outerList;

        queue.add(root);
        List<Integer> list1 = new ArrayList<>();
        list1.add(root.data);
        outerList.add(list1);
        int count = 0;



        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int counter = 0;
            while(counter < outerList.get(count).size() ) {
                TreeNode temp = queue.poll();


                if (temp.left != null) {
                    queue.add(temp.left);
                    list.add(temp.left.data);
                }

                if (temp.right != null) {
                    queue.add(temp.right);
                    list.add(temp.right.data);
                }
                counter++;
            }

            if(!list.isEmpty())
               outerList.add(list);

            count++;
        }
        return outerList;
    }

    public static void main(String[] args) {
        LevelOrderTraversal tree = new LevelOrderTraversal();
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        System.out.println(tree.levelOrder(root));
    }
}
