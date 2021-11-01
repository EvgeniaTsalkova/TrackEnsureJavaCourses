package elections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Elections {
    private int year;
    private String month;
    private List<Citizen> voters;

    public Elections(int year, String month, List<Citizen> voters){
        this.year = year;
        this.month = month;
        this.voters = voters;
    }

    public int getYear() {
        return year;
    }

    public String getMonth() {
        return month;
    }

    public List<Citizen> getCitizens() {
        return voters;
    }
}
