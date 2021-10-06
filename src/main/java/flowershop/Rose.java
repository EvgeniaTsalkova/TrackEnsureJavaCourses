package flowershop;

public class Rose extends Flower {

    public Rose(int p, int f, int l){
        super(p, f, l);
    }

    @Override
    public void designation() {
        System.out.println("Rose");
    }


}
