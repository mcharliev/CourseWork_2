package secondCourseWork;


import java.time.LocalDate;

public class YearlyRepeatability implements Repeatable{

    @Override
    public LocalDate showRepeatability(LocalDate localDate) {
        return localDate.plusYears(1);
    }
}
