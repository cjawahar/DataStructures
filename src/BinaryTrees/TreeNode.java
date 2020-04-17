public class TreeNode {
    public int data;
    public TreeNode left;
    public TreeNode right;
    public TreeNode parent;
    private int size = 0;

    public TreeNode(int d) {
        data = d;
        size = 1;
    }

    public static TreeNode createBST(int[] array) {
        return createBST(array, 0, array.length - 1);
    }

    private static TreeNode createBST(int[] array, int start, int end) {

        if (end < start) {
            return null;
        }
        int middle = (start + end) / 2;
        // Make the node of this tree = middle element of input array
        TreeNode n = new TreeNode(array[middle]);

        n.setLeftChild(createBST(array, start, middle - 1));
        n.setRightChild(createBST(array, middle + 1, end));

        return n;
    }

    // This method will ensure the value is added in order to the BST.
    public void insert(int value) {
        if (value <= data) {
            if (left == null) {
                //left = new TreeNode(value);
                setLeftChild(new TreeNode(value));
            } else {
                left.insert(value);
            }
        } else {
            if (right == null) {
                //right = new TreeNode(value);
                setRightChild(new TreeNode(value));
            } else {
                right.insert(value);
            }
        }
        size++;
    }

    private void setLeftChild(TreeNode left) {
        this.left = left;
        if (left != null) {
            left.parent = this;
        }
    }

    private void setRightChild(TreeNode right) {
        this.right = right;
        if (right != null) {
            right.parent = this;
        }
    }

    // Print 2D Tree ===============================================

    static final int COUNT = 10;
    static void print2DUtil(TreeNode root, int space)
    {
        // Base case
        if (root == null)
            return;

        // Increase distance between levels
        space += COUNT;

        // Process right child first
        print2DUtil(root.right, space);

        // Print current node after space
        // count
        System.out.print("\n");
        for (int i = COUNT; i < space; i++)
            System.out.print(" ");
        System.out.print(root.data + "\n");

        // Process left child
        print2DUtil(root.left, space);
    }

    static void print2D(TreeNode root)
    {
        // Pass initial space count as 0
        print2DUtil(root, 0);
    }
}
