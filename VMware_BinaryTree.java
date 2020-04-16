package BinaryTrees;

public class VMware_BinaryTree {
    public static void main(String args[]) throws Exception {

        BinaryTree tree = new BinaryTree();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.right.right = new Node(5);
        tree.root.left.left.left = new Node(5);

        populateNextNeighbors(tree);
    }

    //                  1
//                    2.  3.
//                  4. 5  6 8
//                6                 (say 7 doesn't exist we should populate it via method)

    public static void populateNextNeighbors(BinaryTree tree) {

        if (tree == null) {
            return;
        }

        if (tree.root.key == 1) {
            //Do nothing -- top of tree no neighbors
        }

        int depth = tree.maxDepth(tree.root);
        System.out.println(tree);
    }
}

class BinaryTree {
    Node root;

    int maxDepth(Node node)
    {
        if (node == null) {
            return 0;
        }
        else
        {
            int leftDepth = maxDepth(node.left);
            int rightDepth = maxDepth(node.right);

            if (leftDepth > rightDepth) {
                return (leftDepth + 1);
            } else {
                return (rightDepth + 1);
            }
        }
    }
}

class Node {
    int key;
    Node left, right;
    Node neighbor;

    public Node(int item) {
        key = item;
        left = null;
        right = null;
        neighbor = null;
    }
}
