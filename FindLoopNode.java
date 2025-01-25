import java.util.HashSet;
import java.util.Set;

public class FindLoopNode {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head = null;
    Node tail = null;

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void display() {
        if (head == null) {
            System.out.println("The linked list is empty.");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Solution of the Problem of the day (25 JANUARY)
    public static Node findFirstNode(Node head) {
        Set<Node> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }

    public static void main(String[] args) {
        FindLoopNode obj = new FindLoopNode();
        obj.insertAtEnd(1);
        obj.insertAtEnd(3);
        obj.insertAtEnd(2);
        obj.insertAtEnd(4);
        obj.insertAtEnd(5);
        obj.tail.next = obj.head; // Point the last node to the head to create a loop
        Node node = findFirstNode(obj.head);
        System.out.println(node.data);
        // according to my in put the answer is 1

    }
}
