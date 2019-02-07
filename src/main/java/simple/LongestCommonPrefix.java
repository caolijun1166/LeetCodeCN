package simple;

// 最长公共前缀
// 编写一个函数来查找字符串数组中的最长公共前缀。
//
//        如果不存在公共前缀，返回空字符串 ""。
//
//        示例 1:
//
//        输入: ["flower","flow","flight"]
//        输出: "fl"
//        示例 2:
//
//        输入: ["dog","racecar","car"]
//        输出: ""
//        解释: 输入不存在公共前缀。
// 地址：https://leetcode-cn.com/problems/longest-common-prefix/

public class LongestCommonPrefix {
    public static void main(String[] args){
        LongestCommonPrefix lgPrefix = new LongestCommonPrefix();
        String[] strs = new String[]{"flower", "flower", "dlowerasdight"};
        System.out.println(lgPrefix.longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs){

        StringBuffer prefix = new StringBuffer();

        //当输入数组位空时，直接返回空字符串
        if ( strs.length == 0 || strs == null)
            return prefix.append("").toString();

        int strsLength = strs.length;
        int smallestStrLength = strs[0].length();
        char temp = 0;
        boolean sameChar = true;

        //找到数组中最短字符串
        for (int i = 0; i < strsLength; i++){
            if ( smallestStrLength > strs[i].length() )
                smallestStrLength = strs[i].length();
        }

        //外层循环控制字符串中的字符位置
        for (int i = 0; i < smallestStrLength; i++) {
            //内层循环控制字符串数组中的字符串位置
            for (int n = 0; n < strsLength; n++){
                //取第一个字符串的i个字符放入temp中，用作给后面每一个字符串做判断
                temp = strs[0].charAt(i);
                //如果字符串数组中第一个字符就不相同，则返回 "";
                if ( (temp != strs[n].charAt(i)) && (i == 0) ){
                    prefix.append("");
                    //将标志位设置false
                    sameChar = false;
                    break;
                } else if ( (temp != strs[n].charAt(i)) ) {
                    //将标志位设置false
                    sameChar = false;
                    break;
                }
            }

            //当遇到不相同的字符时，终止循环
            if (sameChar != true)
                break;

            prefix.append(temp);
        }

        return prefix.toString();
    }
}
