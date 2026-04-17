class LRUCache {
    private int size = 0;
    private HashMap<Integer, Integer> map;
    private List<Integer> keys;

    public LRUCache(int capacity) {
        keys = new LinkedList<Integer>();
        map = new HashMap<>();
        size = capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            int keyIndex = keys.indexOf(key);
            int removedKey = keys.remove(keyIndex);
            keys.add(removedKey);
            return map.get(key);
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key))
        {
            int keyIndex = keys.indexOf(key);
            int removedKey = keys.remove(keyIndex);
            keys.add(removedKey);
            map.put(key, value);
            return;
        }

        if(keys.size() == size)
        {
            int removedKey = keys.remove(0);
            map.remove(removedKey);
        }

        keys.add(key);
        map.put(key, value);

    }
}
