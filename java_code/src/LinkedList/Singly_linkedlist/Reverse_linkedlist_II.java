package LinkedList.Singly_linkedlist;

public class Reverse_linkedlist_II { //leetcode no:92

    public static Singly_linkedlist.Node reverseBetween(Singly_linkedlist.Node head, int left, int right) {
        //brute force
//        if(right == left) return head;
//
//        Singly_linkedlist.Node l = null;
//        Singly_linkedlist.Node lp = null;
//        Singly_linkedlist.Node r = null;
//        Singly_linkedlist.Node ra = null;
//        int temp = left;
//        while(temp > 0){
//            if(l == null) l = head;
//            else{
//                lp = l;
//                l = l.next;            }
//
//            temp -= 1;
//        }
//
//        temp = right;
//        while(temp > 0){
//            if(r == null){
//                r = head;
//                ra = r.next;
//            }else{
//                r = r.next;
//                if(r.next != null) ra = r.next;
//            }
//
//            temp -= 1;
//        }
//
//        l = reverseList(l, left, right);
//
//        if(head == l && ra == r) return r;
//        else if(head == l && ra != r){
//            head = r;
//            l.next = ra;
//            return head;
//        }else if(head != l && ra == r){
//            lp.next = r;
//            return head;
//        }
//        lp.next = r;
//        l.next = ra;
//
//        return head;

        //improvised
        if(left == right) return head;

        //skip the first left-1 nodes
        Singly_linkedlist.Node current = head;
        Singly_linkedlist.Node prev = null;
        for (int i = 0; current != null && i < left-1; i++) {
            prev = current;
            current = current.next;
        }

        Singly_linkedlist.Node last = prev;
        Singly_linkedlist.Node newEnd = current;

        //Reverse between left & right
        Singly_linkedlist.Node next = current.next;
        for (int i = 0; current != null && i < right-left+1 ; i++) {
            current.next = prev;
            prev = current;
            current = next;
            if(next != null) next = next.next;
        }

        if(last != null) last.next = prev;
        else head = prev;

        newEnd.next = current;
        return head;
    }

    public static Singly_linkedlist.Node reverseList(Singly_linkedlist.Node l, int left, int right){
        Singly_linkedlist.Node back = null;
        Singly_linkedlist.Node current = l;
        int moves = right - left;

        while (moves >= 0) {
            Singly_linkedlist.Node front = current.next;
            current.next = back;
            back = current;
            current = front;

            moves -= 1;
        }

        return l;
    }

    public static void main(String[] args) {

        Singly_linkedlist sl = new Singly_linkedlist();
        sl.insertAtFirst(5);
        sl.insertAtFirst(4);
        sl.insertAtFirst(3);
        sl.insertAtFirst(2);
        sl.insertAtFirst(1);
        sl.display(sl.head);

        Singly_linkedlist.Node reverseBetween = reverseBetween(sl.head, 4, 5);
        sl.display(reverseBetween);

    }

}
