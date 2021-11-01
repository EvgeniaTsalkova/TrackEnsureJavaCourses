package elections;

import java.util.List;
import java.util.Map;


public class Consignment {
    private String name;
    private Fraction fraction;
    private int dateOfCreation;
    private List<Candidate> candidates;
    //private Map<Citizen, Integer> candidates;

    public Consignment(String name, Fraction fraction, int dateOfCreation, List<Candidate> candidates) {
        this.name = name;
        this.fraction = fraction;
        this.dateOfCreation = dateOfCreation;
        this.candidates = candidates;
    }

    public String getName() {
        return name;
    }

    public Fraction getFraction() {
        return fraction;
    }

    public int getDateOfCreation() {
        return dateOfCreation;
    }

    public List<Candidate> getCandidates() {
        return candidates;
    }

    @Override
    public String toString() {
        return "Consignment{" +
                "name='" + name + '\'' +
                ", fraction=" + fraction +
                ", dateOfCreation=" + dateOfCreation +
                ", candidates=" + candidates +
                '}' + "\n";
    }
}
