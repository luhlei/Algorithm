package offer;

/**
 * 将一个字符串中的空格替换成"%20"
 */
public class ReplaceBlank {
    /**
     * 解法一：使用StringBuffer，将String内的字符复制到StringBuffer的缓冲区内
     */
    public static String replaceBlank(String input){
        if (input==null)
            return null;
        StringBuffer output = new StringBuffer();
        for (int i = 0; i <input.length() ; i++) {
            if (input.charAt(i)==' '){
                output.append("%20");
            }
            output.append(input.charAt(i));
        }
        return new String(output);
    }
}
