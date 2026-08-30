class Node {
    int key;
    int value;
    Node next;
    Node prev;

    public Node(int key, int value) {
        this.key=key;
        this.value=value;
        this.next=null;
        this.prev=null;
    }
}

class LRUCache {
    private int capacity;
    private Map<Integer,Node> lru;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        this.lru = new HashMap<>();
        this.head = new Node(0,0);
        this.tail = new Node(0,0);

        // create doubly linked list
        this.head.prev = null;
        this.head.next = tail;
        this.tail.next = null;
    }
    
    public int get(int key) {
        if(lru.containsKey(key)) {
            Node cur = lru.get(key);
            remove(cur);
            insert(cur);
            return cur.value;
        }

        return -1;     
    }
    
    public void put(int key, int value) {
        // remove the original node
        if(lru.containsKey(key)) {
            remove(lru.get(key));
        }

        Node newNode = new Node(key,value);
        lru.put(key,newNode);
        insert(newNode);

        if(lru.size() > capacity) {
            Node tailNode = this.tail.prev;
            remove(tailNode);
            lru.remove(tailNode.key);
        }
    }

    private void insert(Node node) {
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    private void remove(Node node) {
        Node prv = node.prev;
        Node nxt = node.next;
        prv.next = nxt;
        nxt.prev = prv;
    }
}
