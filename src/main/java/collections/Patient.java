package collections;

import java.io.Serializable;

public class Patient implements Serializable {
    private int id;
    private String name;
    private String surname;
    private String patronymic;
    private String address;
    private int phoneNumber;
    private int cardNumber;
    private String diagnosis;

    public Patient(int id, String name, String surname, String patronymic, String address, int phoneNumber, int numberOfCard, String diagnosis) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.cardNumber = numberOfCard;
        this.diagnosis = diagnosis;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", numberOfCard=" + cardNumber +
                ", diagnosis='" + diagnosis + '\'' +
                '}' + "\n";
    }
}
