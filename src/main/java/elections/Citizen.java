package elections;

import java.io.Serializable;

public class Citizen implements Serializable {
    private final String name;
    private int numberOfPassport;
    private long inn;
    private final int yearOfBirth;
    private int pollingStation;
    private boolean specialServices;
    private boolean inQuarantine;
    private String consignmentName;

    public Citizen(String name, int numberOfPassport, long inn, int yearOfBirth, int pollingStation, boolean specialServices, boolean inQuarantine, String cons) {
        this.name = name;
        this.numberOfPassport = numberOfPassport;
           try {
               if (isValidInn(inn)) {
                   this.inn = inn;
               } else {
                   throw new Exception("Введен неверный ИНН.");
               }
           } catch (Exception e){
               e.printStackTrace();
           }
        this.yearOfBirth = yearOfBirth;
        this.pollingStation = pollingStation;
        this.specialServices = specialServices;
        this.inQuarantine = inQuarantine;
        this.consignmentName = cons;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfPassport() {
        return numberOfPassport;
    }

    public long getInn() {
        return inn;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public int getPollingStation() {
        return pollingStation;
    }

    public boolean isSpecialServices() {
        return specialServices;
    }

    public boolean isInQuarantine() {
        return inQuarantine;
    }

    public String getConsignmentName() {
        return consignmentName;
    }

    public boolean isValidInn(long inn){
        int count = 0;
        while(inn != 0){
            inn = inn/10;
            count++;
        }
        return count == 10;
    }

    @Override
    public String toString() {
        return "\n" + "Citizen{" +
                "name='" + name + '\'' +
                ", numberOfPassport=" + numberOfPassport +
                ", inn=" + inn +
                ", yearOfBirth=" + yearOfBirth +
                ", pollingStation=" + pollingStation +
                ", specialServices=" + specialServices +
                ", inQuarantine=" + inQuarantine +
                '}';
    }
}
