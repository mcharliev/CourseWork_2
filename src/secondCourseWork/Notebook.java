package secondCourseWork;

import java.time.LocalDate;
import java.util.*;

public class Notebook {
    private static Map<Integer, Task> map = new HashMap<>();

    public void addTask(Task task) {
        map.put(task.getCount(), task);
    }

    public void removeTask(int id) {
        map.remove(id);
    }

    public void printAllTasks() {
        for (Map.Entry<Integer, Task> element : map.entrySet()) {
            System.out.println("Task №" + element.getKey() +
                    " " + element.getValue());
        }
    }
    public void searchTaskForTheDate(LocalDate checkDate) {
        for (Map.Entry<Integer, Task> element : map.entrySet()) {
            LocalDate dateOfTask = element.getValue().getLocalDate();
            if (dateOfTask.isEqual(checkDate)) {
                System.out.println("Задача назначенная на дату " +
                        checkDate +
                        ": " +
                        element.getValue().getTitleOfTask());
                break;
            }
            while (dateOfTask.isBefore(checkDate)) {
                dateOfTask = element.getValue().getRepeatability().showRepeatability(dateOfTask);
                if (dateOfTask.isEqual(checkDate)) {
                    System.out.println("Задача назначенная на дату " +
                            checkDate +
                            ": " +
                            element.getValue().getTitleOfTask());
                    break;
                }
            }
        }
    }
}





