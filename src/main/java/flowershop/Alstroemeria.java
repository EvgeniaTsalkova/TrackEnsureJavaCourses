package flowershop;

public class Alstroemeria extends Flower {

    public Alstroemeria(int p, int f, int l){
        super(p, f, l);
    }

    @Override
    public void designation() {
        System.out.println("Alstroemeria");
    }
}
