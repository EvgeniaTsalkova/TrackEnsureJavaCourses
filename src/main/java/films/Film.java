package films;

public class Film {
    private FilmType type;
    private final String title;

    public Film(FilmType type, String title){
        this.type = type;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public FilmType getType() {
        return type;
    }

    public void setType(FilmType type) {
        this.type = type;
    }

    public int price(int days){
        return type.price(days);
    }

    public int bonus(int days){
        return type.bonus(days);
    }
}
