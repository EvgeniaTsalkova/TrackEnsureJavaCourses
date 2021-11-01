package elections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConsignmentsList {
    static List<Consignment> consignments = new ArrayList<>(Arrays.asList(new Consignment("Cons1", Fraction.LEFT, 2002, new ArrayList<>()),
                new Consignment("Cons2", Fraction.RIGHT, 2007, new ArrayList<>()),
                new Consignment("Cons3", Fraction.CENTRE, 2012, new ArrayList<>()),
                new Consignment("Cons4", Fraction.RIGHT, 2005, new ArrayList<>()),
                new Consignment("Cons5", Fraction.LEFT, 2010, new ArrayList<>())));

    static List<Candidate> candidates = CitizensList.getCandidates();

    public static List<Consignment> getConsignments(){
        for (Consignment consignment : consignments) {
            for (Candidate candidate : candidates) {
                if (candidate.getConsignmentName().equals(consignment.getName()))
                    consignment.getCandidates().add(candidate);
            }
        }
        return consignments;
    }

}
