package LinkedList.Singly_linkedlist;

import java.util.HashMap;
import java.util.Stack;

public class Intersection_of_two_linkedLists{ //leetcode no:160

    public Singly_linkedlist.Node getIntersectionNode(Singly_linkedlist.Node headA, Singly_linkedlist.Node headB){
        //brute force
//        HashMap<Singly_linkedlist.Node, Integer> hm = new HashMap<>();
//        Singly_linkedlist.Node temp = headA;
//
//        while(temp != null){
//            hm.put(temp, 1);
//            temp = temp.next;
//        }
//
//        temp = headB;
//        while(temp != null){
//            if(hm.containsKey(temp)) return temp;
//            temp = temp.next;
//        }
//
//        return null;

        //improvised
        Singly_linkedlist.Node t1 = headA;
        Singly_linkedlist.Node t2 = headB;
        int n1 = 0;
        int n2 = 0;

        //find the length of headA
        while(t1 != null){
            t1 = t1.next;
            n1+=1;
        }

        //find the length of headB
        while(t2 != null){
            t2 = t2.next;
            n2+=1;
        }

        if(n1 == n2){
            t1 = headA;
            t2 = headB;
            while(t1 != null && t2 != null){
                if(t1 == t2) return t1;
                t1 = t1.next;
                t2 = t2.next;
            }
        }else if(n1 > n2){
            t1 = headA;
            t2 = headB;
            int d = n1-n2;
            while(d != 0){
                t1 = t1.next;
                d -= 1;
            }
            while(t1 != null && t2 != null){
                if(t1 == t2) return t1;
                t1 = t1.next;
                t2 = t2.next;
            }
        }else if(n2 > n1){
            t1 = headA;
            t2 = headB;
            int d = n2-n1;
            while(d != 0){
                t2 = t2.next;
                d -= 1;
            }
            while(t1 != null && t2 != null){
                if(t1 == t2) return t1;
                t1 = t1.next;
                t2 = t2.next;
            }
        }

        return null;
    }

}
