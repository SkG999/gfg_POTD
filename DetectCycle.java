package gfg160;

import java.util.*;

public class DetectCycle {
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

    // the solution for potd
    public static boolean detectLoop(Node head) {
        Set<Node> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head))
                return true;
            set.add(head);
            head = head.next;
        }
        return false;
    }

    public static void main(String[] args) {
        DetectCycle obj = new DetectCycle();
        obj.insertAtEnd(1);
        obj.insertAtEnd(3);
        obj.insertAtEnd(4);

        // Display the linked list (no loop here)
        System.out.println("Linked List without loop:");
        obj.display();

        // Create a loop for testing
        obj.tail.next = obj.head; // Point the last node to the head to create a loop

        // Test detectLoop method
        boolean hasLoop = detectLoop(obj.head);
        System.out.println("Does the linked list have a loop? " + hasLoop);

    }

}
