package Questions.Chapter4;

/*
    Implement a function to check if a binary tree is balanced.
    A balanced tree is defined to be a tree such that the heights
    of the two subtrees of any node never differ by more than one.
*/

public class Question4_1 {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(25);
        root.insert(12);
        root.insert(13);
        root.insert(29);

        // Question 4_3 is basically here.
        // Sorted increasing order array, create a BST with minimal height
        // So equalize both left and right sides.
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root2 = TreeNode.createBST(array);

        /*
            Tree is unbalanced if the height of two subtrees
            of the SAME node differ by more than 1.
         */
        root2.insert(25);     //Right side unbalance/balance.
        //root2.insert(9);
                                //Left side unbalance/balance.
        root2.insert(4); // Insert 4 unbalances node3
        root2.insert(3); // Add 3 to balance node 3.

        TreeNode.print2D(root);
        System.out.println(balancedTree(root));

        System.out.println("================================================");

        TreeNode.print2D(root2);
        System.out.println(balancedTree(root2));
    }

    public static int checkTreeHeight(TreeNode inputTree) {

        if (inputTree == null) {
            return 0; // False
        }

        int leftHeight = checkTreeHeight(inputTree.left);
        if (leftHeight == -1) {
            return -1;
        }

        int rightHeight = checkTreeHeight(inputTree.right);
        if (rightHeight == -1) {
            return -1;
        }

        int heightDelta = leftHeight - rightHeight;
        if (Math.abs(heightDelta) > 1) {
            return -1;
        }
        else {
            return Math.max(leftHeight, rightHeight) + 1; // +1 to account for root node.
        }
    }

    public static boolean balancedTree(TreeNode inputTree) {
        return (checkTreeHeight(inputTree) != -1 && checkTreeHeight(inputTree) != 0);
    }
}
