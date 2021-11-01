package elections;

import java.io.*;
import java.time.YearMonth;
import java.util.*;
import java.util.stream.Collectors;

public class CitizensList {

    public static List<Citizen> getCitizens() {
        List<Citizen> citizens = null;
        try(ObjectInputStream reader = new ObjectInputStream(new FileInputStream("citizens.txt"))){
            citizens = (List<Citizen>) reader.readObject();
        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return citizens;
        /*return  new ArrayList<>(Arrays.asList(
                new Citizen("Name1", 567891, 4499559988L, 1975, 5, false, true, ""),
                new Citizen("Name2", 789435, 8866445500L, 1980, 3, false, false, ""),
                new Citizen("Name3", 893451, 2233009911L, 1996, 2, false, false, ""),
                new Citizen("Name4", 732981, 7711443300L, 2000, 5, false, true, ""),
                new Citizen("Name5", 893127, 3311778899L, 1985, 1, false, false, ""),
                new Citizen("Name6", 993126, 1100229933L, 1998, 4, false, false, ""),
                new Citizen("Name7", 763981, 4499002233L, 1969, 6, true, false, "Cons1"),
                new Citizen("Name8", 893451, 4499330022L, 2005, 1, false, false, ""),
                new Citizen("Name9", 966981, 4399045233L, 1959, 1, false, false, "Cons2"),
                new Citizen("Name10", 893221, 2438330122L, 2005, 1, false, false, ""),
                new Citizen("Name11", 965481, 5467045233L, 1972, 6, true, false, "Cons2"),
                new Citizen("Name12", 866981, 2895045233L, 1966, 1, false, false, "Cons3"),
                new Citizen("Name13", 756981, 4769045231L, 1980, 4, false, false, "Cons4"),
                new Citizen("Name14", 964321, 4872045233L, 1985, 5, false, true, "Cons5"),
                new Citizen("Name15", 123981, 2229045233L, 1977, 2, false, false, "Cons3"),
                new Citizen("Name16", 765981, 4888895234L, 1980, 5, false, true, "Cons1"),
                new Citizen("Name17", 566986, 3499045224L, 1979, 4, false, false, "Cons5"),
                new Citizen("Name18", 976982, 2109045233L, 1988, 3, false, false, "Cons4"),
                new Citizen("Name19", 569781, 4559499988L, 1995, 5, true, true, ""),
                new Citizen("Name20", 783945, 8849945500L, 2015, 3, false, false, ""),
                new Citizen("Name21", 893451, 2049911233L, 1966, 2, false, false, ""),
                new Citizen("Name22", 794583, 8945500849L, 2000, 3, false, true, ""),
                new Citizen("Name23", 893145, 2234993011L, 1946, 2, false, false, "")
                ));*/
    }

    public static List<Citizen> getVoters()  {
        List<Citizen> citizens = getCitizens();
        List<Citizen> voters = new ArrayList<>();
        for(Citizen citizen : citizens){
            try {
                if ((YearMonth.now().getYear() - citizen.getYearOfBirth()) > 18) {
                    voters.add(citizen);
                } else {
                    throw new Exception();
                }
            } catch (Exception e){
                //System.out.println(citizen.getName() + " младше 18.");
            }
        }
        return voters;
    }

    public static Map<Citizen, Integer> getCandidates(){
        List<Citizen> voters = getVoters();
        Map<Citizen, Integer> candidates = new HashMap<>();
        for(Citizen citizen: voters){
            if(!citizen.getConsignmentName().isEmpty()){
                candidates.put(citizen, new Random().nextInt(10) + 1);
            }
        }
        return candidates.entrySet().stream().sorted(Map.Entry.<Citizen, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }


    public static void writeCitizensToFile(List<Citizen> citizens){
        try(ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream("citizens.txt"))){
            writer.writeObject(citizens);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
