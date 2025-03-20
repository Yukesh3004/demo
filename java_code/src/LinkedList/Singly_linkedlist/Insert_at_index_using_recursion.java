package LinkedList.Singly_linkedlist;

public class Insert_at_index_using_recursion {

    public static Singly_linkedlist.Node insertUsingRecursion(int index, int val, Singly_linkedlist.Node head){
        //brute force
        if(index == 0){
            Singly_linkedlist sl = new Singly_linkedlist();
            Singly_linkedlist.Node node = sl.new Node(val,head);
            sl.size++;
            return node;
        }

        head.next = insertUsingRecursion(--index, val, head.next);

        return head;
    }

    public static void main(String[] args) {
        Singly_linkedlist sl = new Singly_linkedlist();
        sl.insertAtFirst(10);
        sl.insertAtFirst(20);
        sl.insertAtFirst(30);
        sl.insertAtFirst(40);
        sl.display(sl.head);

        Singly_linkedlist.Node insertNode = insertUsingRecursion(3,25, sl.head);
        sl.display(insertNode);
    }

}
