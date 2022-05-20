package Structure;

import java.util.*;

public class MyArrayList<AnyType> implements Iterable<AnyType>{//实现了Iterable接口，就必须实现他定义的方法,Iterable接口中只有
    private static final int DEFAULT_CAPACITY=10;
    private int theSize;
    private AnyType[] theItem;

    public MyArrayList(){
        doClear();
    }
    public void clear(){
        doClear();
    }
    public int size(){
        return theSize;
    }
    public boolean isEmpty(){
        return theSize==0;
    }
    public void doClear(){
        theSize=0;
        ensureCapacity(DEFAULT_CAPACITY);
    }
    public void ensureCapacity(int newCapacity){
        if (newCapacity<theSize){
            return;
        }
        AnyType[] old=theItem;
        theItem= (AnyType[]) new Object[newCapacity];  //注释：数组不可以用泛型表示，需要通过类型的强制转换
        for (int i = 0; i < theSize; i++) {
            theItem[i]=old[i];
        }
    }
    public void add(int idx,AnyType x){
        if (theItem.length==theSize){
            ensureCapacity(size()*2+1);
        }
        for (int i = theSize; i > idx; i--) {
            theItem[i]=theItem[i-1];
        }
        theItem[idx]=x;
        theSize++;
    }
    public void add(AnyType a){
        add(size(),a);
    }
    public AnyType remove(int idx){
        AnyType type = theItem[idx];
        for (int i = idx; i < theSize-1; i++) {
            theItem[i]=theItem[i+1];
        }
        theSize--;
        return type;
    }
    @Override
    public Iterator<AnyType> iterator() {
        return new ArrayListIterable();
    }
    private class ArrayListIterable implements Iterator<AnyType> {
        public int current=0;

        @Override
        public boolean hasNext() {
            return current<theSize;
        }
        @Override
        public AnyType next() {
            if (!hasNext())
                throw new NoSuchElementException();
            return theItem[current++];
        }
    }
    @Override
    public String toString() {
        return Arrays.toString(theItem);
    }
}