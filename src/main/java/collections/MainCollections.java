package collections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MainCollections {
    public static void main(String[] args) {
        Menu menu = new Menu();
        boolean isLoop = true;

        List<Patient> patients = ListOfPatients.getPatients();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while(isLoop) {
                    menu.showMenu();
                    int num = Integer.parseInt(reader.readLine());
                    switch (num) {
                        case 1:
                            System.out.println("Введите диагноз: ");
                            String diagnos = reader.readLine();
                            List<Patient> patientsWithDiagnosis = ListOfPatients.getPatientsWithDiagnosis(patients, diagnos);
                            System.out.println(patientsWithDiagnosis);
                            break;
                        case 2:
                            System.out.println("Введите диапазон номеров карт:");
                            System.out.print("a = ");
                            int a = Integer.parseInt(reader.readLine());
                            System.out.print("b = ");
                            int b = Integer.parseInt(reader.readLine());
                            List<Patient> patientsByCardNumber = ListOfPatients.getPatientsByCard(patients, a, b);
                            System.out.println(patientsByCardNumber);
                            break;
                        case 3:
                            System.out.println("Введите первую цифру телефона: ");
                            System.out.print("first number: ");
                            int n = Integer.parseInt(reader.readLine());
                            char n1 = Integer.toString(n).charAt(0);
                            List<Patient> patientsByNumber = ListOfPatients.getPatientsByNumber(patients, n1);
                            System.out.println(patientsByNumber + " \nКоличество пациентов: " + patientsByNumber.size());
                            break;
                        case 4:
                            Map<String, Long> patientsNumberByDiagnosis = ListOfPatients.getDiagnosesWithNumbers(patients);
                            System.out.println(patientsNumberByDiagnosis);
                            break;
                        case 5:
                            Set<String> diagnosis = ListOfPatients.getDiagnosesWithoutDuplicates(patients);
                            System.out.println(diagnosis);
                            break;
                        case 6:
                            Map<String, Long> diagnosesNumber = ListOfPatients.getDiagnosesNumber(patients);
                            System.out.println(diagnosesNumber);
                            break;
                        case 7:
                            System.out.println("Введите данные нового пациента:");
                            System.out.print("id = ");
                            int id = Integer.parseInt(reader.readLine());
                            System.out.print("name: ");
                            String name = reader.readLine();
                            System.out.print("surname: ");
                            String surname = reader.readLine();
                            System.out.print("patronymic: ");
                            String patronym = reader.readLine();
                            System.out.print("address: ");
                            String address = reader.readLine();
                            System.out.print("phone number: ");
                            int phone = Integer.parseInt(reader.readLine());
                            System.out.print("card number: ");
                            int card = Integer.parseInt(reader.readLine());
                            System.out.print("diagnosis: ");
                            String diagn = reader.readLine();
                            patients = ListOfPatients.addNewPatient(id, name, surname, patronym, address, phone, card, diagn);
                            System.out.println(patients);
                            break;
                        case 8:
                            System.out.println("Введите id пациента для удаления: ");
                            int idRemove = Integer.parseInt(reader.readLine());
                            ListOfPatients.removePatient(patients, idRemove);
                            System.out.println(patients);
                            break;
                        case 9:
                            ListOfPatients.writePatientsToFile(patients);
                            System.out.println("Данные записаны в файл.");
                            break;
                        case 10:
                            List<Patient> patients1 = ListOfPatients.readPatientsFromFile("file.txt");
                            System.out.println(patients1);
                            break;
                        case 0:
                            isLoop = false;
                            break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}
