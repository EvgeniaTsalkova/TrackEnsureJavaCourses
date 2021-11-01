package elections;

import java.io.Serializable;
import java.util.List;


public class Consignment implements Serializable {
    private final String name;
    private Fraction fraction;
    private final int dateOfCreation;
    private List<Citizen> candidates;

    public Consignment(String name, Fraction fraction, int dateOfCreation, List<Citizen> candidates) {
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

    public List<Citizen> getCandidates() {
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
