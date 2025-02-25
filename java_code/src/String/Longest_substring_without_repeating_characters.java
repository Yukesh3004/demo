package String;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class Longest_substring_without_repeating_characters { //leetcode no:3

    public static int lengthOfLongestsubstring(String s){
        //2 pointer and sliding window algorithm
        HashMap<Character, Integer> hp = new HashMap<>();
        int left = 0;
        int right = 0;
        int max_len = 0;
        int s_len = s.length();

        while(right < s_len){
            if(hp.containsKey((s.charAt(right)))){
                if(hp.get(s.charAt(right)) >= left){
                    left = hp.get(s.charAt(right)) + 1;
                    hp.replace(s.charAt(right), right);
                    int len = right-left+1;
                    max_len = Math.max(max_len, len);
                    right++;
                }else{
                    hp.put(s.charAt(right), right);
                    int len = right-left+1;
                    max_len = Math.max(max_len, len);
                    right++;
                }
            }else{
                hp.put(s.charAt(right), right);
                int len = right-left+1;
                max_len = Math.max(max_len, len);
                right++;
            }
        }

        return max_len;
    }

}
