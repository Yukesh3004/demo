package LinkedList.Singly_linkedlist;

public class Remove_Nth_node_from_end_of_list { //leetcode no:19

    public static Singly_linkedlist.Node removeNthfromEnd(Singly_linkedlist.Node head, int n){
        //brute force
//        if(head.next == null){
//            head = null;
//            return head;
//        }
//
//        int size = 1;
//        Singly_linkedlist.Node temp = head;
//        while(temp.next != null){
//            temp = temp.next;
//            size+=1;
//        }
//
//        int travel = size-n-1;
//        temp = head;
//        while(travel > 0){
//            temp = temp.next;
//            travel-=1;
//        }
//
//        if(travel<0) head = temp.next;
//        else if(temp.next.next != null) temp.next = temp.next.next;
//        else temp.next = null;
//
//        return head;

        //improvised
        if(head.next == null) return head = null;

        Singly_linkedlist.Node fast = head;
        for(int i=0; i<n; i++) fast = fast.next;

        if(fast == null) return head.next;

        Singly_linkedlist.Node slow = head;
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return head;
    }

    public static void main(String[] args) {
        Singly_linkedlist sl = new Singly_linkedlist();
//        sl.insertAtFirst(5);
//        sl.insertAtFirst(2);
        sl.insertAtFirst(1);
        sl.display(sl.head);

        Singly_linkedlist.Node removedList = removeNthfromEnd(sl.head, 2);
        sl.display(removedList);
    }

}
