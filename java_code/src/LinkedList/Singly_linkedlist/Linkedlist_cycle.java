package LinkedList.Singly_linkedlist;

import java.util.HashMap;

public class Linkedlist_cycle { //leetcode no:141

    public static boolean hasCycle(Singly_linkedlist.Node head){
        //brute force
//        HashMap<Singly_linkedlist.Node, Integer> hashMap = new HashMap<Singly_linkedlist.Node, Integer>();
//        Singly_linkedlist.Node temp = head;
//
//        while(temp != null){
//            if(hashMap.containsKey(temp)) return true;
//            else hashMap.put(temp, 1);
//
//            temp = temp.next;
//        }
//
//        return false;

        //improvised
        Singly_linkedlist.Node slow = head;
        Singly_linkedlist.Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Singly_linkedlist sl = new Singly_linkedlist();
        Singly_linkedlist.Node node = sl.new Node(2);

        sl.insertAtFirst(10);
        sl.insertAtFirst(20);
        sl.insertAtFirst(30);
        sl.insertAtFirst(40);
//        sl.makeCycleList(50, sl.head);
//        sl.displayCycleList(sl.head);

        System.out.println(hasCycle(sl.head));
    }

}
