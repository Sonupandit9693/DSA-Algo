/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        flattenList(head);
        return head;
    }

    // Helper function returns the tail of the flattened list
    private Node flattenList(Node node) {
        Node curr = node;
        Node last = null;

        while (curr != null) {
            Node next = curr.next;

            // If current node has a child, recursively flatten it
            if (curr.child != null) {
                Node childHead = curr.child;
                Node childTail = flattenList(childHead);  // recursively flatten the child list

                // Insert the child list between curr and next
                curr.next = childHead;
                childHead.prev = curr;
                curr.child = null;

                if (next != null) {
                    childTail.next = next;
                    next.prev = childTail;
                }

                last = childTail;
                curr = next;
            } else {
                last = curr;
                curr = curr.next;
            }
        }

        return last;  // return the tail node after flattening
    }
}
