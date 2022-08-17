package Structure;

import java.util.*;

public class myHashMap<K,V> implements Map<K,V> {
    public static class Node<K, V> {
        final K key;
        V value;
        Node<K, V> next;
        int hash;

        public Node(K key, V value, Node<K, V> next, int hash) {
            this.key = key;
            this.value = value;
            this.next = next;
            this.hash = hash;
        }
    }
    private int DEFAULT_INITIAL_CAPACITY=16;

    private float DEFAULT_LOAD_FACTOR= (float) 0.75;
    int size=0;
    int modCount=0;
    transient myHashMap.Node<K,V>[] table;

    public int hash(K key){
        return key==null?0:key.hashCode()%DEFAULT_INITIAL_CAPACITY;
    }
    public myHashMap(int Capacity,float LoadFactor){
        if (Capacity<0){
            throw new IllegalArgumentException("容量不可小于零");
        }
        if (LoadFactor<=0){
            throw new IllegalArgumentException("负载因子需要大于零");
        }
        this.DEFAULT_INITIAL_CAPACITY=Capacity;
        this.DEFAULT_LOAD_FACTOR=LoadFactor;
    }

    public myHashMap() {
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean containsKey(Object o) {
        int hash = hash((K) o);
        if (table[hash]==null){
            return false;
        }
        if (table[hash].key.equals((K)o)) return true;
        Node node=table[hash];
        while(node.next!=null){
            if (node.next.key.equals((K)o)) return true;
            node=node.next;
        }
        return false;
    }

    @Override
    public boolean containsValue(Object o) {
        for (Node<K, V> node : table) {
            if (node.value.equals((V)o)) return true;
            Node n=node;
            while(n.next!=null){
                if (n.next.value.equals((V)o)){
                    return true;
                }
                n=n.next;
            }
        }
        return false;
    }

    @Override
    public V get(Object o) {
        for (Node<K, V> node : table) {
            if (node.key.equals((K)o)){
                return node.value;
            }
        }
        return null;
    }

    @Override
    public  Object put(Object o, Object o2) {
        if (size==0) table=new Node[DEFAULT_INITIAL_CAPACITY];
        else if (size>=DEFAULT_INITIAL_CAPACITY*DEFAULT_LOAD_FACTOR){
            DEFAULT_INITIAL_CAPACITY*=2;
            table=new Node[DEFAULT_INITIAL_CAPACITY];
        }
        int hash = hash((K) o);
        if (table[hash]==null){
            table[hash]=new Node<K,V>((K)o,(V)o2,null,hash((K)o));
            size++;
            return table[hash];
        }else if (!table[hash].key.equals((K)o)){
            table[hash].next=new Node<K,V>((K)o,(V)o2,null,hash((K)o));
            size++;
            return table[hash].next;
        }
        modCount++;
        return null;
    }

    @Override
    public V remove(Object o) {
        int hash = hash((K) o);
         V value=table[hash].value;
        table[hash]=null;
        modCount++;
        return value;
    }

    @Override
    public void putAll(Map map) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set keySet() {
        Set<K> set=new HashSet<>();
        for (Node<K, V> node : table) {
            set.add(node.key);
        }
        return set;
    }

    @Override
    public Collection values() {
        List<V> list=new ArrayList<>();
        for (Node<K, V> node : table) {
            if (node!=null){
                list.add(node.value);
            }
        }
        return list;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }

    public static void main(String[] args) {
        myHashMap<Integer,String> map=new myHashMap<>();
        map.put(1,"lhl");
        map.put(2,"zzy");
        System.out.println(map.values());
        System.out.println(map.containsKey(3));
    }
}