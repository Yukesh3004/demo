package LinkedList.Singly_linkedlist;

public class Reorder_list { //leetcode no:143

    public static Singly_linkedlist.Node reorderList(Singly_linkedlist.Node head){
        if(head == null || head.next == null) return head;

        //find the mid node
        Singly_linkedlist.Node mid = findMid(head);

        //reverse the list that starts from mid
        Singly_linkedlist.Node reversedList = reverseList(mid);

        //re-order list
        Singly_linkedlist.Node temp = head;
        Singly_linkedlist.Node t1 = null;
        Singly_linkedlist.Node t2 = null;

        while(temp != null){
            t1 = temp;
            temp = temp.next;
            t1.next = reversedList;

            t2 = reversedList;
            reversedList = reversedList.next;
            if(temp != null) t2.next = temp;
        }

        if(reversedList != null) t2.next = reversedList;

        return head;
    }

    public static Singly_linkedlist.Node findMid(Singly_linkedlist.Node head){
        Singly_linkedlist.Node slow = head;
        Singly_linkedlist.Node fast = head;
        Singly_linkedlist.Node prev = null;

        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;
        return slow;
    }

    public static Singly_linkedlist.Node reverseList(Singly_linkedlist.Node head){
        if(head == null || head.next == null){
            return head;
        }
        Singly_linkedlist.Node newHead = reverseList(head.next);
        Singly_linkedlist.Node front = head.next;
        front.next = head;
        head.next = null;

        return newHead;
    }

    public static void main(String[] args) {

        Singly_linkedlist sl = new Singly_linkedlist();
        sl.insertAtFirst(1);
        sl.insertAtFirst(2);
        sl.insertAtFirst(3);
        sl.insertAtFirst(2);
        sl.insertAtFirst(1);
        sl.display(sl.head);

        Singly_linkedlist.Node reorderList = reorderList(sl.head);
        sl.display(reorderList);

    }

}
