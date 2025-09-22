
package app.domain.Utilities;

import java.util.concurrent.ThreadLocalRandom;

public class GenerateRandomId {
    public Long generateRandomId(){
        return ThreadLocalRandom.current().nextLong(1, Long.MAX_VALUE + 1);
    }
}
