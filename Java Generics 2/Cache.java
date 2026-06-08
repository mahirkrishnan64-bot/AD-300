// Cache.java
import java.util.HashMap;
import java.util.Map;

public class Cache<T> {
    private Map<String, T> storage = new HashMap<>();

    public void add(String key, T item) {
        storage.put(key, item);
    }

    public T get(String key) {
        return storage.get(key);
    }

    public void clear() {
        storage.clear();
    }

    public int size() {
        return storage.size();
    }

    public void addAll(Cache<? extends T> other) {
        for (Map.Entry<String, ? extends T> entry : other.storage.entrySet()) {
            storage.put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public String toString() {
        return storage.toString();
    }
}