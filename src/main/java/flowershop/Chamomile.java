package flowershop;

public class Chamomile extends Flower{

    public Chamomile(int p, int f, int l){
        super(p, f, l);
    }

    @Override
    public void designation() {
        System.out.println("Chamomile");
    }
}
