package elections;

public enum Fraction {
    LEFT("Левая"),
    RIGHT("Правая"),
    CENTRE("Центр");

    private String title;

    Fraction(String title){
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
