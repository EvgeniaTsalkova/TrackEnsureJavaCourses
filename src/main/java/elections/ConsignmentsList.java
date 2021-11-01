package elections;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ConsignmentsList {
    static List<Consignment> consignments = new ArrayList<>(Arrays.asList(new Consignment("Cons1", Fraction.LEFT, 2002, new ArrayList<>()),
                new Consignment("Cons2", Fraction.RIGHT, 2007, new ArrayList<>()),
                new Consignment("Cons3", Fraction.CENTRE, 2012, new ArrayList<>()),
                new Consignment("Cons4", Fraction.RIGHT, 2005, new ArrayList<>()),
                new Consignment("Cons5", Fraction.LEFT, 2010, new ArrayList<>())));

    static Map<Citizen, Integer> candidates = CitizensList.getCandidates();

    public static List<Consignment> getConsignments(){
        for (Consignment consignment : consignments) {
            for (Map.Entry<Citizen, Integer> candidate: candidates.entrySet()) {
                if (candidate.getKey().getConsignmentName().equals(consignment.getName()))
                    consignment.getCandidates().add(candidate.getKey());
            }
        }
        return consignments;
    }

    public static void writeConsignmentsToFile(List<Consignment> consignments){
        try(ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream("consignments.txt"))){
            writer.writeObject(consignments);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
