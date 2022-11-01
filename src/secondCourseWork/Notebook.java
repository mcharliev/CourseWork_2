package secondCourseWork;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Notebook {
    private static Map<Integer, Task> map = new HashMap<>();

    public void inputTask(Scanner scanner) throws Exception {
        String taskName = setTaskName(scanner);
        String description = setDescription(scanner);
        TypeOfTask typeOfTask = setTypeOfTask(scanner);
        LocalDate localDate = setDate(scanner);
        Repeatable repeatability = chooseRepeatability(scanner);
        map.put(Task.getCount(), new Task(taskName,
                description,
                typeOfTask,
                localDate,
                repeatability));
    }

    public Repeatable chooseRepeatability(Scanner scanner) throws Exception {
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
                throw new Exception("Неверно указана повторяемость задачи");
            }
            return repeatability;
        }
    }


    private void printRepeatability() {
        System.out.println(
                "Введите тип повторяемости: " +
                        "\nВведите:-1- если задача ежедневная " +
                        "\nВведите:-2- если задача еженедельная " +
                        "\nВведите:-3- если задача ежемесячная  " +
                        "\nВведите:-4- если задача ежегодная  " +
                        "\nВведите:-5- если задача однократная "
        );
    }


    public void removeTask(Scanner scanner) throws Exception {
        System.out.print("Введите id  задачи которую хотите удалить: ");
        int id = scanner.nextInt();
        if (map.containsKey(id)) {
            map.remove(id);
        } else {
            throw new Exception("Задача с указанным ID не найдена");
        }
    }

    public void printTaskOfDate(Scanner scanner) {
        System.out.print("Чтобы посмотреть список задач " +
                "запланированных на определенную дату " +
                "введите дату по образцу dd-MM-yyyy : ");
        String date = scanner.next();
        LocalDate checkDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        for (Map.Entry<Integer, Task> element : map.entrySet()) {
            LocalDate dateOfTask = element.getValue().getLocalDate();
            if (dateOfTask.isEqual(checkDate)) {
                System.out.println("Задача назначенная на дату " +
                        date +
                        ": " +
                        element.getValue().getTitleOfTask());
                break;
            }
            while (dateOfTask.isBefore(checkDate)) {
                dateOfTask = element.getValue().getRepeatability().showRepeatability(dateOfTask);
                if (dateOfTask.isEqual(checkDate)) {
                    System.out.println("Задача назначенная на дату " +
                            date +
                            ": " +
                            element.getValue().getTitleOfTask());
                    break;
                }
            }
        }
    }

    public void printAllTasks() {
        for (Map.Entry<Integer, Task> element : map.entrySet()) {
            System.out.println("Task №" + element.getKey() +
                    " " + element.getValue());
        }
    }

    public String setTaskName(Scanner scanner) throws Exception {
        System.out.print("Введите название задачи: ");
        String taskName = scanner.next();
        if (taskName == null || taskName.isEmpty()) {
            throw new Exception("Неверно указано имя задачи");
        }
        return taskName;
    }

    public String setDescription(Scanner scanner) throws Exception {
        System.out.print("Введите описание задачи: ");
        String description = scanner.next();
        if (description == null || description.isEmpty()) {
            throw new Exception("Неверно указано описание задачи");
        }
        return description;
    }

    public TypeOfTask setTypeOfTask(Scanner scanner) throws Exception {
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
                throw new Exception("Неверно указан тип задачи");
            }
            return typeOfTask;
        }
    }

    public LocalDate setDate(Scanner scanner) {
        System.out.print("Назначьте дату для задачи по образцу: dd-MM-yyyy : ");
        String date = scanner.next();
        LocalDate localDate;
        localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        return localDate;
    }
}





