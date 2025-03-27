package LinkedList.Singly_linkedlist;

class Node{
    Node next;
    String title;
    String author;
    String genre;

    public Node(String title, String author, String genre){
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.next = null;
    }

    public Node(Node next){
        this.title = null;
        this.author = null;
        this.genre = null;
        this.next = next;
    }
}

public class BookStore_maintaining { // interview question

    static Node head = null;

    public static void addBooks(String title, String author, String genre){
        Node newBook = new Node(title, author, genre);
        if(head == null){
            head = newBook;
        }else{
            newBook.next = head;
            head = newBook;
        }
    }

    public static Node partitionBooksByGenre(Node head, String genre){
        Node current = head;
        Node prev = new Node(head);
        Node newHead = prev;
        Node next = head.next;

        while(current != null){
            if(current.genre.equals(genre) && next.genre.equals(genre)){
                current.next = next.next;
                next.next = prev.next;
                prev.next = next;
            }
            prev = prev.next;
            current = current.next;
            next = current.next;
        }

        return newHead.next;
    }

    public static void display(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.genre + " , ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        addBooks("The God of Small Things","Arundhati Roy","Fiction");
        addBooks("The God of Small Things","Arundhati Roy","Science");
        addBooks("The God of Small Things","Arundhati Roy","Fiction");
        addBooks("The God of Small Things","Arundhati Roy","Romance");
        display(head);

        Node result = partitionBooksByGenre(head, "Fiction");
        display(result);
    }

}
