package Questions.Chapter4;

/*
    Given a sorted (increasing order) array, write an algorithm to
    create a binary search tree with minimal height.
 */
public class Question4_3 {

    public static void main(String[] args) {

        // Question 4_3 is basically here.
        // Sorted increasing order array, create a BST with minimal height
        // So equalize both left and right sides.

        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // This method will build the BST with the root being the middle of the
        // input array. Which ensures both left/right sides are not unbalanced.
        // This means the height will be minimized -- no overly long left/right sides.
        TreeNode root = TreeNode.createBST(array);
        TreeNode.print2D(root);
    }
}
