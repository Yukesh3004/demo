package String;

public class Longest_palindromic_substring { //leetcode problem no:5

    public static String longestPalindrome(String s){
        int len = s.length();
        String lps = s.substring(0,1);
        int l=0;
        int r=0;

        for(int i=1; i<len; i++){
            //consider odd length
            l=i;
            r=i;

            while(s.charAt(l)==s.charAt(r)){
                l--;
                r++;
                if(l==-1 || r==len){
                    break;
                }
            }

            String palindrome = s.substring(l+1, r);
            if(palindrome.length() > lps.length()){
                lps = palindrome;
            }

            //consider even length
            l=i-1;
            r=i;

            while(s.charAt(l)==s.charAt(r)){
                l--;
                r++;
                if(l==-1 || r==len){
                    break;
                }
            }

            palindrome = s.substring(l+1, r);
            if(palindrome.length() > lps.length()){
                lps = palindrome;
            }
        }

        return lps;
    }

}
