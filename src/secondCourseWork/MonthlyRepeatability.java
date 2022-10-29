package secondCourseWork;

import java.time.LocalDate;

public class MonthlyRepeatability extends Repeatability{
    @Override
    public LocalDate showRepeatability() {
        return getLocalDateTime().plusMonths(1);
    }
    @Override
    public String getDataString() {
        return getLocalDateTime().plusMonths(1).format(getFormatter());
    }
}
