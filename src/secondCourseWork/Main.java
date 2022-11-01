package secondCourseWork;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Notebook notebook = new Notebook();
        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                printMenu();
                System.out.print("Выберите пункт меню: ");
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            notebook.inputTask(scanner);
                            break;
                        case 2:
                            notebook.removeTask(scanner);
                            break;
                        case 3:
                            notebook.printTaskOfDate(scanner);
                            break;
                        case 4:
                            notebook.printAllTasks();
                            break;
                        case 0:
                            break label;
                    }
                } else {
                    scanner.next();
                    System.out.println("Выберите пункт меню из списка!");
                }
            }
        }
    }

    private static void printMenu() {
        System.out.println(
                " 1. Добавить задачу" +
                        " 2. Удалить задачу" + "" +
                        " 3. Получить задачу на указанный день" +
                        " 4. Получить все задачи" +
                        " 0. Выход"
        );
    }
}



