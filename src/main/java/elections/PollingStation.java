package elections;


import java.time.YearMonth;
import java.util.List;
import java.util.stream.Collectors;

public class PollingStation {
    private int numberOfStation;
    private String address;
    private List<Citizen> citizens;

    public PollingStation(int numberOfStation, String address, List<Citizen> citizens) {
        this.numberOfStation = numberOfStation;
        this.address = address;
        this.citizens = citizens;
    }

    public int getNumberOfStation() {
        return numberOfStation;
    }

    public String getAddress() {
        return address;
    }

    public List<Citizen> getCitizens() {
        return citizens;
    }

    @Override
    public String toString() {
        return "\n" + "PollingStation{" +
                "numberOfStation=" + numberOfStation +
                ", address='" + address + '\'' +
                ", citizens=" + citizens +
                '}';
    }
}
