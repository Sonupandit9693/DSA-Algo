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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return (list1 != null) ? list1 : list2;
        }

        ListNode dummy = new ListNode(1);
        ListNode merge = dummy;

        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                merge.next = list1;
                list1 = list1.next;
            }else{
                merge.next = list2;
                list2 = list2.next;
            }
            merge = merge.next;
        }

        // check remaing linked list
        merge.next = (list1 != null) ? list1 : list2;
        return dummy.next;
    }
}