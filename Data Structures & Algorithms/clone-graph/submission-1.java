/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        // mapping from original to copy node
        Map<Node,Node> map = new HashMap<>();

        return helper(node, map);
    }
    private Node helper(Node org, Map<Node,Node> map) {
        if(org == null) return null;
        else if(map.containsKey(org)) return map.get(org);

        ArrayList<Node> newNeighbors = new ArrayList<>();

        Node newNode = new Node(org.val,newNeighbors);
        map.put(org,newNode);

        for(Node nextOrg : org.neighbors) {
            if(map.containsKey(nextOrg)) {
                newNeighbors.add(map.get(nextOrg));
            } else {
                Node newNeighbour = helper(nextOrg,map);
                map.put(nextOrg, newNeighbour);
                newNeighbors.add(newNeighbour);
            }
        }
        
        return newNode;
    }
}