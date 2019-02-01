package simple;

import java.util.HashMap;
import java.util.Map;

//罗马数字转整数
//地址：https://leetcode-cn.com/problems/roman-to-integer/
public class RomanToInt {

    public Map<Character, Integer> romanDic = new HashMap<Character, Integer>();

    public RomanToInt(){
        romanDic.put('I', 1);
        romanDic.put('V', 5);
        romanDic.put('X', 10);
        romanDic.put('L', 50);
        romanDic.put('C', 100);
        romanDic.put('D', 500);
        romanDic.put('M', 1000);
    }

    public static void main(String[] args){
        RomanToInt test = new RomanToInt();
        System.out.println(test.romanToInt("LVIII"));
    }


    //思路：1. 将罗马数字字符串反转，然后比较。
    //2. 将字符串中第一个数字赋给“结果”
    //3. 从字符串中第一个字符开始，若当前字符对应的值小于等于下一个字符的值，则用 “结果”加上下一个字符的值，并赋给“结果”；否则用结果减去下一个字符的值，并赋给结果
    //例：VIII，反转后是IIIV，即 1 1 1 5，结果等于 1+1+1+5
    //例：MCMXCIV, 反转后是VICXMCM，即 5 1 100 10 1000 100 1000，结果等于 5-1+100-10+1000-100+1000
    public int romanToInt(String s) {

        StringBuffer sb = new StringBuffer(s).reverse();

        int result = romanDic.get(sb.charAt(0));

        for (int pointer = 0; pointer < sb.length()-1; pointer++){

            if (romanDic.get(sb.charAt(pointer)) <= romanDic.get(sb.charAt(pointer+1)))
                result = result + romanDic.get(sb.charAt(pointer+1));
            else
                result = result - romanDic.get(sb.charAt(pointer+1));

        }

        return result;
    }
}
