package elections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();

        List<Citizen> citizens = CitizensList.getCitizens();
        List<PollingStation> stations = PollingStationList.getPollingStations();
        List<Consignment> consignments = ConsignmentsList.getConsignments();
        List<Citizen> voters = CitizensList.getVoters();

        Elections elections = new Elections(YearMonth.now().getYear(), YearMonth.now().getMonth(), voters);
        Map<Citizen, Integer> res = elections.voting();

        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))){
            boolean loop = true;
            while(loop){
                menu.showMenu();
                int option = Integer.parseInt(bufferedReader.readLine());
                switch(option){
                    case 1:
                        System.out.println("Введите номер и адрес участка через пробел: ");
                        String data = bufferedReader.readLine();
                        String[] ctzn = data.split("\\s");
                        stations.add(new PollingStation(Integer.parseInt(ctzn[0]), ctzn[1], new ArrayList<>()));
                        break;
                    case 2:
                        citizens.add(menu.newCitizen());
                        break;
                    case 3:
                        System.out.println("Введите данные партии: ");
                        System.out.print("Название: ");
                        String nameOfCons = bufferedReader.readLine();
                        System.out.print("Фракция: ");
                        String fraction = bufferedReader.readLine();
                        System.out.print("Дата создания: ");
                        int date = Integer.parseInt(bufferedReader.readLine());
                        consignments.add(new Consignment(nameOfCons, Fraction.valueOf(fraction), date, new ArrayList<>()));
                        break;
                    case 4:
                        System.out.println("Укажите, что гражданин является кандидатом от определенной партии: ");
                        System.out.print("Введите номер паспорта: ");
                        int num = Integer.parseInt(bufferedReader.readLine());
                        Optional<Citizen> citizen = CitizensList.getVoters().stream().filter(c-> c.getNumberOfPassport() == num)
                                .findFirst();
                        System.out.print("Введите название партии: ");
                        String consName = bufferedReader.readLine();
                        Citizen newCand =  citizen.get();
                        newCand.setConsignmentName(consName);
                        break;
                    case 5:
                        System.out.println("Избирательные участки: ");
                        System.out.println(stations);
                        menu.showOptionsMenu1();
                        break;
                    case 6:
                        System.out.println(citizens);
                        break;
                    case 7:
                        System.out.println("Показать партии: ");
                        System.out.println(ConsignmentsList.getConsignments());
                        break;
                    case 8:
                        break;
                    case 9:
                        break;
                    case 0:
                        System.out.println("Записать данные в файл.");
                        CitizensList.writeCitizensToFile(citizens);
                        PollingStationList.writeStationsToFile(stations);
                        ConsignmentsList.writeConsignmentsToFile(consignments);
                        break;
                    case 10:
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
