package secondCourseWork;

import java.time.LocalDate;

public class Task {
    private String titleOfTask;
    private TypeOfTask typeOfTask;
    private String descriptionOfTask;
    private Repeatable repeatability;
    private static int count = 1;
    private int id = count;
    private LocalDate localDate;


    public Task(String titleOfTask,
                String descriptionOfTask,
                TypeOfTask typeOfTask,
                LocalDate localDate,
                Repeatable repeatability
    ) {
        if (titleOfTask == null || titleOfTask.isEmpty()) {
            throw new RuntimeException("Title of task is unknown");
        } else {
            this.titleOfTask = titleOfTask;
        }
        if (typeOfTask == null || typeOfTask == null) {
            throw new RuntimeException("Type of task is unknown");
        } else {
            this.typeOfTask = typeOfTask;
        }
        if (descriptionOfTask == null || descriptionOfTask.isEmpty()) {
            throw new RuntimeException("Description of task is unknown");
        } else {
            this.descriptionOfTask = descriptionOfTask;
        }
        this.localDate = localDate;
        this.repeatability = repeatability;
        count++;
    }

    public Repeatable getRepeatability() {
        return repeatability;
    }

    public void setRepeatability(Repeatable repeatability) {
        this.repeatability = repeatability;
    }

    public String getTitleOfTask() {
        return titleOfTask;
    }

    public void setTitleOfTask(String titleOfTask) {
        this.titleOfTask = titleOfTask;
    }

    public TypeOfTask getTypeOfTask() {
        return typeOfTask;
    }

    public void setTypeOfTask(TypeOfTask typeOfTask) {
        this.typeOfTask = typeOfTask;
    }

    public String getDescriptionOfTask() {
        return descriptionOfTask;
    }

    public void setDescriptionOfTask(String descriptionOfTask) {
        this.descriptionOfTask = descriptionOfTask;
    }

    public static int getCount() {
        return count;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    @Override
    public String toString() {
        return "titleOfTask: " + titleOfTask +
                ", typeOfTask: " + typeOfTask.getRepresentation() +
                ", descriptionOfTask: " + descriptionOfTask +
                ", time of task: " + localDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;

        Task task = (Task) o;

        if (id != task.id) return false;
        if (getTitleOfTask() != null ? !getTitleOfTask().equals(task.getTitleOfTask()) : task.getTitleOfTask() != null)
            return false;
        if (getTypeOfTask() != null ? !getTypeOfTask().equals(task.getTypeOfTask()) : task.getTypeOfTask() != null)
            return false;
        if (getDescriptionOfTask() != null ? !getDescriptionOfTask().equals(task.getDescriptionOfTask()) : task.getDescriptionOfTask() != null)
            return false;
        if (getRepeatability() != null ? !getRepeatability().equals(task.getRepeatability()) : task.getRepeatability() != null)
            return false;
        return getLocalDate() != null ? getLocalDate().equals(task.getLocalDate()) : task.getLocalDate() == null;
    }

    @Override
    public int hashCode() {
        int result = getTitleOfTask() != null ? getTitleOfTask().hashCode() : 0;
        result = 31 * result + (getTypeOfTask() != null ? getTypeOfTask().hashCode() : 0);
        result = 31 * result + (getDescriptionOfTask() != null ? getDescriptionOfTask().hashCode() : 0);
        result = 31 * result + (getRepeatability() != null ? getRepeatability().hashCode() : 0);
        result = 31 * result + id;
        result = 31 * result + (getLocalDate() != null ? getLocalDate().hashCode() : 0);
        return result;
    }
}
