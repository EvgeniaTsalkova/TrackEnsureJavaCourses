package elections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();

        List<Citizen> citizens = CitizensList.getCitizens();

        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))){

            boolean loop = true;
            while(loop){
                menu.showMenu();
                int option = Integer.parseInt(bufferedReader.readLine());
                switch(option){
                    case 1:
                        System.out.println("Введите данные участка через пробел: ");
                        String data = bufferedReader.readLine();
                        String[] ctzn = data.split("\\s");
                        PollingStationList.getPollingStations().add(new PollingStation(Integer.parseInt(ctzn[0]), ctzn[1], new ArrayList<>()));
                        break;
                    case 2:
                        /*System.out.println("Введите данные гражданина для добавления:");
                        System.out.print("Имя: ");
                        String name = bufferedReader.readLine();
                        System.out.print("Номер паспорта: ");
                        int passport = Integer.parseInt(bufferedReader.readLine());
                        System.out.print("ИНН: ");
                        long inn = Long.parseLong(bufferedReader.readLine());
                        System.out.print("Год рождения: ");
                        int year = Integer.parseInt(bufferedReader.readLine());
                        System.out.print("Избирательный участок: ");
                        int station = Integer.parseInt(bufferedReader.readLine());
                        System.out.print("Является военным или сотрудником спецслужб: true/false - ");
                        boolean spServ = Boolean.parseBoolean(bufferedReader.readLine());
                        System.out.print("Находится на карантине: true/false - ");
                        boolean quarant = Boolean.parseBoolean(bufferedReader.readLine());
                        System.out.print("Будет ли голосовать: ");
                        boolean vote = Boolean.parseBoolean(bufferedReader.readLine());
                        System.out.print("За какаую партию голосует: ");
                        String cons = bufferedReader.readLine();
                        citizens.add(new Citizen(name, passport,inn, year, station, spServ, quarant, vote, cons));*/
                        CitizensList.addNewCitizen(menu.newCitizen());
                        break;
                    case 3:
                        System.out.println("Введите данные партии: ");
                        System.out.print("Название: ");
                        String nameOfCons = bufferedReader.readLine();
                        System.out.print("Фракция: ");
                        String fraction = bufferedReader.readLine();
                        System.out.print("Дата создания: ");
                        int date = Integer.parseInt(bufferedReader.readLine());
                        ConsignmentsList.getConsignments().add(new Consignment(nameOfCons, Fraction.valueOf(fraction), date, new ArrayList<>()));
                        break;
                    case 4:
                        System.out.println("Укажите, что гражданин является кандидатом от определенной партии: ");
                        System.out.print("Введите номер паспорта: ");
                        int num = Integer.parseInt(bufferedReader.readLine());
                        Optional<Citizen> citizen = CitizensList.getVoters().stream().filter(c-> c.getNumberOfPassport() == num)
                                .findFirst();
                        System.out.print("Введите название партии: ");
                        String consName = bufferedReader.readLine();
                        Candidate cand = (Candidate) citizen.get();
                        break;
                    case 5: menu.showOptionsMenu1();
                        break;
                    case 6:
                        System.out.println(citizens);
                        break;
                    case 10:// CitizensList.writeCitizensToFile(citizens);
                        loop = false;
                        break;
                }

            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
