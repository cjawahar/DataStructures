package LinkedLists;

public class LLNode {
    public int data;
    public LLNode next;
    public LLNode prev;
    public LLNode last;

    public LLNode() {};

    public LLNode(int d, LLNode next, LLNode prev) {
        setNext(next);
        setPrevious(prev);
        data = d;
    }

    public void setNext(LLNode n) {
        next = n;
        if (this == last) {
            last = n;
        }
        if (n != null && n.prev != this) {
            n.setPrevious(this);
        }
    }

    public void setPrevious(LLNode p) {
        prev = p;
        if (p != null && p.next != this) {
            p.setNext(this);
        }
    }

    public String printForward() {
        if (next != null) {
            return data + "->" + next.printForward();
        } else {
            return ((Integer) data).toString();
        }
    }

    public LLNode clone() {
        LLNode next2 = null;
        if (next != null) {
            next2 = next.clone();
        }
        LLNode head2 = new LLNode(data, next2, null);
        return head2;
    }

    void appendToTail(int d) {
        LLNode end = new LLNode();
        LLNode n = this;

        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }
}
