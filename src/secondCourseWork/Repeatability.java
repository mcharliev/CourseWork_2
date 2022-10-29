package secondCourseWork;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Repeatability {
    private DateTimeFormatter formatter
            = DateTimeFormatter.ofPattern(
            "dd-MM-yyyy");
    private LocalDate localDateTime;

    public abstract LocalDate showRepeatability();

    public abstract String getDataString();

    public LocalDate getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(String localDateTime) {
        this.localDateTime = LocalDate.parse(localDateTime, formatter);
    }

    public DateTimeFormatter getFormatter() {
        return formatter;
    }

    public void setFormatter(DateTimeFormatter formatter) {
        this.formatter = formatter;
    }

    @Override
    public String toString() {
        return "TimeOfTask: " + localDateTime;
    }
}
