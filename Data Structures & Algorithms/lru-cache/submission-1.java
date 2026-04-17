class LRUCache {
    private class Node {
        private int key;
        private int value;
        private Node next;
        private Node prev;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            next = null;
            prev = null;
        }
    }

    private int capacity;
    private Node left;
    private Node right;
    private HashMap<Integer, Node> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;

        left = new Node(0, 0);
        right = new Node(0, 0);

        left.next = right;
        right.prev = left;

        cache = new HashMap<>();
    }

    public void add(Node node) {
        Node prev = right.prev;
        Node next = right;

        prev.next = node;
        next.prev = node;

        node.next = next;
        node.prev = prev;
    }

    public void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
            add(node);
            return node.value;
        }

        return -1;
    }
    
    public void put(int key, int value) {
        Node newNode = new Node(key, value);

        if(cache.containsKey(key)) 
            remove(cache.remove(key));
        
        add(newNode);
        cache.put(key, newNode);

        if(cache.size() > capacity) {
            Node LRU = left.next;
            remove(LRU);
            cache.remove(LRU.key);
        }
    }
}
