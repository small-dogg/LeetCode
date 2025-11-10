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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //연결 리스트 head 가 주어지며, 뒤에서 n번째 노드를 제거하고 head를 반환

        //head 길이 구하기
        int len = getLen(head);

        ListNode dummy = new ListNode(0, head);
        ListNode curr = dummy;
        for (int i = 0; i <= len - n; i++) {
            curr = curr.next;
        }
        curr.next = curr.next.next;

        return dummy.next;
    }

    private int getLen(ListNode head) {
        int len = 0;
        while (head.next != null) {
            len++;
            head = head.next;
        }

        return len;
    }
}