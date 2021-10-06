package films;

public class Regular implements FilmType {

    @Override
    public int price(int days) {
        return days;
    }

    @Override
    public int bonus(int days) {
        return days;
    }
}
