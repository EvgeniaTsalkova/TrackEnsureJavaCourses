package elections;

import java.util.List;
import java.util.stream.Collectors;

public class QuarantinePollingStation extends PollingStation {

    public QuarantinePollingStation(int numberOfStation, String address, List<Citizen> citizens) {
        super(numberOfStation, address, citizens);
    }

}
