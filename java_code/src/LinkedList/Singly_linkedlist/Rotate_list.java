package LinkedList.Singly_linkedlist;

public class Rotate_list { //leetcode no:61

    public static Singly_linkedlist.Node rotateRight(Singly_linkedlist.Node head, int k){
        if(head == null || head.next == null || k <= 0) return head;

        int size = 1;
        Singly_linkedlist.Node tail = head;
        while(tail.next != null){
            tail = tail.next;
            size++;
        }

        if(size == k) return head;

        tail.next = head;
        int rotations = k % size;
        int traverse = size - rotations;
        Singly_linkedlist.Node newLast = head;
        while(traverse > 1){
            newLast = newLast.next;
            traverse -= 1;
        }

        head = newLast.next;
        newLast.next = null;

        return head;
    }

    public static void main(String[] args) {

        Singly_linkedlist sl = new Singly_linkedlist();
//        sl.insertAtFirst(9);
//        sl.insertAtFirst(8);
//        sl.insertAtFirst(7);
//        sl.insertAtFirst(6);
        sl.insertAtFirst(5);
        sl.insertAtFirst(4);
        sl.insertAtFirst(3);
        sl.insertAtFirst(2);
        sl.insertAtFirst(1);
        sl.display(sl.head);

        Singly_linkedlist.Node rotatedList = rotateRight(sl.head, 2);
        sl.display(rotatedList);

    }

}
