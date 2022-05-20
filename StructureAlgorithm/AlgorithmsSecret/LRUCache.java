package AlgorithmsSecret;

import java.util.LinkedHashMap;
import java.util.LinkedList;

public class LRUCache {
    int cap;
    LinkedHashMap<Integer, LinkedList<Integer>> cache;

    public LRUCache(int cap) {
        this.cap = cap;
        cache=new LinkedHashMap<>(cap);
    }
    public int get(int key){
        if (!cache.containsKey(key)){
            return -1;
        }
        makeRecently(key);
        return cache.get(key).get(key);
    }
    public void makeRecently(int key){
        LinkedList<Integer> node = cache.get(key);
        cache.remove(node);
        cache.put(key,node);
    }
    public void put(int key,int val){
        if (cache.containsKey(key)){
            cache.get(key).set(key,val);
            return;
        }
        if (cache.size()>=cap){
            Integer oldest = cache.keySet().iterator().next();
            cache.remove(oldest);
        }
        cache.put(key, (LinkedList<Integer>) new LinkedList<>().set(key,val));
    }
}
