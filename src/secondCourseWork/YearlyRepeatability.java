package secondCourseWork;

import java.time.LocalDate;

public class YearlyRepeatability extends Repeatability{
    @Override
    public LocalDate showRepeatability() {
        return getLocalDateTime().plusYears(1);
    }
    @Override
    public String getDataString() {
        return getLocalDateTime().plusYears(1).format(getFormatter());
    }
}
