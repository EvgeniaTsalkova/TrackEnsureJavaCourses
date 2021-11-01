package elections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Menu {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public void showMenu() {
        System.out.println("Выберите пункт:" + "\n" +
                "1 - Добавить участок;" + "\n" +
                "2 - Добавить гражданина;" + "\n" +
                "3 - Добавить партию;" + "\n" +
                "4 - Указать, что гражданин является кандидатом партии;" + "\n" +
                "5 - Показать избирательные участки;" + "\n" +
                "6 - Показать граждан;" + "\n" +
                "7 - Показать партии;" + "\n" +
                "8 - Провести выборы;" + "\n" +
                "9 - Показать результаты выборов;" + "\n" +
                "0 - Сохранить данные в файл;" + "\n" +
                "10 - Выход из программы.");
    }

    public Citizen newCitizen(){
        Citizen citizen = null;
        try {
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
            System.out.print("Название партии, если является кандидатом: ");
            String cons = bufferedReader.readLine();
            citizen = new Citizen(name, passport,inn, year, station, spServ, quarant, cons);
        } catch (IOException e){
            e.printStackTrace();
        }
        return citizen;
    }

    public void showOptionsMenu1(){
        try {
            boolean loop = true;
            while(loop){
                System.out.println("\t5.1 - Просмотр избирателей;" + "\n" +
                        "\t5.2 - Добавить избирателя;" + "\n" +
                        "\t5.3 - Удалить избирателя;" + "\n" +
                        "\t5.4 - Вернуться в главное меню;");
                String opt = bufferedReader.readLine();
                switch(opt){
                    case "5.1":
                        System.out.println("Введите номер участка: ");
                        int stNumber = Integer.parseInt(bufferedReader.readLine());
                        PollingStation ps = PollingStationList.getPollingStations().stream()
                                .filter(s-> s.getNumberOfStation() == stNumber).findAny().get();
                        System.out.println(ps.getCitizens());
                    break;
                    case "5.2":
                        CitizensList.getCitizens().add(newCitizen());
                        break;
                    case "5.3":
                        System.out.println("Введите номер паспорта избирателя для удаления: ");
                        int passport = Integer.parseInt(bufferedReader.readLine());
                        break;
                    case"5.4": loop = false;
                    break;
                }

            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public void showOptionsMenu2(){
        System.out.println("\t7.1 - Просмотр членов партии;" + "\n" +
                "\t7.2 - Добавить члена партии;" + "\n" +
                "\t7.3 - Удалить члена партии;");
    }


}
