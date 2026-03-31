class LRUCache {
    Queue<Integer> keyQueue;
    Map<Integer, Integer> hm;
    int currSize = 0;
    int capacity;

    public LRUCache(int capacity) {
        keyQueue = new LinkedList<>();
        hm = new HashMap<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (!hm.containsKey(key)) {
            return -1;
        }
    
        keyQueue.remove(key);
        keyQueue.offer(key);
        return hm.get(key);
    }
    
    public void put(int key, int value) {
        if (hm.containsKey(key)) {
            keyQueue.remove(key);
        } else if (hm.size() >= capacity) {
            int lruKey = keyQueue.poll();
            hm.remove(lruKey);
        }

        hm.put(key, value);
        keyQueue.offer(key);
    }
}
