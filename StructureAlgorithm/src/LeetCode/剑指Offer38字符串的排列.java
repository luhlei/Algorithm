package LeetCode;

import java.util.HashSet;

public class 剑指Offer38字符串的排列 {
    HashSet<String> res=new HashSet<>();

    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        boolean[] visited=new boolean[s.length()];
        StringBuffer sb=new StringBuffer();
        help(chars,sb,visited);
        return (String[]) res.toArray();
    }
    public void help(char[] chars,StringBuffer sb,boolean[] visited){
        if (sb.length()==chars.length){
            String s = sb.toString();
            res.add(s);
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (visited[i]){
                continue;
            }
            sb.append(chars[i]);
            visited[i]=true;
            help(chars,sb,visited);
            sb.deleteCharAt(sb.length()-1);
            visited[i]=false;
        }
    }
}