/*
Calculate depth of a full Binary tree from Preorder
*/
package tree.binaryTree;

public class Calculate_Height {
    static public int findDepth (String tree, int n ) {

          int index = 0;
         return findRecDepth(tree,n,index);
    }
    static public int findRecDepth(String tree, int n, int index) {
        if(tree.charAt(index) == 'l' || index >= n) {
            return 0;
        }
        index++;
        int left = findRecDepth( tree,  n, index);
        index++;
        int right = findRecDepth( tree, n, index);
        return Math.max(left,right)+1;
    }
    public static void main( String[] args ) {
        String tree = "nlnnlll";
        System.out.println(findDepth(tree,tree.length()));
    }
}
