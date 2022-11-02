package secondCourseWork;


import java.time.LocalDate;

public class WeeklyRepeatability implements Repeatable{

    @Override
    public LocalDate showRepeatability(LocalDate localDate) {
        return localDate.plusWeeks(1);
    }

}
