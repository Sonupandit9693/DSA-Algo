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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // add all value in Heap
        for(ListNode list : lists){
            while(list != null){
                minHeap.add(list.val);
                list = list.next;
            }
        }

        // create merge list
        ListNode dummy = new ListNode(1);
        ListNode mergeList = dummy;
        while(! minHeap.isEmpty()){
            mergeList.next = new ListNode(minHeap.remove());
            mergeList = mergeList.next;
        }

        return dummy.next;
    }
}