/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode ptr = head;
        ListNode kTail = null;
        ListNode newHead = null;

        while(ptr != null){
            int count = 0;
            ptr = head;
            while(count < k && ptr != null){
                ptr = ptr.next;
                count ++;
            }

            if(count == k){
                ListNode reverseHead = reverseLinkedList(head, k);

                if(newHead == null){
                    newHead = reverseHead;
                }

                if(kTail != null){
                    kTail.next = reverseHead;
                }

                kTail = head;
                head = ptr;
            }
        }

        if(kTail != null){
            kTail.next = head;
        }

        return newHead != null ? newHead: null;
        
    }

    public ListNode reverseLinkedList(ListNode head, int k){
        ListNode newHead = null;
        ListNode ptr = head;

        while(k > 0){
            ListNode nextNode = ptr.next;
            ptr.next = newHead;
            newHead = ptr;
            ptr = nextNode;
            k--;
        }
        return newHead;
    }
}