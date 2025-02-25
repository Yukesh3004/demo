package String;

import java.util.Stack;

public class Valid_parentheses { //leetcode problem no:20

    public static boolean isValid(String s){
        Stack<Character> st = new Stack<>();
        int s_len = s.length();

        for(int i=0; i<s_len; i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{'){
                st.push(s.charAt(i));
            }else{
                if(st.isEmpty()) return false;
                char ch = st.peek();
                st.pop();
                if((s.charAt(i)==')' && ch=='(') || (s.charAt(i)==']' && ch=='[') || (s.charAt(i)=='}' && ch=='{')){

                }else{
                    return false;
                }
            }
        }

        return st.isEmpty();
    }


}
