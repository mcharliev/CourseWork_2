package secondCourseWork;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class NotebookService extends Notebook {
    Notebook book = new Notebook();

    public void inputTask(Scanner scanner) throws InvalidDataOfTask {
        String taskName = setTaskName(scanner);
        String description = setDescription(scanner);
        TypeOfTask typeOfTask = setTypeOfTask(scanner);
        LocalDate localDate = setDate(scanner);
        Repeatable repeatability = chooseRepeatability(scanner);
        book.addTask(new Task(taskName,
                description,
                typeOfTask,
                localDate,
                repeatability));
    }

    public static Repeatable chooseRepeatability(Scanner scanner) throws InvalidDataOfTask {
        Repeatable repeatability = null;
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
                }
            } else {
                throw new InvalidDataOfTask("Неверно указана повторяемость задачи");
            }
            return repeatability;
        }
    }

    public static void printRepeatability() {
        System.out.println(
                "Введите тип повторяемости: " +
                        "\nВведите:-1- если задача ежедневная " +
                        "\nВведите:-2- если задача еженедельная " +
                        "\nВведите:-3- если задача ежемесячная  " +
                        "\nВведите:-4- если задача ежегодная  " +
                        "\nВведите:-5- если задача однократная "
        );
    }

    public String setTaskName(Scanner scanner) throws InvalidDataOfTask {
        System.out.print("Введите название задачи: ");
        String taskName = scanner.next();
        if (taskName == null || taskName.isEmpty()) {
            throw new InvalidDataOfTask("Неверно указано имя задачи");
        }
        return taskName;
    }

    public String setDescription(Scanner scanner) throws InvalidDataOfTask {
        System.out.print("Введите описание задачи: ");
        String description = scanner.next();
        if (description == null || description.isEmpty()) {
            throw new InvalidDataOfTask("Неверно указано описание задачи");
        }
        return description;
    }

    public LocalDate setDate(Scanner scanner) {
        System.out.print("Назначьте дату для задачи по образцу: dd-MM-yyyy : ");
        String date = scanner.next();
        LocalDate localDate;
        localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        return localDate;
    }

    public TypeOfTask setTypeOfTask(Scanner scanner) throws InvalidDataOfTask {
        TypeOfTask typeOfTask = null;
        while (true) {
            System.out.print("Выберите тип задачи:" +
                    " 1: личная" +
                    " 2: рабочая" +
                    " \nВведите пункт: ");
            if (scanner.hasNextInt()) {
                int menu = scanner.nextInt();
                switch (menu) {
                    case 1:
                        typeOfTask = TypeOfTask.PERSONAL_TASK;
                        break;
                    case 2:
                        typeOfTask = TypeOfTask.WORK_TASK;
                        break;
                }
            } else {
                throw new InvalidDataOfTask("Неверно указан тип задачи");
            }
            return typeOfTask;
        }
    }

    public void deleteTask(Scanner scanner) throws InvalidDataOfTask {
        book.removeTask(getIdOfTask(scanner));
    }

    public int getIdOfTask(Scanner scanner) throws InvalidDataOfTask {
        System.out.print("Введите id  задачи которую хотите удалить: ");
        int id;
        if (scanner.hasNextInt()) {
            id = scanner.nextInt();
        } else {
            throw new InvalidDataOfTask("Задача с указанным ID не найдена");
        }
        return id;
    }

    public void getTaskOfDate(Scanner scanner) {
        System.out.print("Чтобы посмотреть список задач " +
                "запланированных на определенную дату " +
                "введите дату по образцу dd-MM-yyyy : ");
        String date = scanner.next();
        LocalDate checkDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        book.searchTaskForTheDate(checkDate);
    }
}
