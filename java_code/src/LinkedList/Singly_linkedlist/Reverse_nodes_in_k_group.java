package LinkedList.Singly_linkedlist;

public class Reverse_nodes_in_k_group { //leetcode no:25

    public static Singly_linkedlist.Node reverseKGroup(Singly_linkedlist.Node head, int k) {
//        if (head == null || k <= 1) return head;
//
//        Singly_linkedlist sl = new Singly_linkedlist();
//        Singly_linkedlist.Node dummy = sl.new Node(0);
//        dummy.next = head;
//        Singly_linkedlist.Node prevGroupEnd = dummy;
//        Singly_linkedlist.Node current = head;
//
//        while (current != null) {
//            // Check if there are at least k nodes left
//            Singly_linkedlist.Node temp = current;
//            int count = 0;
//            while (temp != null && count < k) {
//                temp = temp.next;
//                count++;
//            }
//            if (count < k) break; // Not enough nodes to reverse
//
//            // Reverse k nodes
//            Singly_linkedlist.Node prev = null;
//            Singly_linkedlist.Node groupStart = current;
//            for (int i = 0; i < k; i++) {
//                Singly_linkedlist.Node next = current.next;
//                current.next = prev;
//                prev = current;
//                current = next;
//            }
//
//            // Connect reversed part with previous part
//            prevGroupEnd.next = prev;
//            groupStart.next = current;
//            prevGroupEnd = groupStart;
//        }
//
//        return dummy.next;


        //in this method it will reverse k node but in alternate
        if(head == null || k <= 1) return head;

        Singly_linkedlist sl = new Singly_linkedlist();
        Singly_linkedlist.Node dummy = sl.new Node(0, null);

        Singly_linkedlist.Node prevGroupEnd = dummy;
        Singly_linkedlist.Node current = head;

        int skip = 1;

        while(current != null){
            if(skip%2 == 0) {
                //check if the nodes are enough to skip
                Singly_linkedlist.Node temp = current;
                int count = 0;
                while(temp != null && count <k){
                    temp = temp.next;
                    count += 1;
                }

                if(count < k) break; //if there is not enough nodes then break the loop

                Singly_linkedlist.Node prev = null;
                Singly_linkedlist.Node groupStart = current;
                for (int i = 0; i < k; i++) {
                    Singly_linkedlist.Node next = current.next;
//                    current.next = prev;
                    prev = current;
                    current = next;
                }

                prevGroupEnd = prev;

                skip += 1;
            }else{
                //check if the nodes are enough to reverse
                Singly_linkedlist.Node temp = current;
                int count = 0;
                while(temp != null && count <k){
                    temp = temp.next;
                    count += 1;
                }

                if(count < k) break; //if there is not enough nodes then break the loop

                //reverse k nodes
                Singly_linkedlist.Node prev = null;
                Singly_linkedlist.Node groupStart = current;
                for (int i = 0; i < k; i++) {
                    Singly_linkedlist.Node next = current.next;
                    current.next = prev;
                    prev = current;
                    current = next;
                }

                //connect the reversed list
                prevGroupEnd.next = prev;
                groupStart.next = current;
                prevGroupEnd = groupStart;

                skip += 1;
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {

        Singly_linkedlist sl = new Singly_linkedlist();
        sl.insertAtFirst(9);
        sl.insertAtFirst(8);
        sl.insertAtFirst(7);
        sl.insertAtFirst(6);
        sl.insertAtFirst(5);
        sl.insertAtFirst(4);
        sl.insertAtFirst(3);
        sl.insertAtFirst(2);
        sl.insertAtFirst(1);
        sl.display(sl.head);

        Singly_linkedlist.Node reverseKGroups = reverseKGroup(sl.head, 3);
        sl.display(reverseKGroups);

    }

}
