package String;

import java.util.regex.Pattern;

public class Valid_palindrome { //leetcode problem no:125

    public static boolean isPalindrome(String s){
//        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
//        String newString = "";
//        int len = s.length();
//        int reverse_len = len-1;
//
//        if(len == 0 || len == 1) return true;
//
//        for(int i=0; i<len; i++){
//            if(s.charAt(i) != s.charAt(reverse_len)) return false;
//            reverse_len -= 1;
//        }
//
//        return true;

        //Efficent way
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        int len = s.length();
        int start = 0;
        int end = len-1;

        if(len == 0 || len == 1) return true;

        while(start < end){
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }

        return true;
    }

}
