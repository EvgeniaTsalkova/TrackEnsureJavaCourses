package elections;

import java.time.Month;
import java.util.*;

public class Elections {
    private int year;
    private Month month;
    private List<Citizen> voters;

    public Elections(int year, Month month, List<Citizen> voters){
        this.year = year;
        this.month = month;
        this.voters = voters;
    }

    public int getYear() {
        return year;
    }

    public Month getMonth() {
        return month;
    }

    public List<Citizen> getCitizens() {
        return voters;
    }

    public Map<Citizen, Integer> voting(){
        Map<Citizen, Integer> result = new HashMap<>();
        for(Citizen voter: voters) {
            if (voter.getReadyToVote()){
                int vote = new Random().nextInt(5);
                result.put(voter, vote);
            }
        }
        return result;
    }
}
