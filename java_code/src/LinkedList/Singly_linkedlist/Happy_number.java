package LinkedList.Singly_linkedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Happy_number { //leetcode no:02

    public static boolean isHappy(int n) {
        //brute force
//        List<Integer> li = new ArrayList<>();
//        int divider = 10;
//        int sum = 0;
//        Stack<Integer> s = new Stack<>();
//
//        do{
//            li.clear();
//            while(n != 0){
//                int reminder = n%divider;
//                li.add(reminder);
//                n = n/divider;
//            }
//
//            sum = 0;
//            for(int i : li){
//                sum = sum + (i*i);
//            }
//
//            if(s.contains(sum)) return false;
//            else{
//                s.push(sum);
//                n = sum;
//            }
//        }while(sum != 1);
//
//        if(sum == 1) return true;
//        return false;

        //improvised
        int slow = n;
        int fast = n;

        do{
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast));
        }while(slow != fast);

        if(slow == 1) return true;
        return false;
    }

    public static int findSquare(int number){
        int ans = 0;
        while(number > 0){
            int rem = number%10;
            ans += rem*rem;
            number /= 10;
        }

        return ans;
    }

    public static void main(String[] args) {
        boolean bool = isHappy(19);
        System.out.println(bool);
    }

}
