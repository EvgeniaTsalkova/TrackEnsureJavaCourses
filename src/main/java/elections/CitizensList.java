package elections;

import java.io.*;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CitizensList {

    public static List<Citizen> getCitizens() {
        List<Citizen> citizens = null;
        try(ObjectInputStream reader = new ObjectInputStream(new FileInputStream("citizens.txt"))){
            citizens = (List<Citizen>) reader.readObject();
        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return citizens; /* new ArrayList<>(Arrays.asList(
                new Citizen("Name1", 567891, 4499559988L, 1975, 5, false, true, true, "Cons1"),
                new Citizen("Name2", 789435, 8866445500L, 1980, 3, false, false, true, "Cons3"),
                new Citizen("Name3", 893451, 2233009911L, 1996, 2, false, false, true, "Cons4"),
                new Citizen("Name4", 732981, 7711443300L, 2000, 5, false, true, false, " "),
                new Citizen("Name5", 893127, 3311778899L, 1985, 1, false, false, true, "Cons2"),
                new Citizen("Name6", 993126, 1100229933L, 1998, 4, false, false, true, "Cons3"),
                new Candidate("Name7", 763981, 4499002233L, 1969, 6, true, false, true, "Cons1", "Cons1", 4),
                new Citizen("Name8", 893451, 4499330022L, 2005, 1, false, false, true, "Cons2"),
                new Candidate("Name9", 966981, 4399045233L, 1959, 1, false, false, true, "Cons2", "Cons2", 9),
                new Citizen("Name10", 893221, 2438330122L, 2005, 1, false, false, true, "Cons4"),
                new Candidate("Name11", 965481, 5467045233L, 1972, 6, true, false, true, "Cons2", "Cons2", 9),
                new Candidate("Name12", 866981, 2895045233L, 1966, 1, false, false, true, "Cons3", "Cons3", 8),
                new Candidate("Name13", 756981, 4769045231L, 1980, 4, false, false, true, "Cons4", "Cons4", 2),
                new Candidate("Name14", 964321, 4872045233L, 1985, 5, false, true, true, "Cons5", "Cons5", 5),
                new Candidate("Name15", 123981, 2229045233L, 1977, 2, false, false, true, "Cons3", "Cons3", 10),
                new Candidate("Name16", 765981, 4888895234L, 1980, 5, false, true, true, "Cons1", "Cons1", 6),
                new Candidate("Name17", 566986, 3499045224L, 1979, 4, false, false, true, "Cons5", "Cons5", 8),
                new Candidate("Name18", 976982, 2109045233L, 1988, 3, false, false, true, "Cons4", "Cons4", 1),
                new Citizen("Name19", 569781, 4559499988L, 1995, 5, true, true, true, "Cons1"),
                new Citizen("Name20", 783945, 8849945500L, 2015, 3, false, false, true, "Cons3"),
                new Citizen("Name21", 893451, 2049911233L, 1966, 2, false, false, true, "Cons4"),
                new Citizen("Name22", 794583, 8945500849L, 2000, 3, false, true, true, "Cons3"),
                new Citizen("Name23", 893145, 2234993011L, 1946, 2, false, false, true, "Cons4")

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

    public static List<Candidate> getCandidates(){
        List<Citizen> voters = getVoters();
        List<Candidate> candidates = new ArrayList<>();
        for(Citizen citizen: voters){
            if(citizen instanceof Candidate){
                candidates.add((Candidate) citizen);
            }
        }
        return candidates.stream().sorted((c1, c2) -> c2.getRate() - c1.getRate()).collect(Collectors.toList());
    }

    public static List<Citizen> addNewCitizen(Citizen citizen){
        List<Citizen> newList = getCitizens();
        newList.add(citizen);
        return newList;
    }

    public static void writeCitizensToFile(List<Citizen> citizens){
        try(ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream("citizens.txt"))){
            writer.writeObject(citizens);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
