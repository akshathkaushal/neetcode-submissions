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
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode nextHead = reverseList(head.next);

        if(head.next != null) {
            head.next.next=head;
        }
        
        head.next=null;
        return nextHead;
    }
}
