package FastAndSlowPointerApproach;

public class palindromelinkedList {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public static Node head;
    public static Node tail;

    // Add node at the end
    public static void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    // Find middle of linked list
    public static Node findMid(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Check if the linked list is palindrome
    public static boolean isPalindrome() {
        if (head == null || head.next == null) {
            return true;
        }

        // Step 1: Find mid
        Node midNode = findMid(head);

        // Step 2: Reverse second half
        Node prev = null;
        Node curr = midNode;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Step 3: Compare both halves
        Node left = head;
        Node right = prev; // Start of reversed second half

        while (right != null) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }

    public static void main(String[] args) {
        addLast(1);
        addLast(2);
        addLast(2);
        addLast(1);

        System.out.println("Is palindrome: " + isPalindrome()); // true
    }
}
// Time Complexity: O(n)