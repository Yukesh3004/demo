package LinkedList.Singly_linkedlist;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Remove_duplicates_from_sortedList {

    public static Singly_linkedlist.Node deleteDuplicates(Singly_linkedlist.Node head){
//        Map<Integer, Integer> tm = new TreeMap<>();
//        Singly_linkedlist.Node temp = head;
//
//        while(temp != null){
//            if(!tm.containsKey(temp.val)){
//                tm.put(temp.val,1);
//                temp = temp.next;
//            }else temp = temp.next;
//        }
//
//        temp = head;
//        int size = tm.size();
//        for(Map.Entry<Integer, Integer> m : tm.entrySet()){
//            temp.val = m.getKey();
//            size--;
//            if(size == 0){
//                temp.next = null;
//                return head;
//            }
//            temp = temp.next;
//        }
//
//        return head;

        //improvised
        if(head == null) return head;

        Singly_linkedlist.Node temp = head;

        while(temp.next != null){
            if(temp.val == temp.next.val) temp.next = temp.next.next;
            else temp = temp.next;
        }

        return head;
    }

    public static void main(String[] args) {
        Singly_linkedlist sl = new Singly_linkedlist();
        sl.insertAtFirst(40);
        sl.insertAtFirst(40);
        sl.insertAtFirst(40);
        sl.insertAtFirst(40);
        sl.display(sl.head);

        Singly_linkedlist.Node deleteDulpicates = deleteDuplicates(sl.head);
        sl.display(deleteDulpicates);
    }

}
