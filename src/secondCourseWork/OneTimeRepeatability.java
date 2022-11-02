package secondCourseWork;


import java.time.LocalDate;

public class OneTimeRepeatability implements Repeatable {
    @Override
    public LocalDate showRepeatability(LocalDate localDate) {
        return localDate;
    }
}
