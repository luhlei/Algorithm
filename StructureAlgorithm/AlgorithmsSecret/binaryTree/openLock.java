package AlgorithmsSecret.binaryTree;

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class openLock {
    public int BFS(String target){
        Queue<String> queue=new LinkedList<>();
        Set<String> visited=new HashSet<>();
        queue.offer("0000");
        visited.add("0000");
        int step=0;
        while(!queue.isEmpty()){
            int sz=queue.size();
            for (int i = 0; i < sz; i++) {
                String s = queue.poll();
                //如果有死亡代码，则在这里添加；
                if (s.equals(target)){
                    return step;
                }
                for (int j = 0; j < 4; j++) {
                    queue.add(plusOne(s,j));
                    visited.add(plusOne(s,j));
                    queue.add(minOne(s,j));
                    visited.add(minOne(s,j));
                }
            }
            step++;
        }
        return -1;
    }
    public String plusOne(String s,int i){
        char[] chars = s.toCharArray();
        if (chars[i]=='9'){
            chars[i]='0';
        }
        else {
            chars[i]++;
        }
        return new String(chars);
    }
    public String minOne(String s,int i){
        char[] chars = s.toCharArray();
        if (chars[i]=='0'){
            chars[i]='9';
        }
        else {
            chars[i]--;
        }
        return new String(chars);
    }
    @Test
    public void test(){
        System.out.println(BFS("0088"));
    }
}
