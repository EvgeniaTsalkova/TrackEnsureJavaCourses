package flowershop;

import com.sun.media.jfxmediaimpl.HostUtils;

public class Gypsophila extends Flower {

    public Gypsophila(int p, int f, int l){
        super(p, f, l);
    }

    @Override
    public void designation() {
        System.out.println("Gypsophila");
    }
}
