package LeetCode;

import org.junit.Test;
/*
/* 数字范围    数量  位数    占多少位
    1-9        9      1       9
    10-99      90     2       180
    100-999    900    3       2700
    1000-9999  9000   4       36000  ...
 */
public class lc44 {
    public int findNthDigit(int n) {
        long start=1;//当前范围内数字的起始大小
        int digit=1;//数字位数
        long count=9;//当前范围内数字数量
        while(n>count){
            n-=count;//减去上一层数字
            digit++;
            start*=10;
            count=digit*start*9;
        }
        long num = start + (n - 1) / digit;//必须要减1，数学规律
        return Long.toString(num).charAt((n-1)%digit)-'0';
    }
    @Test
    public void test(){
        System.out.println(findNthDigit(11));

    }
}
