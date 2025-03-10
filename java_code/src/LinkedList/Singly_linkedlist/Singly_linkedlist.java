package LinkedList.Singly_linkedlist;

public class Singly_linkedlist {
    public class Node{
        public int val;
        public Node next;

        public Node(int val){
            this.val = val;
        }

        public Node(int val, Node next){
            this.val = val;
            this.next = next;
        }
    }

    public Node head;
    public Node tail;
    public int size;

    public void display(Node head){
        Node temp = head;

        while(temp != null){
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
        System.out.println("size = " + size);
    }

    public void insertAtFirst(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;

        if(tail == null){
            tail = head;
        }

        size++;
    }

    public void insertAtLastWithTail(int val){
        if(tail == null){
            insertAtFirst(val);
        }else{
            Node node = new Node(val);
            node.next = null;
            tail.next = node;
            tail = node;
            size++;
        }
    }

    public void insertAtLastWithoutTail(int val){
        if(tail == null){
            insertAtFirst(val);
            return;
        }

        Node temp = head;
        while(temp != null){
            if(temp.next == null){
                Node node = new Node(val);
                node.next = null;
                temp.next = node;
                size++;
                return;
            }
            temp = temp.next;
        }
    }

    public void insertAtIndex(int val, int index){
        if(index == 0){
            insertAtFirst(val);
            return;
        }

        if(index == size){
            insertAtLastWithoutTail(val);
            return;
        }

        Node temp = head;

        for(int i=1; i<index; i++){
            if(temp == null) return;
            temp = temp.next;
        }


        if(temp == null){
            return;
        }
        Node node = new Node(val, temp.next);
        temp.next = node;
        size++;
    }

    public void deleteFirst(){
        head = head.next;
        if(head == null) tail = null;
        size--;
    }

    public void deleteLast(){
        if(head == tail){
            deleteFirst();
            return;
        }

        Node temp = head;
        while(temp.next != tail){
            temp = temp.next;
        }
        tail = temp;
        tail.next = null;
        size--;
    }

    public void deleteAtIndex(int index){
         if(index == 0){
             deleteFirst();
             return;
         }
         if(index == size-1){
             deleteLast();
             return;
         }
         Node prev = getNode(index);
         prev.next = prev.next.next;
         size--;
    }

    public Node getNode(int index){
        Node temp = head;
        for(int i=1; i<index; i++){
            temp = temp.next;
        }

        return temp;
    }


    public static void main(String[] args){
        Singly_linkedlist sl = new Singly_linkedlist();
        sl.insertAtFirst(10);
        sl.insertAtFirst(20);
        sl.insertAtFirst(30);
        sl.insertAtFirst(40);

//        sl.insertAtLastWithTail(0);
//        sl.insertAtLastWithoutTail(-1);

//        sl.insertAtIndex(25, 6);

        sl.display(sl.head);

//        sl.deleteFirst();
//        sl.deleteLast();
        sl.deleteAtIndex(0);
        sl.display(sl.head);
    }

}
