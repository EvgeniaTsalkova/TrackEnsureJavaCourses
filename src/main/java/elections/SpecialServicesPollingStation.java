package elections;

import java.util.List;
import java.util.stream.Collectors;

public class SpecialServicesPollingStation extends PollingStation{

    public SpecialServicesPollingStation(int numberOfStation, String address, List<Citizen> citizens) {
        super(numberOfStation,address,citizens);
    }

}
