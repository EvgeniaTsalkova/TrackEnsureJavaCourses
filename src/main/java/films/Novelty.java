package films;

public class Novelty implements FilmType {
    @Override
    public int price(int days) {
        return days * 3;
    }

    @Override
    public int bonus(int days) {
        return (days < 3 ? days * 5 : 15);
    }
}
