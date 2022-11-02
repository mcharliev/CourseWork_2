package secondCourseWork;

public enum TypeOfTask {
    PERSONAL_TASK("Личная задача"),
    WORK_TASK("Рабочая задача");
    String representation;

    TypeOfTask(String representation) {
        this.representation = representation;
    }

    public String getRepresentation() {
        return representation;
    }

    public void setRepresentation(String representation) {
        this.representation = representation;
    }
}
