// Continuation of the VMware Problem,
// now I should be able to create a tree of N size with neighbors identified.
public class CreateBinaryTree {
    private BstNode root;

    public void assignRightNeighbors() {

    }

    public void arrInsert(int[] inputArr) {
        int i = 0;
        while(i < inputArr.length) {
            insert(inputArr[i]);
            i++;
        }
    }

    public void insert(Integer data) {

        System.out.print("[input: " + data + "]");
        if(root == null) {
            this.root = new BstNode(data);
            System.out.println(" -> inserted: " + data);
            return;
        }

        insertNode(this.root, data);
        System.out.print(" -> inserted: " + data);
        System.out.println();
    }

    private BstNode insertNode(BstNode root, Integer data) {

        BstNode tmpNode = null;
        System.out.print(" -> " + root.getData());
        if(root.getData() >= data) {
            System.out.print(" [L]");
            if(root.getLeft() == null) {
                root.setLeft(new BstNode(data));
                return root.getLeft();
            } else {
                tmpNode = root.getLeft();
            }
        } else {
            System.out.print(" [R]");
            if(root.getRight() == null) {
                root.setRight(new BstNode(data));
                return root.getRight();
            } else {
                tmpNode = root.getRight();
            }
        }
        return insertNode(tmpNode, data);
    }

    public static void main(String[] args) {
        CreateBinaryTree bst = new CreateBinaryTree();

        bst.insert(10);
        bst.insert(20);
        bst.insert(19);
        bst.insert(8);
        bst.insert(6);
        bst.insert(16);
        bst.insert(23);

        int[] secondInput = {1,2,3,4,5};
        bst.arrInsert(secondInput);

        System.out.println(bst);
        bst.assignRightNeighbors();
    }
}

class BstNode {
    int data;
    BstNode left, right;
    BstNode rightNeighbor;

    public BstNode(int Data){
        this.data = Data;
    }

    public BstNode getLeft() {
        return left;
    }

    public BstNode getRight() {
        return right;
    }

    public void setLeft(BstNode left) {
        this.left = left;
    }

    public void setRight(BstNode right) {
        this.right = right;
    }

    public Integer getData() {
        return data;
    }
}


