package LinkedList.Singly_linkedlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sort_list { //leetcode no:148

    public static Singly_linkedlist.Node sortList(Singly_linkedlist.Node head) {
        //brute force
//        List<Integer> arrayList = new ArrayList<>();
//        Singly_linkedlist.Node temp = head;
//
//        while(temp != null){
//            arrayList.add(temp.val);
//            temp = temp.next;
//        }
//
//        Collections.sort(arrayList);
//
//        temp = head;
//        for(int i : arrayList){
//            temp.val = i;
//            temp = temp.next;
//        }
//
//        return head;

        //improvised
        if(head == null || head.next == null) return head;

        Singly_linkedlist.Node mid = findMid(head);
        Singly_linkedlist.Node left = sortList(head);
        Singly_linkedlist.Node right = sortList(mid);

        return mergeList(left, right);
    }

    private static Singly_linkedlist.Node mergeList(Singly_linkedlist.Node left, Singly_linkedlist.Node right) {
        Singly_linkedlist sl = new Singly_linkedlist();
        Singly_linkedlist.Node dummyNode = sl.new Node();
        Singly_linkedlist.Node temp = dummyNode;

        while(left != null && right != null){
            if(left.val < right.val){
                temp.next = left;
                left = left.next;
                temp = temp.next;
            }else{
                temp.next = right;
                right = right.next;
                temp = temp.next;
            }
        }

        temp.next = (left != null) ? left : right;
        return dummyNode.next;
    }

    private static Singly_linkedlist.Node findMid(Singly_linkedlist.Node head) {
        Singly_linkedlist.Node midprev = null;
        while(head != null && head.next != null){
            midprev = (midprev == null) ? head : midprev.next;
            head = head.next.next;
        }

        Singly_linkedlist.Node mid = midprev.next;
        midprev.next = null;

        return mid;
    }

    public static void main(String[] args) {
        Singly_linkedlist sl = new Singly_linkedlist();
        sl.insertAtFirst(3);
        sl.insertAtFirst(1);
        sl.insertAtFirst(2);
        sl.insertAtFirst(4);
        sl.display(sl.head);

        Singly_linkedlist.Node sortList = sortList(sl.head);
        sl.display(sortList);
    }

}
