package simple;

import java.util.HashMap;
import java.util.Map;


//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//
//        有效字符串需满足：
//
//        左括号必须用相同类型的右括号闭合。
//        左括号必须以正确的顺序闭合。
//        注意空字符串可被认为是有效字符串。
//地址：https://leetcode-cn.com/problems/valid-parentheses/
//参考了官方解答思路与《数据结构与算法分析-Java语言描述》第59页

public class BracketIsValid {

    private Map<Character, Character> dic = null;

    public BracketIsValid(){
        dic = new HashMap<Character, Character>();
        dic.put(')', '(');
        dic.put(']', '[');
        dic.put('}', '{');
    }

    public static void main(String[] args){

        BracketIsValid test = new BracketIsValid();
        System.out.println(test.isValid("["));
    }

    public boolean isValid(String s){

        boolean isValid = true;

        BracketStack stack = new BracketStack(s.length());

        for (int i = 0; i < s.length(); i++) {

            if (dic.containsKey(s.charAt(i))){

                char topElement = stack.isEmpty() ? '#': stack.getTop();

                if (topElement == dic.get(s.charAt(i)))
                    stack.pop();
                else {
                    isValid = false;
                    break;
                }
            } else
                stack.push(s.charAt(i));

        }

        if (!stack.isEmpty())
            isValid = false;

        return isValid;
    }

    class BracketStack {

        private char stack[] = null;
        private int top;


        public BracketStack(int length){
            stack = new char[length];
            top = -1;
        }

        public boolean isEmpty(){
            if ( top == -1)
                return true;
            else
                return false;
        }

        public void push(char c){
            ++top;
            stack[top] = c;
        }

        public void pop(){
            --top;
        }

        public char getTop(){
            return stack[top];
        }

    }
}
