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

    public static int hasCycleLength(Singly_linkedlist.Node head){
        Singly_linkedlist.Node slow = head;
        Singly_linkedlist.Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                int size = 1;
                fast = fast.next;
                while(slow != fast){
                    size += 1;
                    fast = fast.next;
                }
                return size;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Singly_linkedlist sl = new Singly_linkedlist();
//        Singly_linkedlist.Node node = sl.new Node(2);

        sl.insertAtFirst(10);
        sl.insertAtFirst(20);
        sl.insertAtFirst(30);
        sl.insertAtFirst(40);
//        sl.makeCycleList(50, sl.head);
//        sl.insertAtFirst(100);
//        sl.insertAtFirst(110);
//        sl.displayCycleList(sl.head);

        System.out.println(hasCycle(sl.head));

        int size = hasCycleLength(sl.head);
        System.out.println("length of the cycle list = " + size);
    }

}
