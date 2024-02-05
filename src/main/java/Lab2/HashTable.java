package Lab2;



import java.util.Random;
import java.util.Scanner;


class Circle {

    private double centerX; // Координати центру
    private double centerY; // Координати центру
    private double radius;
        public Circle(double centerX, double centerY, double radius) {

        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
    }
    public static Circle createRandomCircle() { // Створення випадкового об'єкта
        Random random = new Random();
        double centerX = random.nextDouble() * 10;
        double centerY = random.nextDouble() * 10;
        double radius = random.nextDouble() * 5;
        return new Circle(centerX, centerY, radius); // Повернення об'єкта
    }
    public double calculateArea() {
            return Math.PI * radius * radius; // Обчислення площі
        }
    public double calculatePerimeter() {
        return 2 * Math.PI * radius; // Обчислення периметру
    }
    public void displayObject() {
        System.out.printf("Circle, CenterX: %.2f, CenterY: %.2f, Radius: %.2f%n ",  centerX, centerY, radius); // Виведення об'єкта
    }
}


public class HashTable {
    private Circle[] table;
    private int size;

    public HashTable(int size) {
        this.size = size;
        this.table = new Circle[size];
    }
    public void deleteByCriteria(double criteriaValue) {
        // Метод для видалення елементів згідно із заданим критерієм
        for (int i = 0; i < size; i++) {
            if (table[i] != null && table[i].calculateArea() > criteriaValue) {
                table[i] = null;
            }
        }
    }
    public int hashFunction(double key) {
        // Реалізація методу хешування (Множення) для заданого ключа (Площа)
        double A = 2; // Коефіцієнт для методу множення
        return (int) (size* ((key * A)%1));
    }
    private int quadraticProbing(int position, int attempt) {
        // Квадратичне зонування для вирішення колізій
        return (position + (int) Math.pow(attempt, 2)) % size;
    }
    public boolean insertRandomCircle() {
        Circle randomCircle = Circle.createRandomCircle();
        return insert(randomCircle);
    }
    public boolean insert(Circle figure) { // Вставка об'єкта в хеш-таблицю
        int position = hashFunction(figure.calculateArea());
        int attempt = 0;

        while (table[position] != null) {
            // Колізія - використовуємо квадратичне зонування
            attempt++;
            position = quadraticProbing(position, attempt);

            if (attempt >= size) {
                // Якщо весь масив перевірено і не знайдено вільного місця, вихід з циклу
                System.out.println("Table is full. Unable to insert the figure.");
                return false;
            }
        }

        // Вставка елемента
        table[position] = figure;
        return true;
    }

    public void displayTable() {
        for (int i = 0; i < size; i++) {
            if (table[i] != null) {
                System.out.printf("Position %d: ", i);
                table[i].displayObject();
            } else {
                System.out.printf("Position %d: Empty%n", i);
            }
        }
    }
    public static void test() {
        Scanner scanner = new Scanner(System.in);
        int tableSize;

        // Введення розміру хеш-таблиці з консолі
        System.out.print("Введіть розмір хеш-таблиці: ");
        tableSize = scanner.nextInt();

        HashTable hashTable = new HashTable(tableSize);

        int choice;
        do {
            // Меню
            System.out.println("\nОберіть опцію:");
            System.out.println("1. Додати випадковий круг");
            System.out.println("2. Вивести зміст хеш-таблиці");
            System.out.println("3. Видалити елементи за критерієм(периметр більше за введене значення)");
            System.out.println("0. Вийти");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    boolean inserted = hashTable.insertRandomCircle();
                    if (inserted) {
                        System.out.println("Успішно додано випадковий круг:");
                        hashTable.displayTable();
                    } else {
                        System.out.println("Колізія: не вдалося додати елемент.");
                    }
                    break;
                case 2:
                    System.out.println("Зміст хеш-таблиці:");
                    hashTable.displayTable();
                    break;
                    case 3:
                    System.out.print("Введіть значення критерію: ");
                    double criteriaValue = scanner.nextDouble();
                    hashTable.deleteByCriteria(criteriaValue);
                    System.out.println("Елементи видалено:");
                    hashTable.displayTable();
                    break;
                case 0:
                    System.out.println("Програма завершена.");
                    break;
                default:
                    System.out.println("Невірний вибір. Спробуйте ще раз.");
            }
        } while (choice != 0);


    }
}


