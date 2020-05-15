package tree;

import java.util.LinkedList;
import java.util.List;

public class LeafSimilarTree {
    static TreeNode root1;
    static TreeNode root2;

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int data) {
            this.val = data;
            left = right = null;
        }
    }

    static List<Integer> list = new LinkedList<Integer>();
    static List<Integer> lis1 = new LinkedList<Integer>();

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        if (root1 == null && root2 == null) {
            return true;
        }

        leafStore(root1, list);
        leafStore(root2, lis1);
        boolean result = compare(list,lis1);
        lis1.clear();
        list.clear();
        return result;
    }

    public boolean compare(List list, List list1) {
        if (list.size() != list1.size())
            return false;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != list1.get(i))
                return false;
        }
        return true;
    }

    public List<Integer> leafStore(TreeNode root, List list) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            list.add(root.val);
        }

        leafStore(root.left, list);
        leafStore(root.right, list);
        return list;
    }

    public static void main(String[] args) {
        LeafSimilarTree tree = new LeafSimilarTree();
        root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
//        root1.right = new TreeNode(1);
//        root1.left.left = new TreeNode(6);
//        root1.left.right = new TreeNode(2);
//        root1.left.right.left = new TreeNode(7);
//        root1.left.right.right = new TreeNode(4);
//        root1.right.left = new TreeNode(9);
//        root1.right.right = new TreeNode(8);
        root2 = new TreeNode(2);
        root2.left = new TreeNode(2);
        System.out.println(tree.leafSimilar(root1,root2));
        System.out.println(list+" And "+lis1);
    }
}
