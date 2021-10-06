package films;

public class MainFilm {
    public static void main(String[] args){
        Film[] films = { new Film(new Regular(), "regular"),
                new Film(new Novelty(), "novelty"),
                new Film(new Children(), "children")};

        int[] days = {7, 5, 6};
        int sum = 0;

        for(int i = 0; i < films.length; i++){
            sum += films[i].price(days[i]);
        }

        System.out.println(sum);
    }
}
