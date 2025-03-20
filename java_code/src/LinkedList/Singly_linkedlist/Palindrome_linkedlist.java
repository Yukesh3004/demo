package LinkedList.Singly_linkedlist;

import java.util.Stack;

public class Palindrome_linkedlist { //leetcode no:234

    public static boolean isPalindrome(Singly_linkedlist.Node head){
        //brute force
//        if(head == null || head.next == null) return true;
//
//        Singly_linkedlist.Node temp1;
//
//        //store the list into the stack
//        Stack<Integer> stack = new Stack<>();
//        temp1 = head;
//        while(temp1 != null){
//            stack.push(temp1.val);
//            temp1 = temp1.next;
//        }
//
//        temp1 = head;
//        while(!stack.isEmpty()){
//            if(temp1.val != stack.pop()) return false;
//            temp1 = temp1.next;
//        }
//
//        return true;

        //improvised
        if(head == null || head.next == null) return true;

        //find the mid node
        Singly_linkedlist.Node mid = findMid(head);

        //reverse the list that starts from mid
        Singly_linkedlist.Node reversedList = reverseList(mid);

        //compare
        while(head != null){
            if(head.val != reversedList.val) return false;
            head = head.next;
            reversedList = reversedList.next;
        }

        return true;
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

        boolean isPalindrome = isPalindrome(sl.head);
        System.out.println(isPalindrome);

    }

}
