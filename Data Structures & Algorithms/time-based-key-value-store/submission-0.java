class TimeMap {
    private HashMap<String, TreeMap<Integer, String>> timestamps;

    public TimeMap() {
        timestamps = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> map = timestamps.getOrDefault(key, new TreeMap<>());
        map.put(timestamp, value);
        timestamps.put(key, map); 
    }
    
    public String get(String key, int timestamp) {
        if(!timestamps.containsKey(key))
            return "";

        TreeMap<Integer, String> map = timestamps.get(key);
        Map.Entry<Integer, String> entry = map.floorEntry(timestamp);
        return entry == null ? "" : entry.getValue();
    }
}
