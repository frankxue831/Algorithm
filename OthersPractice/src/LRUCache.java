import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    public LRUCache(int capacity){
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key){
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value){
        super.put(key, value);
    }

    public boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest){
        return size() > capacity;
    }


    public static void main(String[] args){
        LRUCache cache1 = new LRUCache(3);
        cache1.put(1,1);
        cache1.put(2,1);
        cache1.put(3,10);
        System.out.println(cache1.toString());
        cache1.put(4,20);
        System.out.println(cache1.toString());


    }
}
