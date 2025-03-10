package LinkedList.Singly_linkedlist;

public class Merge_two_sorted_lists { //leetcode no:21

    public static Singly_linkedlist.Node mergeTwoLists(Singly_linkedlist.Node node1, Singly_linkedlist.Node node2) {
//        Singly_linkedlist.Node temp1 = node1;
//        Singly_linkedlist.Node temp2 = node2;
//        Singly_linkedlist.Node temp;
//        Singly_linkedlist.Node current = null;
//
//        if(node1 == null && node2 != null)  return node2;
//        else if(node2 == null && node1 != null) return node1;
//        else if(node1 == null && node2 == null) return node1;
//
//        Singly_linkedlist.Node head = null;
//        if (temp1.val > temp2.val) {
//            head = temp2;
//        } else {
//            head = temp1;
//        }
//
//        while (temp1 != null && temp2 != null) {
////            if (temp1.val < temp2.val) {
////                temp = temp1.next;
////                temp1.next = temp2;
////                temp1 = temp;
////                temp = temp2;
////                temp.next = temp1;
////                temp2 = temp2.next;
////            } else
//                if (temp2.val < temp1.val) {
//                if(current == null){
//                    current = temp2;
//                }else{
//                    current.next = temp2;
//                    current = temp2;
//                }
//
//                if((temp1.next == null && temp2.next != null) || (temp2.next == null && temp1.next != null)) {
//                    temp2 = temp2.next;
//                    continue;
//                }
//                current.next = temp1;
//                temp1 = temp1.next;
//                temp2 = temp2.next;
//            } else {
//                if(current == null){
//                    current = temp1;
//                }else{
////                    current.next = temp1;
////                    current = temp1;
//                }
//
//                if((temp1.next == null && temp2.next != null) || (temp2.next == null && temp1.next != null)) {
//                    temp2 = temp2.next;
//                    continue;
//                }
//                temp1 = temp1.next;
//            }
//        }
//
//        return head;

        if (node1 == null && node2 != null) return node2;
        else if (node2 == null && node1 != null) return node1;
        else if (node1 == null && node2 == null) return node1;

        Singly_linkedlist.Node temp1 = node1;
        Singly_linkedlist.Node temp2 = node2;

        Singly_linkedlist sl_object = new Singly_linkedlist();
        Singly_linkedlist.Node dummyNode = sl_object.new Node(-1, null);
        Singly_linkedlist.Node temp = dummyNode;

        while (temp1 != null && temp2 != null) {
            if (temp1.val < temp2.val) {
                temp.next = temp1;
                temp = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp = temp2;
                temp2 = temp2.next;
            }
        }

        if(temp1 == null && temp2 != null){
            temp.next = temp2;
            return dummyNode.next;
        }else if(temp2 == null  && temp1 != null){
            temp.next = temp1;
            return dummyNode.next;
        }

        return dummyNode.next;
    }

    public static void main(String[] args) {
        Singly_linkedlist sl = new Singly_linkedlist();
        sl.insertAtFirst(5);
        sl.insertAtFirst(2);
        sl.insertAtFirst(1);

        Singly_linkedlist sl1 = new Singly_linkedlist();
        sl1.insertAtFirst(4);
//        sl1.insertAtFirst(2);
//        sl1.insertAtFirst(1);

        Singly_linkedlist.Node mergeTwoLists = mergeTwoLists(sl.head, sl1.head);

        sl.display(mergeTwoLists);
    }
}
