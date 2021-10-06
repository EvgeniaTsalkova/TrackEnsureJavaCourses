package homeWork;

public class University {
    private UniversityPerson person;
    private  final String name;

    public University(UniversityPerson person, String name){
        this.person = person;
        this.name = name;
    }

    public UniversityPerson getPerson() {
        return person;
    }

    public String getName() {
        return name;
    }

    public void setPerson(UniversityPerson person) {
        this.person = person;
    }

    public void working(){
        System.out.println(person.getClass().getSimpleName()+ " " + name + " " + person.doWork());
    }
}
