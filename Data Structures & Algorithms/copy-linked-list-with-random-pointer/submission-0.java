/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        // Map of original node to new node
        Map<Node,Node> nodes = new HashMap<>();    

        Node temp = new Node(-101);
        Node ptr = temp;
        
        while(head != null) {
            if(!nodes.containsKey(head)) {
                nodes.put(head, new Node(head.val));
            }
            temp.next=nodes.get(head);

            if(head.random!=null && !nodes.containsKey(head.random)) {
                nodes.put(head.random, new Node(head.random.val));
            }
            temp.next.random = nodes.get(head.random);

            head=head.next;
            temp=temp.next;
        }

        return ptr.next;
    }
}
