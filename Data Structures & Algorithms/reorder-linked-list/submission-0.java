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
    public void reorderList(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;

        while(fast.next != null && fast.next.next != null) {
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode list2 = slow.next;
        slow.next=null;

        ListNode list1=head;
        list2 = reverse(list2);

        ListNode temp = new ListNode();
        while(list1!=null && list2!=null) {
            temp.next=list1;
            list1=list1.next;
            temp=temp.next;

            temp.next=list2;
            list2=list2.next;
            temp=temp.next;
        }

        if(list1!=null) {
            temp.next=list1;
        }
        if(list2!=null) {
            temp.next=list2;
        }
    }
    // returns reversed Linked list
    private ListNode reverse(ListNode head) {
        if(head == null) return head;

        ListNode nextHead = head;
        if(head.next != null) {
            nextHead = reverse(head.next);
            head.next.next=head;
        }
        head.next=null;
        return nextHead;
    }
}
