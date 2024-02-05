package Lab1;

import java.util.Scanner;

public class LinkedStack {
    private int maxSize;
    private Node top;

    public LinkedStack(int size) {
        maxSize = size;
        top = null;
    }

    public void push(Names name) {
        if (isFull()) {
            System.out.println("Stack is full. Cannot push " + name);
        } else {
            Node newNode = new Node(name);
            newNode.next = top;
            top = newNode;
        }
    }

    public Names pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop.");
            return null;
        } else {
            Names poppedName = top.data;
            top = top.next;
            return poppedName;
        }
    }

    public Names peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot peek.");
            return null;
        } else {
            return top.data;
        }
    }

    public boolean isFull() {
        return getSize() == maxSize;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int getSize() {
        int size = 0;
        Node current = top;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }

    public void displayStack() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
        } else {
            System.out.print("Stack: ");
            Node current = top;
            while (current != null) {
                System.out.print(current.data.getName() + " ");
                current = current.next;
            }
            System.out.println();
        }
    }

    public static void test() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the stack: ");
        int size = scanner.nextInt();

        LinkedStack myStack = new LinkedStack(size);

        int choice;
        do {
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Display Stack");
            System.out.println("4. Peek");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid option.");
                scanner.next();
            }
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter a name to push:");
                    System.out.println("Available names: " + java.util.Arrays.asList(Names.values()));
                    scanner.nextLine();                   String inputName = scanner.nextLine();
                    try {
                        Names name = Names.valueOf(inputName.toUpperCase());
                        myStack.push(name);
                    } catch (Exception e) {
                        System.out.println("Invalid name. Please enter a valid name from the list.");
                    }
                    break;
                case 2:
                    Names poppedName = myStack.pop();
                    if (poppedName != null) {
                        System.out.println("Popped name: " + poppedName);
                    }
                    break;
                case 3:
                    myStack.displayStack();
                    break;
                case 4:
                    Names peekedName = myStack.peek();
                    if (peekedName != null) {
                        System.out.println("Top of the stack: " + peekedName);
                    }
                    break;
                case 5:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        } while (choice != 5);


    }
}

