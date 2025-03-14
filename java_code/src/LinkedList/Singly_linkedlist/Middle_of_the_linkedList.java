package LinkedList.Singly_linkedlist;

public class Middle_of_the_linkedList { //leetcode no:876

    public static Singly_linkedlist.Node middleNode(Singly_linkedlist.Node head){
        //brute force
//        int size = 0;
//        Singly_linkedlist.Node temp = head;
//
//        while(temp != null){
//            temp = temp.next;
//            size+=1;
//        }
//
//        int mid = size/2 +1;
//        temp = head;
//        while(mid>1){
//            temp = temp.next;
//            mid-=1;
//        }
//
//        return temp;

        //improvised
        Singly_linkedlist.Node slow = head;
        Singly_linkedlist.Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        Singly_linkedlist sl = new Singly_linkedlist();
        sl.insertAtFirst(10);
        sl.insertAtFirst(20);
        sl.insertAtFirst(30);
        sl.insertAtFirst(40);
        sl.insertAtFirst(50);
        sl.display(sl.head);

        Singly_linkedlist.Node middleNode = middleNode(sl.head);
        sl.display(middleNode);
    }

}
