package secondCourseWork;

import java.time.LocalDate;

public class OneTimeRepeatability extends Repeatability {
    @Override
    public LocalDate showRepeatability() {
        return getLocalDateTime();
    }

    @Override
    public String getDataString() {
        return getDataString();
    }
}
