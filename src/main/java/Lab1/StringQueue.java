package Lab1;

import java.util.Scanner;

public class StringQueue {
    private int maxSize;
    private int begin;
    private int end;
    private int number_of_elements = 0;
    private String[] queueArray;

    public StringQueue(int size) {
        maxSize = size;
        queueArray = new String[maxSize];
        begin = -1;
        end = -1;
    }
    public void enqueue(String value) {

        if (isFull()) return;

        number_of_elements++;

        if (isEmpty()) {

            begin = 0;
        }

        end = (end + 1) % maxSize;

        if (queueArray[end] == null) {

            queueArray[end] = value;
        }

    }

    public String dequeue() {

        if (this.isEmpty()) return null;

        number_of_elements--;

        String res = queueArray[begin];

        queueArray[begin] = null;

        if (begin == this.end) {

            begin = -1;
            end = -1;
        }
        else {

            begin = (begin + 1) % maxSize;
        }

        return res;
    }

    public String peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot peek.");
            return null;
        } else {
            return queueArray[begin];
        }
    }

    public boolean isFull() {
        return ((end + 1) % maxSize) == begin;
    }

    public boolean isEmpty() {
        return (begin == -1) && (end == -1);
    }

    public void displayQueue() {

        if (isEmpty()) {
            System.out.println("Queue is empty.");
        } else {

            for (int i = 0; i < maxSize; i++) {
                System.out.print(queueArray[i] + " ");
            }

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
