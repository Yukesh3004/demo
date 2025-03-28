package LinkedList.Singly_linkedlist;

public class BookStore_maintaining { // interview question

    public class Node{
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
    }

    Node head = null;

    public void addBooks(String title, String author, String genre){
        Node newBook = new Node(title, author, genre);
        if(head == null){
            head = newBook;
        }else{
            newBook.next = head;
            head = newBook;
        }
    }

    public static Node partitionBooksByGenre(Node head, String genre){

    }

    public static void main(String[] args) {

    }

}
