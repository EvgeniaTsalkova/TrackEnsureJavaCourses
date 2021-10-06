package homeWork;

public class MainUniversity {
    public static void main(String[] args) {
        University[] persons = {new University(new Teacher(), "Jhon"),
                                new University(new Student(), "Bill"),
                                new University(new LabAssistant(), "Ted")};

        for (University person : persons) {
            person.working();
        }
    }
}
