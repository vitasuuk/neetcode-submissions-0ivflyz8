class LRUCache {
    Map<Integer, Node> keyToNode;
    LRU usageList;
    int capacity;

    public LRUCache(int capacity) {
        keyToNode = new HashMap<>();
        usageList = new LRU();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (!keyToNode.containsKey(key)) {
            return -1;
        }

        Node found = keyToNode.get(key);

        usageList.remove(found);
        usageList.add(found);

        return found.getValue();
    }
    
    public void put(int key, int value) {
        // If there is existing Node with such key, change value
        if (keyToNode.containsKey(key)) {
            Node found = keyToNode.get(key);
            usageList.remove(found);
            found.value = value;
            usageList.add(found);
            return;
        } 
        // Capacity is reached, remove LRU
        if (keyToNode.size() == capacity) {
            Node lru = usageList.getLeastRecent();
            usageList.remove(lru);
            keyToNode.remove(lru.getKey());
        }

        Node created = new Node(key, value);
        usageList.add(created);
        keyToNode.put(key, created);
    }

    class LRU {
        private Node head;
        private Node tail;
        private int size;

        public LRU() {
            size = 0;
        }

        // Adds node to the list. Added node becomes
        // most recent
        public void add(Node node) {
            if (size == 0) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                node.prev = tail;
                tail = node;
            }
            
            size++;
        }

        public void remove(Node node) {
            if (node == head) {
                head = head.next;
            }

            if (node == tail) {
                tail = node.prev;
            }

            if (node.prev != null) {
                node.prev.next = node.next;
            }

            if (node.next != null) {
                node.next.prev  = node.prev;
            }

            node.prev = null;
            node.next = null;
            size--;
        }

        public Node getLeastRecent() {
            return head;
        }
    }

    class Node {
            int key;
            int value;

            Node prev;
            Node next;

            public Node (int key, int value) {
                this.key = key;
                this.value = value;
            }

            public int getKey() {
                return key;
            }

            public int getValue() {
                return value;
            }
        }
}
