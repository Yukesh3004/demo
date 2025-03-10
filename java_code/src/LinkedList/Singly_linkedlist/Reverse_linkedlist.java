package LinkedList.Singly_linkedlist;

import java.util.Stack;

public class Reverse_linkedlist { //leetcode problem no:206
    public static Singly_linkedlist.Node reverseList(Singly_linkedlist.Node head){
        //iterative method
//        Stack<Integer> stack = new Stack<>();
//
//        Singly_linkedlist.Node temp = head;
//        while(temp != null){  //put the node values into the stack
//            stack.push(temp.val);
//            temp = temp.next;
//        }
//
//        temp = head;
//        while(temp != null){ //change the node values from taking the stack
//            temp.val = stack.pop();
//            temp = temp.next;
//        }
//
//        return head; //this time complexity is O(2N) & space complexity is O(N)

        //another iterative method(improvised)
//        Singly_linkedlist.Node back = null;
//        Singly_linkedlist.Node current = head;
//
//        while (current != null) {
//            Singly_linkedlist.Node front = current.next;
//            current.next = back;
//            back = current;
//            current = front;
//        }
//
//        head = back;
//
//        return head; //tc is O(N) & sc is O(1)

        //recursive method
        if(head == null || head.next == null){
            return head;
        }
        Singly_linkedlist.Node newHead = reverseList(head.next);
        Singly_linkedlist.Node front = head.next;
        front.next = head;
        head.next = null;

        return newHead; //tc is O(N) & sc is O(N)
    }

    public static void main(String[] args){

        Singly_linkedlist sl = new Singly_linkedlist();
        sl.insertAtFirst(10);
        sl.insertAtFirst(20);
//        sl.insertAtFirst(30);
//        sl.insertAtFirst(40);

        sl.display(sl.head);

        Singly_linkedlist.Node reversedList = reverseList(sl.head);

        sl.display(reversedList);

    }

}
