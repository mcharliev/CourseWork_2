package secondCourseWork;

import java.time.LocalDate;

public class WeeklyRepeatability extends Repeatability{
    @Override
    public LocalDate showRepeatability() {
        return getLocalDateTime().plusWeeks(1);
    }
    @Override
    public String getDataString() {
        return getLocalDateTime().plusWeeks(1).format(getFormatter());
    }
}
