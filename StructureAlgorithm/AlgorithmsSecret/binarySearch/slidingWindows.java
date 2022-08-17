package AlgorithmsSecret.binarySearch;

import java.util.HashMap;

public class slidingWindows {
    public static String search(String s,String t){
        HashMap<Character,Integer> need=new HashMap<>();
        HashMap<Character,Integer> window=new HashMap<>();
        char[] chars = t.toCharArray();
        for (int i = 0; i < chars.length; i++) {
             need.put(chars[i],need.getOrDefault(chars[i],0)+1);
        }
        int valid=0;
        int left=0,right=0;
        int len=Integer.MAX_VALUE;
        int start=0;
        while(right<s.length()){
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)){

                window.put(c,window.getOrDefault(c,0)+1);
                if (need.get(c).equals(window.get(c))) valid++;
            }
            while(need.size()==valid){
                //主要是这里修改
                if (right-left<len){
                    start=left;
                    len=right-left;
                }
                char c1 = s.charAt(left);
                left++;
                if (need.containsKey(c1)){
                    if (need.get(c1)==window.get(c1)) valid--;
                    window.put(c1,window.getOrDefault(c1,0)-1);
                }
            }
        }
        return s.substring(start,start+len);
    }

    public static void main(String[] args) {
        String s="ADBECFEBANC";
        String t="ABC";
        System.out.println(search(s, t));
    }
}
