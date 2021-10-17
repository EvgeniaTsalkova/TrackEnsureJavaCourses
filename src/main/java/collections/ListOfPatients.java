package collections;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class ListOfPatients {

    public static List<Patient> getPatients() {
        return new ArrayList<>(Arrays.asList(
            new Patient(20, "Ivan", "Turgenev", "Sergeevich", "Krylova 50", 445588, 342, "pancreatitis"),
            new Patient(35, "Aleksandr", "Pushkin", "Sergeevich", "Lazurnaya 4", 415122, 243, "allergy"),
            new Patient(48, "Lev", "Tolstoy", "Nikolaevich", "Kievskaya 8", 354261, 457, "gastritis"),
            new Patient(15, "Nikolay", "Gogol", "Vasilyevich", "Belaya 68", 455678, 178, "allergy"),
            new Patient(56, "Anna", "Achmatova", "Andreevna", "Pushkinskaya 17", 567893, 732, "depression"),
            new Patient(29, "Michail", "Lermontov", "Yuryevich", "Chkalova 77", 534789, 325, "gastritis")));

    }

    public static List<Patient> getPatientsWithDiagnosis(List<Patient> patients, String diagnosis){
        return patients.stream().filter(patient -> patient.getDiagnosis().equals(diagnosis))
                .sorted(Comparator.comparing(Patient::getCardNumber)).collect(Collectors.toList());
    }

    public static List<Patient> getPatientsByCard(List<Patient> patients, int a, int b){
        return patients.stream().filter(patient -> patient.getCardNumber() > a && patient.getCardNumber() < b)
                .collect(Collectors.toList());
    }

    public static List<Patient> getPatientsByNumber(List<Patient> patients, char a){
        return patients.stream()
                .filter(patient -> (String.valueOf(Math.abs(patient.getPhoneNumber())).charAt(0)) == a)
                .collect(Collectors.toList());
    }

    public static Map<String, Long> getDiagnosesWithNumbers(List<Patient> patients){
        Map<String, Long> result = patients.stream().collect(Collectors.groupingBy(Patient::getDiagnosis, Collectors.counting()));
        return result.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }

    public static Set<String> getDiagnosesWithoutDuplicates(List<Patient> patients){
        Set<String> set = new HashSet<>();
        patients.forEach(patient -> set.add(patient.getDiagnosis()));
        return set;
    }

    public static Map<String, Long> getDiagnosesNumber(List<Patient> patients){
        return patients.stream().collect(Collectors.groupingBy(Patient::getDiagnosis, Collectors.counting()));
    }

    public static List<Patient> addNewPatient(int id, String name, String surname, String patronim, String address, int phone, int card, String diagnosis){
        List<Patient> newPatients = getPatients();
        newPatients.add(new Patient(id, name, surname, patronim, address, phone, card, diagnosis));
        return newPatients;
    }

    public static void removePatient(List<Patient> patients, int id){
        patients.removeIf(patient -> patient.getId() == id);
    }

    public static void writePatientsToFile(List<Patient> patients){
        try(ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream("file.txt"))){
            writer.writeObject(patients);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static List<Patient> readPatientsFromFile(String file){
        List<Patient> patients = null;
        try(ObjectInputStream reader = new ObjectInputStream(new FileInputStream(file))){
            patients = (List<Patient>) reader.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return patients;
    }
}
