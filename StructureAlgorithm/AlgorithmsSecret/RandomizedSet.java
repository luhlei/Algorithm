package AlgorithmsSecret;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * 用HashMap辅助数组实现，增删改查的时间复杂度为O(1);
 * HashMap记录val对应index
 */
public class RandomizedSet {
    ArrayList<Integer> nums=new ArrayList<>();
    HashMap<Integer,Integer> valToIndex=new HashMap<>();
    public boolean insert(int val){
        if (valToIndex.containsKey(val)){
            return false;
        }
        valToIndex.put(val,nums.size());
        nums.add(val);
        return true;
    }
    public boolean remove(int val){
        if (!valToIndex.containsKey(val)) return false;
        Integer index = valToIndex.get(val);
        valToIndex.put(nums.get(nums.size()-1),index);//将HashMap的Key对应的val改变
        valToIndex.remove(val);
        Collections.swap(nums,index,nums.size()-1);
        nums.remove(nums.size()-1);
        return true;
    }
    public int getRandom(){
        return nums.get(getRandom()%nums.size());
    }
}
