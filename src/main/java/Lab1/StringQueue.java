package Lab1;

import java.util.Scanner;

public class StringQueue {
    private int maxSize;
    private int front;
    private int rear;
    private String[] queueArray;

    public StringQueue(int size) {
        maxSize = size;
        queueArray = new String[maxSize];
        front = 0;
        rear = -1;
    }

    public void enqueue(String value) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue " + value);
        } else {
            rear++;
            queueArray[rear] = value;
        }
    }

    public String dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return null;
        } else {
            String dequeuedValue = queueArray[front];
            front++;
            return dequeuedValue;
        }
    }

    public String peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot peek.");
            return null;
        } else {
            return queueArray[front];
        }
    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public boolean isEmpty() {
        return front > rear;
    }

    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            System.out.print("Queue: ");
            for (int i = front; i <= rear; i++) {
                System.out.print(queueArray[i] + " ");
            }
            System.out.println();
        }
    }

    public static void test() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the queue: ");
        int size = scanner.nextInt();

        StringQueue myQueue = new StringQueue(size);

        int choice;
        do {
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display Queue");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
           while (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid option.");
                scanner.next();
            }
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the element to enqueue: ");
                    scanner.nextLine();
                    String element = scanner.nextLine();
                    myQueue.enqueue(element);
                    break;
                case 2:
                    String dequeuedElement = myQueue.dequeue();
                    if (dequeuedElement != null) {
                        System.out.println("Dequeued element: " + dequeuedElement);
                    }
                    break;
                case 3:
                    myQueue.displayQueue();
                    break;
                case 4:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        } while (choice != 4);

        scanner.close();
    }

}
