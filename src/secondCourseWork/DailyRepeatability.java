package secondCourseWork;


import java.time.LocalDate;

public class DailyRepeatability implements Repeatable {
    @Override
    public LocalDate showRepeatability(LocalDate localDate) {
        return localDate.plusDays(1);
    }
}
