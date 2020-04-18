package Questions;
import java.util.ArrayList;
import java.util.LinkedList;

/*
    Given a BST, design an algorithm which creates a linked list
    of all the nodes at each depth. EX. Depth D = D linked lists.
 */
public class Question4_4 {

    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        TreeNode tree = TreeNode.createBST(array);
        TreeNode.print2D(tree);

        ArrayList<LinkedList<TreeNode>> list = createSameDepthLinkedList(tree);
    }

    public static ArrayList<LinkedList<TreeNode>> createSameDepthLinkedList(TreeNode inputTree) {
        // This would be the list for the first level -- currently empty.
        ArrayList<LinkedList<TreeNode>> list = new ArrayList<>();

        LinkedList<TreeNode> iterator = new LinkedList<>();
        if (inputTree != null) {
            iterator.add(inputTree);
        }

        while (iterator.size() > 0) {
            // First iteration = first level -- contains all child nodes.
            // 2nd iteration of loop -- adds to list.
            list.add(iterator);

            LinkedList<TreeNode> newLevel = iterator;
            // Below line -- will empty the LL each run
            iterator = new LinkedList<>();

            // Use this for loop to add each left/right node at this level.
            for (TreeNode level : newLevel) {
                if (level.left != null) {
                    iterator.add(level.left);
                }
                if (level.right != null) {
                    iterator.add(level.right);
                }
            }
        }
        return list;
    }
}