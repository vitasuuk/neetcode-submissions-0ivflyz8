class TimeMap {
    Map<String, ArrayList<Pair<Integer, String>>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair<>(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        List<Pair<Integer, String>> vals = map.getOrDefault(key, new ArrayList<>());
        int lo = 0, hi = vals.size() - 1;
        String res = "";

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (vals.get(mid).getKey() <= timestamp) {
                lo = mid + 1;
                res = vals.get(mid).getValue();
            } else {
                hi = mid - 1;
            }
        }

        return res;
    }

    class Pair<K, V> {
        private final K key;
        private final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
