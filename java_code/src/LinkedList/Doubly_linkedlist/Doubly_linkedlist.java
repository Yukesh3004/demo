package LinkedList.Doubly_linkedlist;

import LinkedList.Singly_linkedlist.Singly_linkedlist;

public class Doubly_linkedlist {

    public class Node{
        public int val;
        public Node next;
        public Node prev;

        public Node(){}

        public Node(int val){
            this.val = val;
        }

        public Node(int val, Node next, Node prev){
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }

    public Node head;
    public Node tail;
    int var;

    public void display(Node start){
        Node temp = start;

        System.out.print("Start <-> ");
        while(temp != null){
            System.out.print(temp.val + " <-> ");
            temp = temp.next;
        }
        System.out.println("End");
    }

    public void displayReverse(Node end){
        Node temp = end;

        System.out.print("End <-> ");
        while(temp != null){
            System.out.print(temp.val + " <-> ");
            temp = temp.prev;
        }
        System.out.println("Start");
    }

    public void insertAtFirst(int val){
        Node node = new Node(val);
        node.next = head;
        node.prev = null;
        if(head != null) head.prev = node;
        head = node;

        if(tail == null) tail = head;
    }

    public void insertAtLastWithoutTail(int val){
        if(head == null) insertAtFirst(val);
        else{
            Node node = new Node(val);
            Node temp = head;

            while(temp.next != null) temp = temp.next;

            temp.next = node;
            node.prev = temp;
            node.next = null;

            tail = node;
        }
    }

    public static void main(String[] args){
        Doubly_linkedlist dl = new Doubly_linkedlist();
//        Doubly_linkedlist.Node dln = dl.new Node();

//        dl.insertAtFirst(10);
//        dl.insertAtFirst(20);
        dl.insertAtLastWithoutTail(5);
        dl.display(dl.head);
//        dl.displayReverse(dl.tail);
    }

}
