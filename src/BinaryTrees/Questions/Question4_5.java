package Questions;
/*
    Implement a function to check if a binary tree is a BST
 */
public class Question4_5 {

    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        TreeNode tree = TreeNode.createBST(array);
        //TreeNode.print2D(tree);

        boolean isBST = checkIfBST(tree);
        System.out.println(isBST);
    }

    // Need to place static var outside - or breaks recursive loop, reassigned to null.
    static Integer initialVal = null;
    public static boolean checkIfBST(TreeNode tree) {
        if (tree == null) {
            return true;
        }

        if (!checkIfBST(tree.left)) {
            return false;
        }

        if (initialVal != null && tree.data <= initialVal) {
            return false;
        }
        initialVal = tree.data;

        if (!checkIfBST(tree.right)){
            return false;
        }
        return true;
    }
}
