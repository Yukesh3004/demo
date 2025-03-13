package LinkedList.Singly_linkedlist;

public class Linkedlist_cycle_II { //leetcode no:142

    public static Singly_linkedlist.Node detectCycle(Singly_linkedlist.Node head){
        Singly_linkedlist.Node slow = head;
        Singly_linkedlist.Node fast = head;
        int size = 0;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                size = 1;
                fast = fast.next;
                while(slow != fast){
                    size += 1;
                    fast = fast.next;
                }
                break;
            }
        }

        if(size == 0) return null;

        slow = head;
        fast = head;
        while(size > 0){
            slow = slow.next;
            size -= 1;
        }

        if(fast == slow) return slow;
        else{
            while(fast != slow){
                slow = slow.next;
                fast = fast.next;
                if(fast == slow) return slow;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Singly_linkedlist sl = new Singly_linkedlist();
        sl.insertAtFirst(10);
        sl.insertAtFirst(20);
        sl.insertAtFirst(30);
        sl.insertAtFirst(40);
        sl.makeCycleList(50, sl.head);

        Singly_linkedlist.Node hasCycleNode = detectCycle(sl.head);
        sl.display(hasCycleNode);
    }

}
