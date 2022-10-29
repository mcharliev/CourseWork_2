package secondCourseWork;

public class Task {
    private String titleOfTask;
    private String typeOfTask;
    private String descriptionOfTask;
    Repeatability repeatability;
    public static int id = 1;


    public Task(String titleOfTask,
                String descriptionOfTask,
                String typeOfTask,
                Repeatability repeatability
    ) {
        if (titleOfTask.isEmpty() || titleOfTask == null) {
            throw new RuntimeException("Title of task is unknown");
        } else {
            this.titleOfTask = titleOfTask;
        }
        if (typeOfTask == null || typeOfTask.isEmpty()) {
            throw new RuntimeException("Type of task is unknown");
        } else {
            this.typeOfTask = typeOfTask;
        }
        if (descriptionOfTask.isEmpty() || descriptionOfTask == null) {
            throw new RuntimeException("Description of task is unknown");
        } else {
            this.descriptionOfTask = descriptionOfTask;
        }
        this.repeatability = repeatability;
        id++;
    }

    public Repeatability getRepeatability() {
        return repeatability;
    }

    public void setRepeatability(Repeatability repeatability) {
        this.repeatability = repeatability;
    }

    public String getTitleOfTask() {
        return titleOfTask;
    }

    public void setTitleOfTask(String titleOfTask) {
        this.titleOfTask = titleOfTask;
    }

    public String getTypeOfTask() {
        return typeOfTask;
    }

    public void setTypeOfTask(String typeOfTask) {
        this.typeOfTask = typeOfTask;
    }

    public String getDescriptionOfTask() {
        return descriptionOfTask;
    }

    public void setDescriptionOfTask(String descriptionOfTask) {
        this.descriptionOfTask = descriptionOfTask;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Task.id = id;
    }

    @Override
    public String toString() {
        return "titleOfTask: " + titleOfTask +
                ", typeOfTask: " + typeOfTask +
                ", descriptionOfTask: " + descriptionOfTask +
                "," + repeatability;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;

        Task task = (Task) o;

        if (getTitleOfTask() != null ? !getTitleOfTask().equals(task.getTitleOfTask()) : task.getTitleOfTask() != null)
            return false;
        if (getTypeOfTask() != null ? !getTypeOfTask().equals(task.getTypeOfTask()) : task.getTypeOfTask() != null)
            return false;
        if (getDescriptionOfTask() != null ? !getDescriptionOfTask().equals(task.getDescriptionOfTask()) : task.getDescriptionOfTask() != null)
            return false;
        return getRepeatability() != null ? getRepeatability().equals(task.getRepeatability()) : task.getRepeatability() == null;
    }

    @Override
    public int hashCode() {
        int result = getTitleOfTask() != null ? getTitleOfTask().hashCode() : 0;
        result = 31 * result + (getTypeOfTask() != null ? getTypeOfTask().hashCode() : 0);
        result = 31 * result + (getDescriptionOfTask() != null ? getDescriptionOfTask().hashCode() : 0);
        result = 31 * result + (getRepeatability() != null ? getRepeatability().hashCode() : 0);
        return result;
    }
}
