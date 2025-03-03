package String;

public class Reverse_words_in_a_string { //leetcode problem no:151

    public static String reverseWords(String s){
//        int len = s.length();
//        String[] strArr = new String[len];
//        String str = "";
//        int count = 0;
//
//        for(int i=0; i<len; i++){
//            if(s.charAt(i) != ' '){
//                str += s.charAt(i);
//            }else{
//                strArr[count] = str;
//                str = "";
//                count++;
//            }
//        }
//        strArr[count] = str;
//        str = "";
//        count++;
//
//        String newStr = "";
//        for(int i=strArr.length-1; i>=0; i--){
//            if(strArr[i] != null && strArr[i] != ""){
//                newStr += strArr[i] + " ";
//            }
//        }
//
//        return newStr.trim();

        //Efficient way
        String[] arr = s.split(" +"); //it will remove white spaces (atleast one)
        StringBuilder sb = new StringBuilder();

        for(int i=arr.length-1; i>=0; i--){
            sb.append(arr[i]);
            sb.append(" ");
        }

        return sb.toString().trim();

    }

}
