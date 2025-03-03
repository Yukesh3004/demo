package LinkedList.Doubly_linkedlist;

import LinkedList.Singly_linkedlist.Singly_linkedlist;

public class Doubly_linkedlist {

    private class Node{
        private int val;
        private Node next;
        private Node prev;

        public Node(int val){
            this.val = val;
        }

        public Node(int val, Node next, Node prev){
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }

    public static void main(String[] args){
        Doubly_linkedlist sl = new Doubly_linkedlist();
    }
}
