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
        PriorityQueue<Pair<Integer,ListNode>> que = new PriorityQueue<>(
            (a,b) -> Integer.compare(a.getKey(),b.getKey())
        );

        for(ListNode head : lists) {
            if(head != null) que.add(new Pair<>(head.val,head));
        }

        ListNode root = new ListNode();
        ListNode temp = root;
        while(!que.isEmpty()) {
            Pair<Integer,ListNode> qTop = que.poll();
            ListNode nextNode = qTop.getValue().next;

            if(nextNode != null) {
                que.add(new Pair<>(nextNode.val, nextNode));
            }

            temp.next = qTop.getValue();
            temp=temp.next;
        }

        return root.next;
    }
}
