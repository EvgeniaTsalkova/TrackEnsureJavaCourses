package elections;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PollingStationList {
    public static List<PollingStation> stations = new ArrayList<>(Arrays.asList(
            new PollingStation(1, "first", new ArrayList<>()),
            new PollingStation(2, "second", new ArrayList<>()),
            new PollingStation(3, "third", new ArrayList<>()),
            new PollingStation(4, "fourth", new ArrayList<>()),
            new QuarantinePollingStation(5, "fifth", new ArrayList<>()),
            new SpecialServicesPollingStation(6, "sixth", new ArrayList<>())));

    public static List<Citizen> voters = CitizensList.getVoters();

    public static List<PollingStation> getPollingStations() {
        for(PollingStation station: stations){
            for(Citizen voter: voters){
                if(voter.getPollingStation()== station.getNumberOfStation())
                    station.getCitizens().add(voter);
            }
        }
        return stations;
    }

    public static void writeStationsToFile(List<PollingStation> stations){
        try(ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream("stations.txt"))){
            writer.writeObject(stations);
        } catch (IOException e){
            e.printStackTrace();
        }
    }


}
