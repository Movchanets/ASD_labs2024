package org.labs;


import Lab1.Gender;
import Lab1.LinkedStack;
import Lab1.Names;
import Lab1.StringQueue;

import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        int task = 0;
        do {
            System.out.println("1. Перший рівень");
            System.out.println("2. Другий рівень");
            System.out.println("3. Третій рівень");
            System.out.println("4. Вихід");
            System.out.print("Введіть номер завдання: ");
            Scanner scan = new Scanner(System.in);
            while (!scan.hasNextInt()) {
                System.out.println("Введіть номер завдання: ");
                scan.next();
            }
            task = scan.nextInt();
            switch (task) {
                case 1:
                    System.out.println("Перший рівень");
                    StringQueue.test();
                    break;
                case 2:
                    System.out.println("Другий рівень");
                    LinkedStack.test();
                    break;
                case 3:
                    System.out.println("Третій рівень");
                {
                    ;

                    System.out.print("Enter the size of the stack: ");
                    int stackSize = scan.nextInt();

                    LinkedStack enumStack = new LinkedStack(stackSize);
                    StringQueue femaleQueue = new StringQueue(stackSize);
                    StringQueue maleQueue = new StringQueue(stackSize);


                    int Choice;
                    do {
                        System.out.println("1. Push");
                        System.out.println("2. Pop");
                        System.out.println("3. Display Stack");
                        System.out.println("4. Peek");
                        System.out.println("5. Form Female and Male Queues");
                        System.out.println("6. Exit");
                        System.out.print("Enter your choice: ");
                        while (!scan.hasNextInt()) {
                            System.out.println("Invalid choice. Please enter a valid option.");
                            scan.next();
                        }
                        Choice = scan.nextInt();

                        switch (Choice) {
                            case 1:
                                System.out.println("Enter a name to push:");
                                System.out.println("Available names: " + (Arrays.toString(Names.values())));
                                scan.nextLine();
                                String inputName = scan.nextLine();
                                try {
                                    Names name = Names.valueOf(inputName.toUpperCase());
                                    enumStack.push(name);
                                } catch (Exception e) {
                                    System.out.println("Invalid name. Please enter a valid name from the list.");
                                }
                                break;
                            case 2:
                                Names poppedName = enumStack.pop();
                                if (poppedName != null) {
                                    System.out.println("Popped name: " + poppedName);
                                }
                                break;
                            case 3:
                                enumStack.displayStack();
                                break;
                            case 4:
                                Names peekedName = enumStack.peek();
                                if (peekedName != null) {
                                    System.out.println("Top of the stack: " + peekedName);
                                }
                                break;
                            case 5:
                                System.out.println("Forming Female and Male Queues...");
                                femaleQueue = new StringQueue(stackSize);
                                maleQueue = new StringQueue(stackSize);

                                while (!enumStack.isEmpty()) {
                                    Names name = enumStack.pop();
                                    if (name.getGender() == Gender.FEMALE) {
                                        femaleQueue.enqueue(name.toString());
                                    } else {
                                        maleQueue.enqueue(name.toString());
                                    }
                                }

                                System.out.println("Contents of the Female Queue:");
                                femaleQueue.displayQueue();

                                System.out.println("Contents of the Male Queue:");
                                maleQueue.displayQueue();
                                break;
                            case 6:
                                System.out.println("Exiting program.");
                                break;
                            default:
                                System.out.println("Invalid choice. Please enter a valid option.");
                                break;
                        }
                    } while (Choice != 6);


                }

                break;
                case 4:
                    System.out.println("Вихід");
                    break;
                default:
                    System.out.println("Введіть номер завдання: ");
                    break;
            }
        } while (task != 4);
    }
}








