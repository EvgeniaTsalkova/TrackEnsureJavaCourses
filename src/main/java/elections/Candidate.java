package elections;

public class Candidate extends Citizen {
    private final String consignmentName;
    private int rate;

    public Candidate(String name, int numberOfPassport, long inn, int yearOfBirth, int pollingStation, boolean specialServices, boolean inQuarantine, boolean readyToVote, String consToVote, String consignmentName, int rate) {
        super(name, numberOfPassport, inn, yearOfBirth, pollingStation, specialServices, inQuarantine, readyToVote,consToVote);
        this.consignmentName = consignmentName;
        this.rate = rate;
    }

    public String getConsignmentName() {
        return consignmentName;
    }

    public int getRate() {
        return rate;
    }

    @Override
    public String toString() {
        return super.toString() +
                 " is Candidate{" +
                "consignmentName='" + consignmentName + '\'' +
                ", rate=" + rate +
                '}';
    }
}
