
class ListNode {
    int data;
    ListNode next;

    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Algorithms {
    public ListNode findMiddleNode(ListNode head) {
        // Initialize two pointers, slow and fast
        ListNode slowPointer = head;
        ListNode fastPointer = head;

        // Traverse the linked list with two pointers
        while (fastPointer != null && fastPointer.next != null) {
            // Move slowPointer one step
            slowPointer = slowPointer.next;
            // Move fastPointer two steps
            fastPointer = fastPointer.next.next;
        }

        // At this point, slowPointer is at the middle (or second middle) node
        return slowPointer;
    }

    public static void main(String[] args) {
        // Example usage
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        Algorithms algorithms = new Algorithms();
        ListNode result = algorithms.findMiddleNode(head);
        System.out.println(result.data);
    }
}
