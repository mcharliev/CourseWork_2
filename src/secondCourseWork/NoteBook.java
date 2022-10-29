package secondCourseWork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class NoteBook {
    private static Map<Integer, Task> map = new HashMap<>();
    private static BufferedReader reader =
            new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException {
        addTask();
        System.out.println(map);
    }

    private static void inputTask(Scanner scanner) throws IOException {
        System.out.print("Введите название задачи: ");
        String taskName = reader.readLine();
        System.out.print("Введите описание задачи: ");
        String description = reader.readLine();
        System.out.print("Введите тип задачи: ");
        String typeOfTask = reader.readLine();
        Repeatability repeatability = chooseRepeatability(scanner);
        map.put(Task.id, new Task(taskName,
                description,
                typeOfTask,
                repeatability));
        System.out.print("Назначьте дату для задачи по образцу: dd-MM-yyyy ");
        repeatability.setLocalDateTime(scanner.next());
    }


    public static Repeatability chooseRepeatability(Scanner scanner) {
        Repeatability repeatability = null;
        while (true) {
            printRepeatability();
            System.out.print("Введите команду из списка: ");
            if (scanner.hasNextInt()) {
                int menu = scanner.nextInt();
                switch (menu) {
                    case 1:
                        repeatability = new DailyRepeatability();
                        break;
                    case 2:
                        repeatability = new WeeklyRepeatability();
                        break;
                    case 3:
                        repeatability = new MonthlyRepeatability();
                        break;
                    case 4:
                        repeatability = new YearlyRepeatability();
                        break;
                    case 5:
                        repeatability = new OneTimeRepeatability();
                        break;
                    case 0:
                        break;
                }
            } else {
                scanner.next();
                System.out.println("Выберите пункт меню из списка!");
            }
            return repeatability;
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

    private static void printRepeatability() {
        System.out.println(
                "Введите тип повторяемости: " +
                        "Введите:-1- если задача ежедневная " +
                        "Введите:-2- если задача еженедельная " +
                        "Введите:-3- если задача ежемесячная " +
                        "Введите:-4- если задача ежегодная " +
                        "Введите:-5- если задача однократная "
        );
    }

    public static void addTask() throws IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                printMenu();
                System.out.print("Выберите пункт меню: ");
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            inputTask(scanner);
                            break;
                        case 2:
                            removeTask(scanner);
                            break;
                        case 3:
                            printTaskOfDate(scanner);
                            break;
                            case 4:
                            printAllTasks();
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

    public static void removeTask(Scanner scanner) {
        System.out.print("Введите id  задачи которую хотите удалить: ");
        int id = scanner.nextInt();
        for (Map.Entry<Integer, Task> element : map.entrySet()) {
            if (element.getKey() == id) {
                map.remove(element.getKey());
            }
        }
    }

    public static void printTaskOfDate(Scanner scanner) {
        System.out.print("Чтобы посмотреть список задач " +
                "запланированных на определенную дату " +
                "введите дату по образцу dd-MM-yyyy : ");
        String date = scanner.next();
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        LocalDate searchDate;
        for (Map.Entry<Integer, Task> element : map.entrySet()) {
            searchDate = element.getValue().getRepeatability().showRepeatability();
            if (element.getValue().getRepeatability() instanceof OneTimeRepeatability &&
                    searchDate.isEqual(localDate)) {
                System.out.println("Задача назначенная на дату " +
                        date +
                        ": " +
                        element.getValue().getTitleOfTask());
            }
            if (element.getValue().getRepeatability() instanceof DailyRepeatability &&
                    searchDate.isBefore(localDate) ||
                    element.getValue().getRepeatability() instanceof DailyRepeatability &&
                            searchDate.isEqual(localDate)) {
                System.out.println("Задача назначенная на дату " +
                        date +
                        ": " +
                        element.getValue().getTitleOfTask());
            }
            if (element.getValue().getRepeatability() instanceof WeeklyRepeatability &&
                    searchDate.getDayOfWeek().equals(localDate.getDayOfWeek())) {
                System.out.println("Задача назначенная на дату " +
                        date +
                        ": " +
                        element.getValue().getTitleOfTask());
            }
            if (element.getValue().getRepeatability() instanceof MonthlyRepeatability &&
                    searchDate.getDayOfMonth() == (localDate.getDayOfMonth())) {
                System.out.println("Задача назначенная на дату " +
                        date +
                        ": " +
                        element.getValue().getTitleOfTask());
            }
            if (element.getValue().getRepeatability() instanceof YearlyRepeatability &&
                    searchDate.getDayOfYear() == (localDate.getDayOfYear())) {
                System.out.println("Задача назначенная на дату " +
                        date +
                        ": " +
                        element.getValue().getTitleOfTask());
            }
        }
    }

    public static void printAllTasks() {
        for (Map.Entry<Integer, Task> element : map.entrySet()) {
            System.out.println("Task №" + element.getKey() +
                    " " + element.getValue());
        }
    }
}



