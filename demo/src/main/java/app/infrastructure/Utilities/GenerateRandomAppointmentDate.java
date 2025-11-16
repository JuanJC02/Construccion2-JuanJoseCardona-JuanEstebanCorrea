
package app.infrastructure.Utilities;

import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

public class GenerateRandomAppointmentDate {

    public LocalDateTime generateRandomAppointmentDate() {
        int daysFromNow = ThreadLocalRandom.current().nextInt(1, 31);
        int hour = ThreadLocalRandom.current().nextInt(8, 17);
        int[] minuteOptions = {0, 15, 30, 45};
        int minute = minuteOptions[ThreadLocalRandom.current().nextInt(minuteOptions.length)];

        LocalDateTime date = LocalDateTime.now()
                .plusDays(daysFromNow)
                .withHour(hour)
                .withMinute(minute)
                .withSecond(0)
                .withNano(0);

        return date;
    }
}
