package secondCourseWork;

import java.time.LocalDate;

public class DailyRepeatability extends Repeatability {

    @Override
    public LocalDate showRepeatability() {
       return getLocalDateTime().plusDays(1);
    }
    @Override
    public String getDataString() {
      return getLocalDateTime().plusDays(1).format(getFormatter());
    }
}
