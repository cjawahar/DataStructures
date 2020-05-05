package Questions.Chapter2;

import LinkedLists.LLNode;

/*
    Given a circular linked list, implement an algorithm which returns
    the node at the beginning of the loop
    Definition - Circular Linked List:
        A (corrupt) linked list in which a node's next pointer points
        to an earlier node, which makes a loop.
    Ex.
    Input: A -> B -> C -> D -> E -> C
    Output: C
 */
public class Question2_6 {
    public static void main(String[] args) {
        // How to make the circular LL? Don't use LLNode constructor
        int listLen = 20;
        int circle = 10;

        LLNode[] nodeArr = new LLNode[listLen];
        for (int i = 0; i < listLen; i++) {
            // Can set prev node here...
            nodeArr[i] = new LLNode(i, null, i > 0 ? nodeArr[i - 1] : null);
        }
        // Manually adding the loop with circle variable.
        nodeArr[listLen - 1].next = nodeArr[listLen - circle];

        LLNode loopNode = findLoop(nodeArr[0]);
        System.out.println(loopNode.data);
    }

    // Detect conflict with slow/fast node runner.
    public static LLNode findLoop(LLNode head) {
        LLNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                // This would be the meeting point.
                break;
            }
        }
        // Check in case there actually isn't a loop - no meeting point.
        // If loop exists, fast and it's next would never become null
        if (fast == null || fast.next == null) {
            return null;
        }

        // Return slow node to input head node.
        // Loop again but at same speed this time.
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return fast;
    }
}
