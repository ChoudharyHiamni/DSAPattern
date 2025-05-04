package FastAndSlowPointerApproach;

public class cycleDetectionInLinkedList {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    static Node head;  

    public static boolean isCycle() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;         // move slow by 1
            fast = fast.next.next;    // move fast by 2

            if (slow == fast) {
                return true;          // cycle detected
            }
        }

        return false;                 // no cycle
    }

    public static void main(String args[]){
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = head; // create a cycle

        System.out.println(isCycle());
    }
}
