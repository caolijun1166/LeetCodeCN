package simple;
//整数反转
//地址：https://leetcode-cn.com/problems/reverse-integer/

//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
//
//        示例 1:
//
//        输入: 123
//        输出: 321
//        示例 2:
//
//        输入: -123
//        输出: -321
//        示例 3:
//
//        输入: 120
//        输出: 21
public class ReverseInteger {
    public static void main(String[] args){
        ReverseInteger ri = new ReverseInteger();
        System.out.println(ri.reverse(127890009));
        System.out.println(ri.reverse(-123));
        System.out.println(ri.reverse(123));
    }

    //参考CSDN某博主的实现，当时没有记录是谁的。日后需自己重新实现。
    public int reverse(int x) {
        long reversed = 0;
        int length = 0;

        if (x>=0)
            length = (x+"").length();
        else
            length = (x+"").length()-1;

        while(x!=0){
            for (int i=0;i<length;i++){
                int a = x%10;//当前数的最后一位
                x = (x-a)/10;//去除最后一位数后的新数字
                reversed = reversed+(int)(a*Math.pow(10,length-i-1));
            }
        }

        if (reversed > Math.pow(2,31)-1 || reversed < (-1)*(Math.pow(2,31)))
            return 0;

        return (int)reversed;
    }
}
