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
        ListNode dHead = new ListNode(Integer.MIN_VALUE);
        ListNode curr = dHead;

        while(list1 != null && list2 != null){  // 머지대상이 남아있으면 반복
            if(list1.val < list2.val){
                curr.next = list1;
                list1 = list1.next;
            }else{
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        if(list1==null){ curr.next = list2;}
        if(list2==null){ curr.next = list1;}

        return dHead.next;
    }
}