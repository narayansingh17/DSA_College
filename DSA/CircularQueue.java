import java.util.Scanner;

public class CircularQueue {
    int[] queue;
    int front, rear, size;

    // Constructor
    CircularQueue(int size) {
        this.size = size;
        queue = new int[size];
        front = -1;
        rear = -1;
    }

    // Enqueue operation
    void enqueue(int job) {
        // Queue is full
        if ((rear + 1) % size == front) {
            System.out.println("Queue Overflow! Circular Queue is full.");
            return;
        }

        // First element
        if (front == -1) {
            front = 0;
            rear = 0;
        } else {
            rear = (rear + 1) % size;
        }

        queue[rear] = job;
        System.out.println("Print job " + job + " added.");
    }

    // Dequeue operation
    void dequeue() {
        // Queue is empty
        if (front == -1) {
            System.out.println("Queue Underflow! No print job.");
            return;
        }

        System.out.println("Print job " + queue[front] + " completed.");

        // Only one element was left
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % size;
        }
    }

    // Peek operation
    void peek() {
        if (front == -1) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.println("Next print job: " + queue[front]);
    }

    // Display operation
    void display() {
        if (front == -1) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.println("Print jobs in queue:");
        int i = front;
        while (true) {
            System.out.print(queue[i] + " ");
            if (i == rear) {
                break;
            }
            i = (i + 1) % size;
        }
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter queue size: ");
        int size = sc.nextInt();
        CircularQueue q = new CircularQueue(size);

        int choice;
        do {
            System.out.println("\n--- Printer Circular Queue ---");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter print job number: ");
                    int job = sc.nextInt();
                    q.enqueue(job);
                    break;
                case 2:
                    q.dequeue();
                    break;
                case 3:
                    q.peek();
                    break;
                case 4:
                    q.display();
                    break;
                case 5:
                    System.out.println("Program terminated.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);

        sc.close();
    }
}