package secondCourseWork;


import java.time.LocalDate;

public class MonthlyRepeatability implements Repeatable{
    public LocalDate showRepeatability(LocalDate localDate) {
        return localDate.plusMonths(1);
    }
}
